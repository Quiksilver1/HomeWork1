package ru.geekbrains.HomeWork.Lesson7;


public class String {

    public static void main(java.lang.String[] args) {
        java.lang.String s="I like Java!!!";
        System.out.println(s.charAt(s.length()-1));
        System.out.println(s.endsWith("!!!"));
        System.out.println(s.startsWith("I like"));
        System.out.println(s.contains("Java"));
        System.out.println(s.indexOf("Java"));
        java.lang.String replace = s.replace('a', 'o');
        System.out.println(replace);
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s.substring(7,11));
    }
}