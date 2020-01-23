package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;

/**
 * Represents worker in execution chain.
 * <p>
 * Implementation should have factory method
 * <code>
 * public static Worker of(String confPath)
 * </code>
 * where confPath - path to worker's configuration file.
 * Throws {@link WorkerCreationException}.
 */
public interface Worker extends Consumer {

    /**
     * Create Worker instance.
     *
     * @param workerClassName Name of class to create.
     * @param confFilePath    Path to worker's config file.
     * @return Worker instance.
     * @throws WorkerCreationException If creation via factory fails.
     */
    @NotNull
    static Worker of(@NotNull String workerClassName, @NotNull String confFilePath) {
        return CreationUtils.createWorker(workerClassName, confFilePath);
    }

    /**
     * Process data and provide result to next worker.
     *
     * @param data     Data to process (sequence of type D).
     * @param producer Data provider (call-side).
     * @param <D>      Input data type (some sequence),
     *                 should be in the set of possible input types.
     * @return Number of processed elements in input sequence.
     * @throws DataProcessingException If data procession fails.
     */
    <D> long work(@NotNull D data, @NotNull Worker producer);
}
