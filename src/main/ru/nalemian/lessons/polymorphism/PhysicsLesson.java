package ru.nalemian.lessons.polymorphism;

public class PhysicsLesson implements Lesson {
    public String name = "физика";

    @Override
    public String getLessonName() {
        return this.name;
    }

    @Override
    public void schoolSubject() {
        System.out.println("урок '" + this.name + "'" + " начался");
    }

    @Override
    public void start() {
        Lesson physicsLesson = new PhysicsLesson();
        physicsLesson.schoolSubject();
    }
}
