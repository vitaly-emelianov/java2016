package ru.sbt.homework_06;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by vitaly on 14.11.16.
 */
public class BlockingQueue<E> implements CustomQueue<E> {

    Queue<E> elements = new LinkedList<>();

    @Override
    public synchronized void enqueue(E e) {
        elements.add(e);
        notifyAll();
    }

    @Override
    public synchronized E dequeue() {
        E e = null;
        while (elements.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException exception) {
                return e;
            }
        }
        e = elements.remove();
        return e;
    }
}
