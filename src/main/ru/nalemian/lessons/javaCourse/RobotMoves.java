package ru.nalemian.lessons.javaCourse;

public class RobotMoves {

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static class Robot {
        int x;
        int y;
        Direction dir;

        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        public Direction getDirection() {return dir;}

        public int getX() {return x;}

        public int getY() {return y;}

        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }

        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }

        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
            if (robot.getX() < toX) {
                if (robot.getDirection().ordinal() != 3) {
                    while (robot.getDirection().ordinal() != 3) {
                        robot.turnRight();
                    }
                }
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            }
            if (robot.getX() > toX) {
                if (robot.getDirection().ordinal() != 2) {
                    while (robot.getDirection().ordinal() != 2) {
                        robot.turnRight();
                    }
                }
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            }
            if (robot.getY() < toY) {
                if (robot.getDirection().ordinal() != 0) {
                    while (robot.getDirection().ordinal() != 0) {
                        robot.turnRight();
                    }
                }
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            }
            if (robot.getY() > toY) {
                if (robot.getDirection().ordinal() != 1) {
                    while (robot.getDirection().ordinal() != 1) {
                        robot.turnRight();
                    }
                }
                while (robot.getY() != toY) {
                    robot.stepForward();
                }
            }
        System.out.println(robot.getX());
        System.out.println(robot.getY());
    }
}