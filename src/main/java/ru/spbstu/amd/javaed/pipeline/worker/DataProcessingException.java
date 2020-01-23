package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;

public class DataProcessingException extends WorkerException {

    public DataProcessingException(@NotNull String workerName, @NotNull String message) {
        super(workerName, message);
    }

    public DataProcessingException(
            @NotNull String workerName,
            @NotNull String message,
            @NotNull Throwable cause) {
        super(workerName, message, cause);
    }
}
