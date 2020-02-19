package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Represents immutable worker in execution chain.
 */
public interface Worker {

    /**
     * Create {@link Worker} instance.
     * <p>
     * Implementation should have factory method
     * <code>
     * /**
     * * @param confFilePath - path to worker's configuration file.
     * * @throws {@link WorkerCreationException}
     * * /
     * public static Worker of(String confFilePath) { ... }
     * </code>
     *
     * @param workerClassName Name of class to create.
     * @param confFilePath    Path to worker's config file.
     * @return {@link Worker} instance.
     * @throws WorkerCreationException If creation via factory fails.
     */
    @NotNull
    static Worker of(@NotNull String workerClassName, @NotNull String confFilePath) {
        return CreationUtil.createWorker(workerClassName, confFilePath);
    }

    /**
     * Process data and provide result to the next worker.
     *
     * @param data     Data to process (sequence of type D).
     * @param producer Data provider (call-side), just reference to recognize it.
     * @return Number of processed elements in input sequence.
     * @throws WorkException            If data procession fails.
     * @throws IllegalArgumentException If provided data type is not expected
     *                                  (type should be from the set of possible input types).
     * @throws IllegalStateException    If next worker was not set.
     */
    long work(@NotNull Object data, @NotNull Object producer);

    /**
     * @return Set of types, {@link Worker} can process.
     */
    @NotNull Set<Class<?>> getPossibleInputTypes();
}
