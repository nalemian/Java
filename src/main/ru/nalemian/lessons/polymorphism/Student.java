package ru.nalemian.lessons.polymorphism;

import ru.nalemian.lessons.teacher.Knowledge;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Student {
    public Boolean homework;
    public String studentName;

    private Collection<Knowledge> knowledges;

    private Collection<Homework> completedWork;

    private Collection<Homework> notCompletedWork;

    public Student() {
        this.homework = true;
        this.studentName = "имя";
        this.knowledges = new ArrayList<>();
        this.completedWork = new ArrayList<>();
        this.notCompletedWork = new ArrayList<>();
    }

    public void doHomework() {
    }

    public Collection<Knowledge> getKnowledges() {
        return knowledges;
    }

    public Collection<Homework> getCompletedWork() {
        return completedWork;
    }

    public Collection<Homework> getNotCompletedWork() {
        return notCompletedWork;
    }

    public void setKnowledges(Collection<Knowledge> knowledges) {
        this.knowledges = knowledges;
    }
}
