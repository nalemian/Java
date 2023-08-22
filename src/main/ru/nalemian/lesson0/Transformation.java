package ru.nalemian.lesson0;

public class Transformation {
    public static void main(String[] args) {
        int intValue =1024;
        byte byteValue=(byte) intValue; //0, лишние старшие биты отбрасываются
        double pi=3.14;
        int intFromDouble=(int) pi; //3, дробная часть отбрасывается, без округления
        float largeFloat=1e20f;
        int intFromLargeFloat= (int) largeFloat; //слишком большое вещественное превращается в максимальное представимое того же знака
        double largeDouble=1e100;
        float floatFromLargeDouble=(float) largeDouble; //слишком большое double превращается в бесконечность


        long fromString=Long.parseLong("123");
        String fromLong=Long.toString(123);
        String concatenation="area"+51; //автоматическое преобразование


        short maxShortValue=Short.MAX_VALUE; //32767, максимальное значение типа
        float floatInfinity=Float.POSITIVE_INFINITY;
        double doubleNaN=Double.NaN;
        boolean isNaN=Double.isNaN(doubleNaN);

        //АВТОМАТИЧЕСКОЕ ПРЕОБРАЗОВАНИЕ (в порядке очерёдности)
        double d=1d+1f;
        float f=1f*1;
        long l=1L-'0'; // если и этого типа нет, то преобразуется в int
        //ПОЭТОМУ
        byte a=1;
        byte b=2;
        byte c=(byte) (a+b); //нужно явно указать тип byte, т.к. во время сложения а и b преобразуются в int
    }
}
