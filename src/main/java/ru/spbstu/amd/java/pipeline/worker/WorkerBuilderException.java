package ru.spbstu.amd.java.pipeline.worker;

import org.jetbrains.annotations.NotNull;

public class WorkerBuilderException extends RuntimeException {

    @NotNull
    private final String workerName;

    public WorkerBuilderException(@NotNull String workerName, @NotNull String message) {
        super(message);
        this.workerName = workerName;
    }

    public WorkerBuilderException(
            @NotNull String workerName,
            @NotNull String message,
            @NotNull Throwable cause) {
        super(message, cause);
        this.workerName = workerName;
    }

    @NotNull
    public final String workerName() {
        return workerName;
    }
}
