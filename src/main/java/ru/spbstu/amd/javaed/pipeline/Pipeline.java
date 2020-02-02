package ru.spbstu.amd.javaed.pipeline;

/**
 * Represents pipeline that in loop gets data from {@link Producer}
 * via {@link ru.spbstu.amd.javaed.pipeline.Producer.DataAccessor}
 * and passes it through workers.
 * <p>
 * Needs {@link Producer} and first {@link ru.spbstu.amd.javaed.pipeline.worker.Worker} to work.
 */
public interface Pipeline extends Runnable {

    /**
     * Get data from {@link Producer} in loop, process it and pass to the first worker in execution chain.
     */
    @Override
    void run();
}
