package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;

public class WorkerCreationException extends WorkerException {

    public WorkerCreationException(@NotNull String workerName, @NotNull String message) {
        super(workerName, message);
    }

    public WorkerCreationException(
            @NotNull String workerName,
            @NotNull String message,
            @NotNull Throwable cause) {
        super(workerName, message, cause);
    }
}
