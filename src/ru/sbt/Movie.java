package ru.sbt;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by vitaly on 9/12/16.
 */
public class Movie {
    private final String name;
    private final String director;
    private final Date date;
    private final String type;
    private final double cost;
    private LocalDate now = LocalDate.now();


    public Movie(String name, String director, Date date, double cost) {
        this.name = name;
        this.director = director;
        this.date = date;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }

    public Date getDate() {
        return date;
    }

    public double getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    public double calculatePrice() {

    }
}

