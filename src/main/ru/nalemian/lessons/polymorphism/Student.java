package ru.nalemian.lessons.polymorphism;

public abstract class Student {
    public Boolean homework;
    public String studentName;

    public Student() {
        this.homework = true;
        this.studentName = "имя";
    }

    public Boolean giveHomework() {
        System.out.println("Домашняя работа");
        return homework;
    }
}
