package ru.spbstu.amd.javaed.pipeline;

/**
 * Represents pipeline that in loop gets data from {@link Producer}
 * via {@link ru.spbstu.amd.javaed.pipeline.Producer.DataAccessor}
 * and passes it through workers.
 * <p>
 * Gets {@link Producer} and first {@link ru.spbstu.amd.javaed.pipeline.worker.Worker} in constructor.
 */
public interface Pipeline extends Runnable {
}
