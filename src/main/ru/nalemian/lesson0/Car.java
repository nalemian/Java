package ru.nalemian.lesson0;

import java.util.ArrayList;

public class Car {
    int speed;
    int maxSpeed;

    public Car(int speed, int maxSpeed) {
        this.speed = speed;
        this.maxSpeed = maxSpeed;
        System.out.println("Объект готов");

    }

    void start() {
        System.out.println("Я начал ехать");
        System.out.println(speed);
    }

    void stop() {
        System.out.println("Я остановился");
        System.out.println(maxSpeed);
    }

    void setSpeed(int speed) {
        if (speed < maxSpeed) {
            this.speed = speed;
        } else {
            System.out.println("Вы передали слишком большую скорость");
        }
    }

    public static void main(String[] args) {
        var myCar = new Car(100, 500);
        var myCar2 = new Car(10, 50);
        var garage = new Car[2];
        garage[0] = myCar;
        garage[1] = myCar2;
        for (Car car : garage) { //пробегаю по массиву
            car.start();
        }
        var garage2 = new ArrayList<Car>(); //коллекция, там лежат объекты типа ru.lessons.tutorial.Car
        garage2.add(myCar);
        garage2.add(myCar2);
        //myCar.start();
        myCar.stop();
    }
}
