package ru.spbstu.amd.java.pipeline;

/**
 * Represents pipeline that builds sequence of {@link ru.spbstu.amd.java.pipeline.worker.Worker}s.
 * <ul>
 *     <li>Adds special {@link ru.spbstu.amd.java.pipeline.worker.Worker}
 *     at the beginning execution sequence, than will read input file in loop.</li>
 *     <li>And another one at the end that will write processed data to output file.</li>
 * </ul>
 */
public interface StandalonePipeline extends Runnable {
}
