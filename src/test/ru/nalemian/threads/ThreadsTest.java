package ru.nalemian.threads;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreadsTest {
    /*
        здесь проверяется, работают ли потоки
     */
    @Test
    void testThatThreadsAreWorkingRight() {
        Thread2 thread2 = new Thread2();
        Thread1 thread1 = new Thread1(thread2);
        thread1.start();
        thread2.start();
        assertEquals(thread2.getCheckOut(), true);
    }
}