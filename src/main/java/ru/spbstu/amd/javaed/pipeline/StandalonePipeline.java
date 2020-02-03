package ru.spbstu.amd.javaed.pipeline;

import ru.spbstu.amd.javaed.pipeline.io.Writer;
import ru.spbstu.amd.javaed.pipeline.worker.Worker;

/**
 * Represents pipeline that builds sequence of {@link Worker}s end runs it.
 *
 * Adds special worker at the end ({@link Writer}) that will write processed data to the output file.
 */
public interface StandalonePipeline extends Runnable {

    /**
     * Read data in loop by portions and provide it
     * to the first {@link Worker} in the execution sequence.
     */
    @Override
    void run();
}
