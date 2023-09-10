package ru.nalemian.lessons.polymorphism;

public class Mark {
    private final String lessonName;

    private final Integer mark;

    public Mark(String lessonName, int mark) {
        this.lessonName = lessonName;
        this.mark = mark;
    }

    public String getLessonName() {
        return lessonName;
    }

    public Integer getMark() {
        return mark;
    }
}