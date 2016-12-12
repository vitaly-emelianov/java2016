package ru.sbt.classwork_05_12;

import java.util.Date;

/**
 * Created by vitaly on 05.12.16.
 */
public class Lecture {
    private String subject;

    public Course getCourse() {
        return course;
    }

    private Course course;
    private Date date;

    public Lecture(String subject, Course course, Date date) {
        this.subject = subject;
        this.course = course;
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public Date getDate() {
        return date;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
