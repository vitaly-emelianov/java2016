package ru.sbt.homework_mutlithreading.homework_06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 14.11.16.
 */
public class ThreadPoolManager {
    private final int poolSize;
    private final BlockingQueue<Runnable> blockingQueue = new BlockingQueue<>();
    private final List<Thread> threads = new ArrayList<>();

    public ThreadPoolManager(int poolSize) {
        this.poolSize = poolSize;
        this.initAllConsumers();
    }

    private void initAllConsumers() {
        for (Integer i = 0; i < poolSize; i++) {
            Thread thread = new Thread(new Worker(blockingQueue, i.toString()));
            threads.add(thread);
            thread.start();
        }
    }

    public void submitTasks(Runnable... runnables) {
        for (Runnable runnable: runnables) {
            blockingQueue.enqueue(runnable);
        }
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
            while (!blockingQueue.isEmpty()) {
                Runnable runnable = queue.dequeue();
                runnable.run();
                System.out.println("Task was completed by " + this.name);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolManager manager = new ThreadPoolManager(10);
        List<Runnable> runnables = new ArrayList<>();
        runnables.add(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}


