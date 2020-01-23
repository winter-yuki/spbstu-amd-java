package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;

/**
 * Implementation should have factory method
 * <code>
 * public static Worker of(String confPath, Worker next)
 * </code>
 * where confPath - path to worker's configuration file, next - next worker in execution chain.
 * Throws {@link NoCommonTypesException}
 * if next worker works with types that current worker cannot produce.
 */
public interface Worker extends Consumer {

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
