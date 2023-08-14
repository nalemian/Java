package ru.nalemian.lessons.polymorphism;

public class BadStudent extends Student {
    public BadStudent() {
        this.homework = false;
        this.studentName = "Таня";
    }

    @Override
    public Boolean giveHomework() {
        System.out.println("домашняя работа не сделана");
        return homework;
    }
}
