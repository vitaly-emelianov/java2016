package ru.sbt;

/**
 * Created by vitaly on 9/12/16.
 */
public class Person {
    private final String name; // меняется ссылка только один раз, оба поля должны быть проинициализированы
    public final int age; // можно менять в люмбом месте
    //protected int kids_number; // Видно в потомках


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name) {
        this(name, 25); // вызов другого конструктора
    }

    public Person(int age) {
        this("Unknown", age); // вызов другого конструктора
    }

}
