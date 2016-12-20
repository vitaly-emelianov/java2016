package ru.sbt.homework_mutlithreading.ThreadPool;

import ru.sbt.homework_mutlithreading.Context;
import ru.sbt.homework_mutlithreading.ContextImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 14.11.16.
 */
public class ThreadPoolManager {
    private final int poolSize;
    private final BlockingQueue<Runnable> blockingQueue = new BlockingQueue<>();
    private final List<Thread> threads = new ArrayList<>();
    private final ContextImpl context;
    private Runnable callback;

    public ThreadPoolManager(int poolSize, Runnable callback, List<Runnable> runnables) {
        this.poolSize = poolSize;
        submitTasks(runnables);
        this.initAllConsumers();
        this.context = new ContextImpl(callback, runnables);
        this.callback = callback;
    }

    private void initAllConsumers() {
        for (Integer i = 0; i < poolSize; i++) {
            Thread thread = new Thread(new Worker(blockingQueue, i.toString()));
            threads.add(thread);
            thread.start();
        }
    }

    public Context getContext() {
        return context;
    }

    private void submitTasks(List<Runnable> runnables) {
        runnables.forEach(blockingQueue::enqueue);
    }

    private class Worker implements Runnable {

        private String name;
        private BlockingQueue<Runnable> queue;

        public Worker(BlockingQueue<Runnable> blockingQueue, String workerID) {
            this.queue = blockingQueue;
            this.name = workerID;
        }

        @Override
        public void run() {
            if (context.isToFinish()) {
                synchronized (ThreadPoolManager.this) {
                    if (!context.isCallbackCalled()) {
                        context.makeCallbackCalled();
                        context.setInterruptedTaskCount(blockingQueue.size());
                        callback.run();
                    }
                }
            } else {
                while (!blockingQueue.isEmpty()) {
                    Runnable runnable = queue.dequeue();
                    try {
                        runnable.run();
                        context.incrementCompletedTaskCount();
                        System.out.println("Task was completed by " + this.name);
                    } catch (Exception e) {
                        context.incrementFailedTaskCount();
                    }
                }
            }
        }
    }
}