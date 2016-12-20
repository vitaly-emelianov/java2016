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
        this.context = new ContextImpl(callback, runnables);
        this.callback = callback;
        submitTasks(runnables);
        this.initAllConsumers();
    }

    private void initAllConsumers() {
        for (Integer i = 0; i < poolSize; i++) {
            Thread thread = new Thread(new Worker(blockingQueue));
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
        private BlockingQueue<Runnable> queue;

        public Worker(BlockingQueue<Runnable> blockingQueue) {
            this.queue = blockingQueue;
        }

        @Override
        public void run() {
            if (context.isToFinish() || blockingQueue.isEmpty()) {
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
                    } catch (Exception e) {
                        context.incrementFailedTaskCount();
                    }
                }
            }
        }
    }
}