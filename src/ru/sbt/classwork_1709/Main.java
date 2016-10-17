package ru.sbt.classwork_1709;


import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by vitaly on 10/17/16.
 */
public class Main<T> {
    public static void main(String[] args) {
        Container<Integer> container = new FixedSizeContainer<>(new Integer[10], 10);
        container.add(123);
        for (Integer el: container.toList()) {
            System.out.println(el);
        }
    }
}
