package ru.sbt.classwork_1709;

import java.util.List;

/**
 * Created by vitaly on 10/17/16.
 */


public interface Container<E> {
    void add(E o);

    E get(int index);

    void addAll(Container<? extends E> source);

    void addInto(Container<? super E> destination);

    List<E> toList();

    int size();
}

