package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;

public interface MutableWorker extends Worker {

    /**
     * Create Worker instance.
     *
     * @param workerClassName Name of class to create.
     * @param confFilePath    Path to worker's config file.
     * @return Worker instance.
     * @throws WorkerCreationException If creation via factory fails.
     */
    static MutableWorker of(@NotNull String workerClassName, @NotNull String confFilePath) {
        return CreationUtils.createWorker(workerClassName, confFilePath);
    }

    /**
     * @param next Next worker to provide processed data to.
     * @throws NoCommonTypesException If next cannot take data types that current worker can provide.
     */
    void setNext(@NotNull Worker next);
}
