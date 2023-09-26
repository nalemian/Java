package ru.nalemian.threads;

public class Threads {
    public static void main(String[] args) {
        Thread2 thread2 = new Thread2();
        Thread1 thread1 = new Thread1(thread2);
        thread1.start();
        thread2.start();
    }
}