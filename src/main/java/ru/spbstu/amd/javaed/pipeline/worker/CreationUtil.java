package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class CreationUtil {

    @NotNull
    static final String WORKER_FACTORY_METHOD_NAME = "of";

    private CreationUtil() {
    }

    /**
     * Create {@link Worker} via reflection.
     *
     * <code>
     * public static W of(String confPath);
     * </code>
     * Where W - some {@link Worker} subclass.
     *
     * @param workerClassName Name of class to create.
     * @param confFilePath    Path to worker's config file.
     * @param <T>             Some {@link Worker} subclass.
     * @return Worker instance.
     * @throws WorkerCreationException If creation via factory fails.
     */
    @NotNull
    static <T extends Worker> T createWorker(
            @NotNull final String workerClassName,
            @NotNull final String confFilePath) {
        try {
            Class<?> cls = Class.forName(workerClassName);
            Method factory = cls.getMethod(WORKER_FACTORY_METHOD_NAME, String.class);
            return (T) factory.invoke(null, confFilePath);
        } catch (InvocationTargetException
                | NoSuchMethodException
                | IllegalAccessException
                | ClassNotFoundException
                | ClassCastException e) {
            throw new WorkerCreationException(workerClassName, "Creation via factory failed", e);
        }
    }
}
