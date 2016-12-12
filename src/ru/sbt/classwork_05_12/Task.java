package ru.sbt.classwork_05_12;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.emptyMap;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

/**
 * Created by vitaly on 05.12.16.
 */
public class Task {
    public static Set<Course> courses(List<Lecture> lectures) {
        return lectures.stream()
                .map(Lecture::getCourse)
                .collect(toSet());
    }

    //course.length < 20
    public static Set<Lecture> lecturesForShortCourse(List<Lecture> lectures) {
        return lectures.stream()
                .filter(lecture -> lecture.getCourse().getLength() < 20)
                .collect(toSet());
    }

    public static Course mostBoring(List<Lecture> lectures) {
        return lectures.stream().map(lecture -> lecture.getCourse())
                .max((course_1, course_2) -> Integer.compare(course_1.getLength(), course_2.getLength()))
                .get();
    }

    public static Map<Course, List<Lecture>> courseToLectures(List<Lecture> lectures) {
        return lectures.stream()
                .collect(groupingBy(Lecture::getCourse));
    }


}
