package ru.sbt.homework_mutlithreading.homework_06;

/**
 * Created by vitaly on 14.11.16.
 */
public interface CustomQueue<E> {
    public void enqueue(E e);
    public E dequeue();
    public boolean isEmpty();
}
