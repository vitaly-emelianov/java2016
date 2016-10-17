package ru.sbt.classwork_1709;

/**
 * Created by vitaly on 10/17/16.
 */
public class Pair <V1, V2> {
    private final V1 first;
    private final V2 second;

    public Pair(V1 first, V2 second) {
        this.first = first;
        this.second = second;
    }

    public V1 getFirst() {
        return first;
    }

    public V2 getSecond() {
        return second;
    }
}
