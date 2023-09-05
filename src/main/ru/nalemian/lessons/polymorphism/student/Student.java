package ru.nalemian.lessons.polymorphism.student;

import ru.nalemian.lessons.polymorphism.Homework;
import ru.nalemian.lessons.polymorphism.Mark;
import ru.nalemian.lessons.teacher.Knowledge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public abstract class Student {

    private final String studentName;
    // TODO знания тоже должны отличаться. ведь тема урока вчера != теме урока сегодня
    private final Collection<Knowledge> knowledges;
    private final Collection<Homework> completedWork;
    private final Collection<Homework> notCompletedWork;

    private final Collection<Mark> marks;

    public Student(String name) {
        this.studentName = name;
        this.marks = new ArrayList<>();
        this.knowledges = new HashSet<>();
        this.completedWork = new ArrayList<>();
        this.notCompletedWork = new ArrayList<>();
    }

    public String getStudentName() {
        return studentName;
    }

    public Collection<Mark> getMarks() {
        return marks;
    }

    public void doHomework() {
        System.out.println("Ученик не делает домашку");
    }

    public void addKnowledge(Knowledge knowledge) {
        this.knowledges.add(knowledge);
    }

    public void addHomework(Homework homework) {
        this.notCompletedWork.add(homework);
    }

    @Deprecated
    public Collection<Knowledge> getKnowledges() {
        return knowledges;
    }

    public Collection<Homework> getCompletedWork() {
        return completedWork;
    }

    public Collection<Homework> getNotCompletedWork() {
        return notCompletedWork;
    }
}
