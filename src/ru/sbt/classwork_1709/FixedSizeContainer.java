package ru.sbt.classwork_1709;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 10/17/16.
 */
public class FixedSizeContainer<E> implements Container<E> {
    private final Object[] objects;
    private int size;

    public FixedSizeContainer(Object[] objects, int size) {
        this.objects = objects;
        this.size = size;
    }

    @Override
    public void add(Object o) {
        this.objects[size++] = o;
    }

    @Override
    public E get(int index) {
        return (E)objects[index];
    }

    @Override
    public void addAll(Container<? extends E> source) {
        for (E element: source.toList()) {
            this.add(element);
        }
    }

    @Override
    public void addInto(Container<? super E> destination) {
        for (int i = 0; i < size; i++) {
            destination.add(this.get(i));
        }
    }

    @Override
    public List toList() {
        List<E> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(this.get(i));
        }
        return list;
    }

    @Override
    public int size() {
        return this.size;
    }
}
