package ru.sbt;

/**
 * Created by vitaly on 9/12/16.
 */
public class Person {
    private final String name; // меняется ссылка только один раз
    public int age; // можно менять в люмбом месте
    protected int kids_number; // Видно в потомках


    public Person(String name, int age, int kids_number) {
        this.name = name;
        this.age = age;
        this.kids_number = kids_number;
    }
}
