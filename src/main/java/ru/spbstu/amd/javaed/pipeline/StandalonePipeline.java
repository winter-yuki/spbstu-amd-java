package ru.spbstu.amd.javaed.pipeline;

import ru.spbstu.amd.javaed.pipeline.worker.Worker;

/**
 * Represents pipeline that builds sequence of {@link Worker}s end runs it.
 * <ul>
 *     <li>Adds special {@link Worker}
 *     at the beginning of execution sequence, that will read input file in loop.</li>
 *     <li>And another one at the end, that will write processed data to output file.</li>
 * </ul>
 */
public interface StandalonePipeline extends Runnable {
}
