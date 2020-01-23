package ru.spbstu.amd.java.pipeline.worker;

import org.jetbrains.annotations.NotNull;

public class WorkerCreationException extends WorkerBuilderException {

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
