package ru.nalemian.lessons.polymorphism;

public class MathLesson implements Lesson {
    public String name="математика";
    public MathLesson() {
        this.name="математика";
    }
    @Override
    public void schoolSubject() {
        System.out.println("идёт урок '"+this.name+"'");
    }
}
