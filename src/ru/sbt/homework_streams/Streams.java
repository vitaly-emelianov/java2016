package ru.sbt.homework_streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;

/**
 * Created by vitaly on 11.12.16.
 */
public class Streams<T> {

    private final List<T> list;

    private Streams(List<? extends T> list) {
        this.list = new ArrayList<>(list);
    }

    public static <T> Streams<T> of(List<? extends T> list) {
        return new Streams<T>(list);
    }

    public Streams<T> filter(Predicate<? super T> predicate) {
        List<T> filteredList = new ArrayList<T>();
        for (T t : this.list) {
            if (predicate.test(t)) {
                filteredList.add(t);
            }
        }
        return new Streams<T>(filteredList);
    }

    public <V> Streams<V> transform(Function<? super T, ? extends V> function) {
        List<V> transformedList = new ArrayList<>();
        for (T t : this.list) {
            transformedList.add(function.apply(t));
        }
        return new Streams<V>(transformedList);
    }

    public <K, V> Map toMap(Function<? super T, ? extends K> keyFunction, Function<? super T, ? extends V> valueFunction) {
        Map<K, V> map = new HashMap<>();
        for (T t : this.list) {
            map.put(keyFunction.apply(t), valueFunction.apply(t));
        }
        return map;
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (Integer i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        System.out.println(Streams.of(list)
                .filter((v) -> v % 2 == 0)
                .filter((v) -> v - 4 == 0)
                .toMap((k) -> k * 2, (v) -> v - 23));
    }
}
