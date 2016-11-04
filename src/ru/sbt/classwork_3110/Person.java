package ru.sbt.classwork_3110;

/**
 * Created by vitaly on 31.10.16.
 */
public class Person {
    private final String name;

    public void setSurname(String surname) {
        this.surname = surname;
    }

    private String surname;
    private final int age;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return name + " " + surname + " " + age;
    }
}
