package ru.nalemian.lesson0;

public class palindrom {
    public static void main(String[] args) {
       System.out.println(isPalindrome("Madam, I'm Adam!"));
    }
    public static boolean isPalindrome(String text) {
        String s= text.replaceAll("[^A-Za-z1-9]+", "");
        StringBuilder s2=new StringBuilder(s); //у StringBuilder есть метод reverse
        boolean fin=s.equalsIgnoreCase(s2.reverse().toString()); //игнорирует регистр, привожу к строке, т.к. у s2 класс StringBuilder
        return fin;
    }
}

//public static boolean isPalindrome(String text) {
//    String result = text.replaceAll("[^a-zA-Z0-9]", "");
//    return result.equalsIgnoreCase(new StringBuilder(result).reverse().toString());
//}