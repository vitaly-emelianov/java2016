package ru.sbt.classwork_1709;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vitaly on 10/17/16.
 */
public class Classwork {
    public Classwork() {
    }

    public static void main(String[] args) {
        Number[] numbers = new Integer[10];
//        List<Number> list = new ArrayList<>();
        // ArrayStoreEXception! - не типобезопасный код, компилируется, но Runtime Error.
//        numbers[0] = 1.24;

        List<Integer> integers = new ArrayList<>();
        List list = integers;


        List<Number> numbers1 = list;
        numbers1.add(1.42342);
        System.out.println(numbers1.get(0));


    }
}
