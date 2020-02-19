# LAB 3

Один конвейер - один поток исполнения. Теперь мы хотим научиться запускать параллельно несколько потоков, чтобы архивировать файл быстрее на нескольких ядрах процессора. Будем к этому готовиться.

Ранее у нас был автономный (standalone) конвейер `StandalonePipeline`. Теперь мы хотим в перспективе много конвейеров. Для этого введем еще одну абстракцию, 
[PipelineManager](https://github.com/winter-yuki/spbstu-amd-java/blob/master/src/main/java/ru/spbstu/amd/javaed/pipeline/PipelineManager.java),
который будет собирать конвейеры [Pipeline](https://github.com/winter-yuki/spbstu-amd-java/blob/master/src/main/java/ru/spbstu/amd/javaed/pipeline/Pipeline.java) 
(они не сами собираются) и запускать их в разных потоках. В этой  лабораторной пока `Pipeline` только один.

### Сборка конвейера

Этим занимается `PipelineManager`, он читает конфиг и собирает конвейер.

1. Выстраиваются рабочие последовательно путем присоединения друг к другу.
2. В конец последовательности рабочих добавляется 
[Writer](https://github.com/winter-yuki/spbstu-amd-java/blob/master/src/main/java/ru/spbstu/amd/javaed/pipeline/io/Writer.java).
3. Создается экземпляр 
  [Pipeline](https://github.com/winter-yuki/spbstu-amd-java/blob/master/src/main/java/ru/spbstu/amd/javaed/pipeline/Pipeline.java):
    - который при создании знакомится с 
    [Reader](https://github.com/winter-yuki/spbstu-amd-java/blob/master/src/main/java/ru/spbstu/amd/javaed/pipeline/io/Reader.java)
    через который он будет получать данные из файла (описание знакомства дальше),
    - к тому же он получает ссылку на первого рабочего цепочки, чтобы оттдавать данные дальше.

Картина должна получиться такая, только пока один `Pipeline` и нет разветвлений, остальные добавятся в 4й лабораторной.

[![spbspu-amd-java-lab3.png](https://i.postimg.cc/YSt7S4ff/spbspu-amd-java-lab3.png)](https://postimg.cc/ZWs275QC)

Т.е. пока
```
Reader <- DataAccessor <- Pipeline -> Worker1 -> Worker2 -> ... -> WorkerN -> Writer
```

#### Знакомство `Pipeline` и `Reader`

Класс, реализующий `Producer.DataAccessor` должен быть внутренним к классу, реализующему `Reader`, таким образом, он будет иметь доступ к приватным данным `Reader` и через него `Pipeline` сможет доставать следующие порции данных.

Допустим, в конструктор `Pipeline` передается `Reader`. Теперь нужно из него достать `DataAccessor`, через который можно будет запрашивать следующие порции данных.
```
final Set<Class<?>> possibleTypes = reader.getPossibleOutputTypes();
final Class<?> chosenType = // choose type from possibleTypes
this.dataAccessor = reader.getDataAccessor(chosenType);
```

Такая косвенность поможет нам в 4й лабораторной, когда у одного `Reader` будут просить данные сразу несколько `Pipeline`ов.
    
#### Работа конвейера

У `PipelineManager` есть метод `run()`, который сейчас просто вызывает `pipeline.run()`.

В `run()` у `Pipeline` находится цикл, который 
1. Получает данные через `dataAccessor.get()`.
2. Если они пришли (т.е. `Optional` не пустой), обрабатывает.
3. Обработанные отдает дальше ```firstWorker.work(data, this);```.
4. Работает пока ```dataAccessor.isEnd()``` не вернет `true`.
