package ru.sbt.classwork_12_12;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 12.12.16.
 */
public class FastReadList<T> {
    private List<T> list = new ArrayList<T>();

    public synchronized void add(T t) {
        list.add(t);
    }

    public synchronized T remove(int i) {
        return list.remove(i);
    }

    public T get(int i) {
        return list.get(i);
    }
}
