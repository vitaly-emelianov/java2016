package ru.sbt.classwork_05_12;

/**
 * Created by vitaly on 05.12.16.
 */
public class Course {

    private String name;
    private int length;
    private String lecturer;

    public Course(String name, int length, String lecturer) {
        this.name = name;
        this.length = length;
        this.lecturer = lecturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }
}
