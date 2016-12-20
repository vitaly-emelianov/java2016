package ru.sbt.homework_mutlithreading;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vitaly on 03.12.16.
 */
public interface Context {

    int getCompletedTaskCount();

    int getFailedTaskCount();

    int getInterruptedTaskCount();

    void interrupt();

    boolean isFinished();
}
