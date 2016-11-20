package ru.sbt.homework_06;

import ru.sbt.homework_06.BlockingQueue;

/**
 * Created by vitaly on 14.11.16.
 */
public class Worker implements Runnable {

    private String name;
    private BlockingQueue<Runnable> queue;

    public Worker(BlockingQueue<Runnable> blockingQueue, String processId) {
        this.queue = blockingQueue;
        this.name = processId;
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
