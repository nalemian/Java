package ru.lessons.tutorial;

import java.math.BigInteger;
import java.util.Arrays; //для Arrays.equals(a,b);

public class arrStr {
    public static void main(String[] arg) {
        BigInteger number;
        number=new BigInteger("123"); //объявление
        //int[] numbers;//объявление массива
        //String[] args;
        //boolean bits[]; //можно ставить [] и так
        int[] numbers=new int[100]; //значение 100 задаётся сразу и потом не меняется
        String[] args=new String[1];
        boolean bits[]=new boolean[0];
        //значения в ячейках задаются автоматически, для чисел - 0, для ссылок - null, для boolean - false

        boolean bit[]=new boolean[]{true, false};
        int[] numb= {1,2,3,4,5}; //так тоже можно

        //действия с массивами
        int arrayLength=numb.length;
        int firstNumber=numb[0];

        int[][] matrix1=new int[2][2];
        int[][] matrix2= {{1,2},{3,4}};
        int[][] triangle={
                {1,2,3,4,5},
                {6,7,8,9},
                {10,11,12},
                {13,14},
                {15}
        };
        int secondRowLength=triangle[1].length;//4

        //сравнение массивов
        int[] a={1,2,3};
        int[] b={4,5,6};
        boolean eq1=a==b; //сравнивает ссылки на объекты a и b
        boolean eq2=a.equals(b); //делает тоже самое
        boolean eq3= Arrays.equals(a,b); //только для одномерных, попарно сравнивает содержимое
        //boolean eq4=Arrays.deepEquals(a,b); //для многомерных

        System.out.println(a); //будет что-то непонятное
        System.out.println(Arrays.toString(a)); //для одномерных
        //System.out.println(Arrays.deepToString(a)); //для многомерных

        //Строки
        String hello="Hello"; //содержимое нельзя менять, изменение приводит к созданию нового объекта
        char[] charArray={'a','b','c'};
        String str=new String(charArray);
        char[] charsFromString=str.toCharArray();

        //действия
        int len=str.length();
        char firstChar= str.charAt(0);
        boolean endsWithTable= str.endsWith("table");
        boolean containsIs=str.contains("Is");
        String s1="";
        String s2="";
        boolean eq=s1.equals(s2); //со строками работает
        System.out.println('A'+"12");
        System.out.println("A"+12);
        System.out.println( 'A'+'1'+"2");
        System.out.println("A" + ('\t' + '\u0003')); //в ' char
    }
    //varargs - аргументы переменной длины
    public static int sumData(int ... nums){ //вместо public static int sumData(int a, int b, int c), т.к. не знаю кол-ва параметров
        int res=0;
        for(int i:nums){
            res+=i;
        }
        return res;
    }
    //вызов - int res = sumData(x, y, z);
}
