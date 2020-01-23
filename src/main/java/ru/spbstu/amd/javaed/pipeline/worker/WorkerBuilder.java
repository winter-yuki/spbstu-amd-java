package ru.spbstu.amd.javaed.pipeline.worker;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * <code>
 * Worker workerInstance = WorkerBuilder
 * .init()
 * .withClassName(...)
 * .withConfPath(...)
 * .withNextWorker(...)
 * .build()
 * </code>
 */
public final class WorkerBuilder {

    @NotNull
    public static final String WORKER_FACTORY_METHOD_NAME = "of";

    @Nullable
    final private String className;
    @Nullable
    final private String confPath;
    @Nullable
    final private Worker nextWorker;

    private WorkerBuilder(
            @Nullable final String className,
            @Nullable final String confPath,
            @Nullable final Worker nextWorker) {
        this.className = className;
        this.confPath = confPath;
        this.nextWorker = nextWorker;
    }

    public static WorkerBuilder init() {
        return new WorkerBuilder(null, null, null);
    }

    @NotNull
    public WorkerBuilder withClassName(@NotNull String className) {
        return new WorkerBuilder(className, confPath, nextWorker);
    }

    @NotNull
    public WorkerBuilder withConfPath(@NotNull String confPath) {
        return new WorkerBuilder(className, confPath, nextWorker);
    }

    @NotNull
    public WorkerBuilder withNextWorker(@NotNull Worker nextWorker) {
        return new WorkerBuilder(className, confPath, nextWorker);
    }

    @Nullable String className() {
        return className;
    }

    @Nullable String confPath() {
        return confPath;
    }

    @Nullable Worker nextWorker() {
        return nextWorker;
    }

    boolean isInitialized() {
        return className != null && confPath != null && nextWorker != null;
    }

    /**
     * @return {@link Worker} instance.
     * @throws WorkerCreationException If creation fails.
     */
    @NotNull
    public Worker build() {
        if (!isInitialized()) {
            throw new IllegalStateException(
                    "Some fields are not initialized: " +
                            "worker name = " + className +
                            " confPath = " + confPath +
                            " nextWorker = " + nextWorker
            );
        }

        try {
            Class<?> cls = Class.forName(className);
            Method factory = cls.getMethod(WORKER_FACTORY_METHOD_NAME, String.class, Worker.class);
            return (Worker) factory.invoke(null, confPath, nextWorker);
        } catch (InvocationTargetException
                | NoSuchMethodException
                | IllegalAccessException
                | ClassNotFoundException e) {
            assert className != null;
            throw new WorkerCreationException(className, "Creation via factory failed", e);
        }
    }
}
