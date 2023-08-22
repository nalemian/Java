package ru.nalemian.lessons.polymorphism.student;

public class ExcellentStudent extends Student {
    public ExcellentStudent(String name) {
        super(name);
    }

    @Override
    public void doHomework() {
        this.getCompletedWork().addAll(this.getNotCompletedWork());
        this.getNotCompletedWork().clear();
    }
}
