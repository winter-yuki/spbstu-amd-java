# LAB 3

Один конвейер - один поток исполнения. Теперь мы хотим научиться запускать параллельно несколько потоков, чтобы архивировать файл быстрее на нескольких ядрах процессора. Будем к этому готовиться.

Для этого введем еще одну абстракцию, 
[PipelineManager](https://github.com/winter-yuki/spbstu-amd-java/blob/master/src/main/java/ru/spbstu/amd/javaed/pipeline/PipelineManager.java),
который будет собирать конвейеры [Pipeline](https://github.com/winter-yuki/spbstu-amd-java/blob/master/src/main/java/ru/spbstu/amd/javaed/pipeline/Pipeline.java) 
(они не сами собираются) и запускать их в разных потоках.

### Сборка конвейера

Этим занимается `PipelineManager`, он читает конфиг и собирает конвейер.

1. Выстраиваются рабочие последовательно путем присоединения друг к другу.
2. В конец последовательности рабочих добавляется 
[Writer](https://github.com/winter-yuki/spbstu-amd-java/blob/master/src/main/java/ru/spbstu/amd/javaed/pipeline/Writer.java).
3. Создается экземпляр 
  [Pipeline](https://github.com/winter-yuki/spbstu-amd-java/blob/master/src/main/java/ru/spbstu/amd/javaed/pipeline/Pipeline.java),
  который при создании знакомится с [Reader](https://github.com/winter-yuki/spbstu-amd-java/blob/master/src/main/java/ru/spbstu/amd/javaed/pipeline/Reader.java),
  через который он будет получать данные из файла. К тому же он получает ссылку на первого рабочего цепочки, чтобы оттдавать данные дальше.
4. Запускается ```pipeline.run()```

Картина должна получиться такая, только пока один `Pipeline`, остальные добавятся в 4й лабораторной.

[![spbspu-amd-java-lab3.png](https://i.postimg.cc/YSt7S4ff/spbspu-amd-java-lab3.png)](https://postimg.cc/ZWs275QC)

#### Знакомство `Pipeline` и `Reader`

    TODO
    
#### Работа конвейера

    TODO
