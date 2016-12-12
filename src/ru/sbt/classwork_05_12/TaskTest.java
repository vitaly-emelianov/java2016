package ru.sbt.classwork_05_12;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by vitaly on 05.12.16.
 */
public class TaskTest {
    @Test
    public void courses() throws Exception {
        List<Lecture> lectureList = new ArrayList<>();
        lectureList.add(new Lecture("Lec1", new Course("Math", 12, "Petrov"), new Date()));
        lectureList.add(new Lecture("Lec2", new Course("Math", 12, "Petrov"), new Date()));
        lectureList.add(new Lecture("Lec1", new Course("Math101", 12, "Sidorov"), new Date()));

        Set<Course> testSet = new HashSet<>();
        testSet.add(new Course("Math101", 12, "Sidorov"));
        testSet.add(new Course("Math1", 12, "Petrov"));

        assertEquals(testSet, Task.courses(lectureList));

    }

    @Test
    public void lecturesForShortCourse() throws Exception {

    }

    @Test
    public void mostBoring() throws Exception {

    }

    @Test
    public void courseToLectures() throws Exception {

    }

}