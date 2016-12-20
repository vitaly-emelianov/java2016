package ru.sbt.homework_mutlithreading.ThreadPool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vitaly on 14.11.16.
 */
public class BlockingQueue<E> implements CustomQueue<E> {

    private final Queue<E> elements = new LinkedList<>();

    @Override
    public synchronized void enqueue(E e) {
        elements.add(e);
    }

    @Override
    public synchronized E dequeue() {
        return elements.remove();
    }

    @Override
    public synchronized boolean isEmpty() {
        return elements.isEmpty();
    }

    public synchronized int size() {
        return elements.size();
    }
}
