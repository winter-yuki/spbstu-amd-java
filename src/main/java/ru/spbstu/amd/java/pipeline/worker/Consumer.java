package ru.spbstu.amd.java.pipeline.worker;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface Consumer {

    /**
     * @return Set of types, {@link Consumer} can work with.
     */
    @NotNull Set<Class<?>> possibleInputTypes();
}
