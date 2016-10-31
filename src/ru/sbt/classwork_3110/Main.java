package ru.sbt.classwork_3110;

/**
 * Created by vitaly on 31.10.16.
 */
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();
        System.out.println(calculator.calc(4));
        System.out.println(calculator.calc(3));
        System.out.println(calculator.calc(4));

    }
}
