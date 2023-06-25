package ru.lessons.tutorial;

import java.math.BigInteger;

public class ifElse {
    public static void main(String[] args) { //если void и написать пустой return, то будет немедленный выход из метода
        boolean weatherIsGood=true;
        if(weatherIsGood) {
            System.out.println("Weather is good");
        } else{
            System.out.println("Weather is bad");
        }
        //вместо этого можно написать:
        System.out.println("Weather is "
                + (weatherIsGood ? "good" : "bad"));

        //цикл
        for (int i=0; i<args.length; i++) {
        System.out.println(args[i]);
        }
        //для обхода всего массива args
        for(String arg:args) {
            System.out.println(arg);
        }

        //Напиши fori и нажми enter, автоматом получится for (int i = 0; i < ; i++)

        //метки
        boolean found=false;
        outer:
        for (String arg:args) {
            for(String arg2:args) {
                if(found) {
                    break outer; //оборвётся помеченный цикл
                }
            }
        }
    }
}
