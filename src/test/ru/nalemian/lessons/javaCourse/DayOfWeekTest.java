package ru.nalemian.lessons.javaCourse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayOfWeekTest {
    @Test
    void enumTest() {
        for(DayOfWeek day: DayOfWeek.values()) {
            System.out.println(day.ordinal()+" "+day.name()); //ordinal - порядковый номер, начиная с 0
        }
    }
}