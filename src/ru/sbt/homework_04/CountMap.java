package ru.sbt.homework_04;

import java.util.Map;

/**
 * Created by vitaly on 22.10.16.
 */
public interface CountMap<T> {
    public void add(T o);

    public int getCount(T o);

    public int remove(T o);

    public int size();

    public void addAll(CountMap<? extends T> source);

    public Map toMap();

    public void toMap(Map<? super T, Integer> destination);
}
