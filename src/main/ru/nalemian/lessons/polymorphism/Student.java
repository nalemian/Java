package ru.nalemian.lessons.polymorphism;

import ru.nalemian.lessons.teacher.Knowledge;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Student {
    public Boolean homework;
    public String studentName;

    private Collection<Knowledge> knowledges;

    public Student() {
        this.homework = true;
        this.studentName = "имя";
        this.knowledges = new ArrayList<>();
    }

    public Boolean giveHomework() {
        System.out.println("Домашняя работа");
        return homework;
    }

    public Collection<Knowledge> getKnowledges() {
        return knowledges;
    }

    public void setKnowledges(Collection<Knowledge> knowledges) {
        this.knowledges = knowledges;
    }
}
