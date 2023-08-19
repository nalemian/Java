package ru.nalemian.lessons.polymorphism;

public class ExcellentStudent extends Student {
    public ExcellentStudent() {
        this.homework = true;
        this.studentName = "Аня";
    }

    @Override
    public Boolean doHomework() {
        this.getCompletedWork().addAll(this.getNotCompletedWork());
        this.getNotCompletedWork().clear();
        return true;
    }
}
