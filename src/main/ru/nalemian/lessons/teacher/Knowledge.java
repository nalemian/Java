package ru.nalemian.lessons.teacher;

public class Knowledge {
    private final String lessonName;

    private final String lessonTheme;

    public Knowledge(String lessonName, String lessonTheme) {
        this.lessonName = lessonName;
        this.lessonTheme = lessonTheme;
    }

    public String getLessonName() {
        return this.lessonName;
    }

    public String getLessonTheme() {
        return lessonTheme;
    }
}
