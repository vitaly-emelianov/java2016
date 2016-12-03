package ru.sbt.homework_06;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 14.11.16.
 */
public class ThreadPoolManager {
    private final int capacity;
    private final BlockingQueue<Runnable> blockingQueue = new BlockingQueue<>();
    ;
    private final List<Thread> threads = new ArrayList<>();

    public ThreadPoolManager(int capacity) {
        this.capacity = capacity;
        this.initAllConsumers();
    }

    private void initAllConsumers() {
        for (Integer i = 0; i < capacity; i++) {
            Thread thread = new Thread(new Worker(blockingQueue, i.toString()));
            thread.start();
            threads.add(thread);
        }
    }

    public void submitTask(Runnable r) {
        blockingQueue.enqueue(r);
    }

    public static void main(String[] args) throws InterruptedException {
        int capacity = 10;
        ThreadPoolManager manager = new ThreadPoolManager(capacity);
        for (int i = 0; i < capacity; i++) {
            manager.submitTask(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("hello");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}


