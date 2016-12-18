package ru.sbt.homework_06;

import com.sun.corba.se.spi.orbutil.threadpool.ThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by vitaly on 14.11.16.
 */
public class ThreadPoolManager {
    private final int poolSize;
    private final BlockingQueue<Runnable> blockingQueue = new BlockingQueue<>();
    private final List<Thread> threads = new ArrayList<>();
    private boolean isEmpty;
    private boolean isInterrupted;

    public ThreadPoolManager(int poolSize) {
        this.poolSize = poolSize;
        this.initAllConsumers();
        isInterrupted = false;
    }

    private void initAllConsumers() {
        for (Integer i = 0; i < poolSize; i++) {
            Thread thread = new Thread(new Worker(blockingQueue, i.toString()));
            threads.add(thread);
            thread.start();
        }
    }

    public void submitTask(Runnable r) {
        blockingQueue.enqueue(r);
    }


    private synchronized boolean isInterrupted() {
        return isInterrupted;
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
            while (true) {
                Runnable runnable = queue.dequeue();
                runnable.run();
                System.out.println("Task was completed by " + this.name);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolManager manager = new ThreadPoolManager(10);

        manager.submitTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting Task A....");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task A Completed....");
            }
        });

        manager.submitTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("Starting Task B....");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task B Completed....");
            }
        });
    }
}


