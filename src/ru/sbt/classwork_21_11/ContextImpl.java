package ru.sbt.classwork_21_11;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vitaly on 21.11.16.
 */
public class ContextImpl implements Context {
    private int failedCount;
    private int successFinishedCount;

    public ContextImpl() {
        this.failedCount = 0;
        this.successFinishedCount = 0;
    }


    @Override
    public int getTotalFinishedTaskCount() {
        return failedCount + successFinishedCount;
    }

    @Override
    public int getFailedTaskCount() {
        return this.failedCount;
    }

    public void incrementFailedTaskCount() {
        this.failedCount += 1;
    }

    @Override
    public int getSuccessFinishedTaskCount() {
        return this.successFinishedCount;
    }

    public void incrementSuccessTaskCount() {
        this.successFinishedCount += 1;
    }

    @Override
    public void stop() {

    }
}
