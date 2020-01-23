package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;

public class WorkerException extends RuntimeException {

    @NotNull
    final String workerName;

    public WorkerException(@NotNull String workerName, @NotNull String message) {
        super(message);
        this.workerName = workerName;
    }

    public WorkerException(
            @NotNull String workerName,
            @NotNull String message,
            @NotNull Throwable cause) {
        super(message, cause);
        this.workerName = workerName;
    }

    @NotNull
    public String workerName() {
        return workerName;
    }
}
