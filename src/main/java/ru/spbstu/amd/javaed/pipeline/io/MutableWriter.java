package ru.spbstu.amd.javaed.pipeline.io;

import org.jetbrains.annotations.NotNull;

/**
 * Represents mutable writer.
 */
public interface MutableWriter extends Writer {

    /**
     * Add reference to provider just to recognize them later.
     *
     * @param provider Instance that will provide data.
     */
    void addProvider(@NotNull Object provider);
}
