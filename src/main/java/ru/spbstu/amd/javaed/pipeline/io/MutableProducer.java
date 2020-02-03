package ru.spbstu.amd.javaed.pipeline.io;

import org.jetbrains.annotations.NotNull;

/**
 * Represents mutable producer.
 */
public interface MutableProducer extends Producer {

    /**
     * @param type Type, that consumer wants to get via
     *             {@link ru.spbstu.amd.javaed.pipeline.io.Producer.DataAccessor}.
     * @return Data accessor for data of chosen type.
     * @throws IllegalArgumentException If type is not from the set of possible output types.
     */
    @NotNull DataAccessor getDataAccessor(@NotNull Class<?> type);
}
