package ru.nalemian.lessons.polymorphism;

import java.time.LocalDate;

public class Homework {

    private final String lessonTheme;

    public Homework(String lessonTheme, String lessonName, LocalDate date) {
        this.lessonTheme = lessonTheme;
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

    public String getLessonTheme() {
        return lessonTheme;
    }
}