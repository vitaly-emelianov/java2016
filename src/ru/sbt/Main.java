package ru.sbt;

import java.lang.*;
import java.util.ArrayList;


/**
 * Created by vitaly on 9/12/16.
 */
public class Main {
    public static void main(String[] args) {
        int x = 10;
        run(x);
        System.out.println(x);

        String line = "hello";
        String concat = line.concat("WORLD")
                .replace("o", "f")
                .toLowerCase();
        // Ctrl + Q - вызов документации

        StringBuilder builder = new StringBuilder("Hello");
        String result = builder.append("WORLD") // не копируются, потом приводим к String
                .append("!")
                .append("DDF")
                .toString();
    }

    public <T>  T plus(T arg1, T arg2) {
        if (arg1 instanceof String && arg2 instanceof String) {
            return arg1 + arg2;
        }
    }

    public static void run(int x) { // передается копия (ссылки, примитивного типа)
        x = 12; //
    }
}
