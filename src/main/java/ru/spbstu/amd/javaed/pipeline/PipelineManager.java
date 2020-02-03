package ru.spbstu.amd.javaed.pipeline;

import ru.spbstu.amd.javaed.pipeline.io.Reader;
import ru.spbstu.amd.javaed.pipeline.io.Writer;

/**
 * Builds {@link Pipeline} (or many) and provides {@link Reader} and {@link Writer} to it.
 */
public interface PipelineManager extends Runnable {

    /**
     * Start N threads with N {@link Pipeline}s inside.
     */
    @Override
    void run();
}
