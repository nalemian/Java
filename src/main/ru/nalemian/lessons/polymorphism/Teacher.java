package ru.nalemian.lessons.polymorphism;

public class Teacher {
    public void teaching() {
        System.out.println("Я обучаю!");
    }
    public void startLesson(String lessonName) {
        System.out.println("начинаю урок");
    }
    public void askHomework(Student student, String name) {
        System.out.println("спрашиваю домашнее задание");
    }
}
