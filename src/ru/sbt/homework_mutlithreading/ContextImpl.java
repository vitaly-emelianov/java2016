package ru.sbt.homework_mutlithreading;

import ru.sbt.homework_mutlithreading.ThreadPool.ThreadPoolManager;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vitaly on 20.12.16.
 */
public class ContextImpl implements Context {

    private final AtomicInteger completedTaskCount;
    private final AtomicInteger failedTaskCount;
    private final AtomicInteger interruptedTaskCount;
    private boolean toFinish;
    private boolean callbackCalled;

    public boolean isCallbackCalled() {
        return callbackCalled;
    }

    public void makeCallbackCalled() {
        callbackCalled = true;
    }

    public boolean isToFinish() {
        return toFinish;
    }

    public ContextImpl(Runnable callback, List<Runnable> runnables) {
        this.completedTaskCount = new AtomicInteger(0);
        this.failedTaskCount = new AtomicInteger(0);
        this.interruptedTaskCount = new AtomicInteger(0);
        this.toFinish = false;
        this.callbackCalled = false;
    }

    @Override
    public int getCompletedTaskCount() {
        return completedTaskCount.get();
    }

    public void incrementCompletedTaskCount() {
        completedTaskCount.incrementAndGet();
    }

    @Override
    public int getFailedTaskCount() {
        return failedTaskCount.get();
    }

    public void incrementFailedTaskCount() {
        completedTaskCount.incrementAndGet();
    }

    @Override
    public int getInterruptedTaskCount() {
        return interruptedTaskCount.get();
    }

    public void setInterruptedTaskCount(int count) {
        interruptedTaskCount.set(count);
    }

    @Override
    public synchronized void interrupt() {
        this.toFinish = true;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
