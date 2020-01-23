package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;

public class NoCommonTypesException extends WorkerException {

    public NoCommonTypesException(
            @NotNull String workerName,
            @NotNull String nextWorkerName,
            @NotNull String message) {
        super(combineNames(workerName, nextWorkerName), message);
    }

    public NoCommonTypesException(
            @NotNull String workerName,
            @NotNull String nextWorkerName,
            @NotNull String message,
            @NotNull Throwable cause) {
        super(combineNames(workerName, nextWorkerName), message, cause);
    }

    private static String combineNames(
            @NotNull final String workerName,
            @NotNull final String nextWorkerName) {
        return workerName + " -> " + nextWorkerName;
    }
}
