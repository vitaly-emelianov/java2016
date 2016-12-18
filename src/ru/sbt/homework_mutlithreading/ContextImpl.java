package ru.sbt.homework_mutlithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by vitaly on 03.12.16.
 */
public class ContextImpl implements Context {
    private final List<Thread> workers;
    private final List<Runnable> tasks;
    private final Runnable callback;
    private boolean isFinished;
    private final AtomicInteger completedTaskCount;
    private final AtomicInteger failedTaskCount;
    private final AtomicInteger finishedWorkers;

    ContextImpl(Runnable callback, Runnable... runnables) {
        this.callback = callback;
        tasks = Arrays.stream(runnables).collect(Collectors.toList());
        completedTaskCount = new AtomicInteger();
        failedTaskCount = new AtomicInteger();
        finishedWorkers = new AtomicInteger();
        workers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            workers.add(new Thread(new Worker()))   ;
        }
        workers.forEach(Thread::start);


    }

    @Override
    public int getCompletedTaskCount() {
        return completedTaskCount.get();
    }

    @Override
    public int getFailedTaskCount() {
        return failedTaskCount.get();
    }

    @Override
    public int getInterruptedTaskCount() {
        return 0;
    }

    @Override
    public synchronized boolean isFinished() {
        return isFinished;
    }

    @Override
    public void interrupt() {

    }

    private synchronized boolean isEmpty() {
        return tasks.isEmpty();
    }

    private synchronized Runnable getTask() {
        return tasks.isEmpty() ? null : tasks.remove(0);
    }

    private void incrementCompletedTaskCount() {
        completedTaskCount.incrementAndGet();
    }

    private void incrementFailedTaskCount() {
        failedTaskCount.incrementAndGet();
    }

    private synchronized boolean allWorkersFinished() {
        finishedWorkers.incrementAndGet();
        return workers.size() == finishedWorkers.get();
    }

    private class Worker implements Runnable {
        @Override
        public void run() {
            while (!isFinished() || !isEmpty()) {
                Runnable task = getTask();
                if (task != null) {
                    try {
                        task.run();
                        incrementCompletedTaskCount();
                    } catch (Exception e) {
                        incrementFailedTaskCount();
                    }
                } else {
                    break;
                }
            }
            if (allWorkersFinished()) {
                callback.run();
            }
        }
    }

}