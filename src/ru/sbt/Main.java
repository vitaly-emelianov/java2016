package ru.sbt;

/**
 * Created by vitaly on 9/12/16.
 */
public class Main {
    public static void main(String[] args) {
        int x = 10;
        run(x);
        System.out.println(x);
    }

    public static void run(int x) { // передается копия (ссылки, примитивного типа)
        x = 12; //
    }
}
