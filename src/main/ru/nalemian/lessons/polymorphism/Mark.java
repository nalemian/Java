package ru.nalemian.lessons.polymorphism;

public class Mark {
    private final String lessonName;

    private final String lessonTheme;

    private final Integer mark;

    public Mark(String lessonName, int mark, String lessonTheme) {
        this.lessonName = lessonName;
        this.mark = mark;
        this.lessonTheme = lessonTheme;
    }

    public String getLessonName() {
        return lessonName;
    }

    public String getLessonTheme() {
        return lessonTheme;
    }

    public Integer getMark() {
        return mark;
    }
}