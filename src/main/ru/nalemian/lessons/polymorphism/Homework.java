package ru.nalemian.lessons.polymorphism;

import java.time.LocalDate;

public class Homework {
    public Homework(String lessonName, LocalDate date) {
        this.lessonName = lessonName;
        this.date = date;
    }

    public String getLessonName() {
        return lessonName;
    }

    public LocalDate getDate() {
        return date;
    }


    private final String lessonName;
    private final LocalDate date;


}