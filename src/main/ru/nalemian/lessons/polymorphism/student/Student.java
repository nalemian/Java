package ru.nalemian.lessons.polymorphism.student;

import ru.nalemian.lessons.polymorphism.Homework;
import ru.nalemian.lessons.polymorphism.Mark;
import ru.nalemian.lessons.teacher.Knowledge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public abstract class Student {

    private final String studentName;
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

    public Collection<Mark> possibleMarks = new ArrayList<>();

    public Collection<Mark> getPossibleMarks() {
        return possibleMarks;
    }

    public void setPossibleMarks(Collection<Mark> possibleMarks) {
        this.possibleMarks = possibleMarks;
    }

    public String getStudentName() {
        return studentName;
    }

    public Collection<Mark> getMarks() {
        return marks;
    }

    public void doHomework(String lessonTheme, String lessonName) {
        double random = Math.random() * 10;
        if (random >= 5) {
            if (random >= 8) {
                System.out.println("Ученик делает домашку на отлично");
                this.getPossibleMarks().add(new Mark(lessonName, 5, lessonTheme));
            } else {
                System.out.println("Ученик делает домашку на 4");
                this.getPossibleMarks().add(new Mark(lessonName, 4, lessonTheme));
            }
            this.getCompletedWork().addAll(this.getNotCompletedWork());
            this.getNotCompletedWork().clear();
        } else {
            if (random >= 2.5) {
                System.out.println("Ученик делает домашку на 3");
                this.getCompletedWork().addAll(this.getNotCompletedWork());
                this.getNotCompletedWork().clear();
                this.getPossibleMarks().add(new Mark(lessonName, 3, lessonTheme));
            } else {
                System.out.println("Ученик не делает домашку");
                this.getPossibleMarks().add(new Mark(lessonName, 2, lessonTheme));
            }
        }
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