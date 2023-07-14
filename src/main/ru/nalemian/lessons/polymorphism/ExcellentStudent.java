package ru.nalemian.lessons.polymorphism;

public class ExcellentStudent extends Student {
    public ExcellentStudent() {
        this.homework = true;
        this.studentName = "Аня";
    }

    @Override
    public void giveHomework() {
        System.out.println("домашняя работа сделана!");
    }
}
