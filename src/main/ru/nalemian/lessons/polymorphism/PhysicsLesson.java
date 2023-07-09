package ru.nalemian.lessons.polymorphism;

public class PhysicsLesson implements Lesson {
    public String name="физика";
    public PhysicsLesson() {
        this.name="физика";
    }
    @Override
    public void schoolSubject() {
        System.out.println("идёт урок '"+this.name+"'");
    }
}
