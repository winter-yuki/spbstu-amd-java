package ru.spbstu.amd.javaed.pipeline.io;

import org.jetbrains.annotations.NotNull;
import ru.spbstu.amd.javaed.pipeline.worker.WorkerException;

public class WriteException extends WorkerException {

    public WriteException(@NotNull String workerName, @NotNull String message) {
        super(workerName, message);
    }

    public WriteException(
            @NotNull String workerName,
            @NotNull String message,
            @NotNull Throwable cause) {
        super(workerName, message, cause);
    }
}
