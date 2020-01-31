package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;

/**
 * Represents mutable worker.
 * <p>
 * Implementation should have factory method
 * <code>
 * public static MutableWorker of(String confPath) { ... }
 * </code>
 * where confPath - path to worker's configuration file.
 * Throws {@link WorkerCreationException}.
 */
public interface MutableWorker extends Worker {

    /**
     * Create {@link MutableWorker} instance.
     *
     * @param workerClassName Name of class to create.
     * @param confFilePath    Path to worker's config file.
     * @return {@link MutableWorker} instance.
     * @throws WorkerCreationException If creation via factory fails.
     */
    static MutableWorker of(@NotNull String workerClassName, @NotNull String confFilePath) {
        return CreationUtil.createWorker(workerClassName, confFilePath);
    }

    /**
     * @param next Next worker to provide processed data to.
     * @throws NoCommonTypesException If next cannot process data types that current worker can provide.
     */
    void setNext(@NotNull Worker next);
}
