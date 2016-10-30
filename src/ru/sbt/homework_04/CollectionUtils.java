package ru.sbt.homework_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vitaly on 22.10.16.
 */
public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static <T> List limit(List<? extends T> source, int size) {
        return source.subList(0, size);
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? extends T> removeFrom, List<? super T> c2) {
        for (T o : removeFrom) {
            c2.add(o);
            removeFrom.remove(o);
        }
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        for (T o : c2) {
            if (c1.contains(o)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<? super T>> List range(List<? extends T> list, T min, T max) {
        List<T> sublist = new ArrayList<>();
        for (T o : list) {
            if (o.compareTo(min) >= 0 && o.compareTo(max) <= 0) {
                sublist.add(o);
            }
        }
        return sublist;
    }

    public static <T> List range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> sublist = new ArrayList<>();
        for (T o : list) {
            if (comparator.compare(o, min) >= 0 && comparator.compare(o, max) <= 0) {
                sublist.add(o);
            }
        }
        return sublist;
    }


    public static void main(String[] args) {
        CollectionUtils utils = new CollectionUtils();
        System.out.println(utils.range(Arrays.asList(8, 1, 3, 5, 6, 4), 3, 6));
    }

}