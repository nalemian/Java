package ru.nalemian.lesson0.other;
//пакет по умолчанию - пакет с пустым именем, куда попадают классы, в которых нет директивы package

//import static java.lang.System.*;
public class pack2 {
    //модификаторы доступа
    public static void visibleEverywhere() {} //доступ отовсюду без ограничений
    protected static void inSubclasses() {} //доступ только для классов-наследников и для классов текущего пакета
    static void inPackage() {} //доступ только в пределах пакета
    private void inClass() {} //доступ только в пределах класса
    //protected и private применимы только к вложенным классам
}
