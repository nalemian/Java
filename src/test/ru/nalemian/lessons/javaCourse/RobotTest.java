package ru.nalemian.lessons.javaCourse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.nalemian.lessons.javaCourse.RobotMoves.moveRobot;

class RobotTest {
    @Test
    void testForRobot(){
        RobotMoves.Robot robot = new RobotMoves.Robot(0,0, RobotMoves.Direction.DOWN);
        moveRobot(robot, -10, 20);
    }
}