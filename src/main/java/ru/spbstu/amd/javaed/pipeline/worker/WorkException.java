package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;

public class WorkException extends WorkerException {

    public WorkException(@NotNull String workerName, @NotNull String message) {
        super(workerName, message);
    }

    public WorkException(
            @NotNull String workerName,
            @NotNull String message,
            @NotNull Throwable cause) {
        super(workerName, message, cause);
    }
}
