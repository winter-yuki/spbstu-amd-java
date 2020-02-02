package ru.spbstu.amd.javaed.pipeline;

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
