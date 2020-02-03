package ru.spbstu.amd.javaed.pipeline.io;

import org.jetbrains.annotations.NotNull;
import ru.spbstu.amd.javaed.pipeline.worker.Worker;

/**
 * Writes incoming data to file. Last {@link Worker} in execution sequence.
 */
public interface Writer extends Worker {

    /**
     * Write data to file.
     *
     * @param data     Data to process (sequence of type D).
     * @param producer Data provider (call-side), just reference to recognize it.
     * @return Just length of data sequence.
     * @throws WriteException If io error occurred.
     */
    @Override
    long work(@NotNull Object data, @NotNull Object producer);
}
