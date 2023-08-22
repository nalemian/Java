package ru.nalemian.lessons.polymorphism;

public class MathLesson implements Lesson {
    public String name = "математика";
    public Boolean lessonIsOver = false;

    @Override
    public String getLessonName() {
        return this.name;
    }

    @Override
    public Boolean getLessonIsOver() {
        return this.lessonIsOver;
    }

    @Override
    public void schoolSubject() {
        System.out.println("урок '" + this.name + "'" + " начался");
    }

    @Override
    public void start() {
        Lesson mathLesson = new MathLesson();
        mathLesson.schoolSubject();
        this.lessonIsOver = true;
    }
}
