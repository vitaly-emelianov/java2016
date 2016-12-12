package ru.sbt.homework_mutlithreading;

/**
 * Created by vitaly on 03.12.16.
 */
public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}
