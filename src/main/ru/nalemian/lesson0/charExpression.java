package ru.nalemian.lesson0;

public class charExpression {
    public static char charExp(int a) {
        char charValue='\\';
        a+=charValue;
        var helloWorld=new HelloWorld();
        helloWorld.test();
        Object helloWorld2=new HelloWorld();
        ((HelloWorld) helloWorld2).test();
        return (char) a;
    }
}
