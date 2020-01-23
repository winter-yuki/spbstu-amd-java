package ru.spbstu.amd.java.pipeline;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface Producer {

    @NotNull DataAccessor getAccessor(@NotNull Set<Class<?>> acceptableOutputDataTypes);

    interface DataAccessor {

        @NotNull Object get();
    }
}
