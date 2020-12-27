package ru.geekbrains.HomeWork.Lesson1;

public class Lesson1{

    public static void main(String[] args) {

        System.out.println(calc(4,5,6,7));
        System.out.println(task10and20(9,5));
        isPozOrNegative(-4);
        isNegative(-1);
        greeting("Илья");
        Year(2020);

        byte a = 7;
        short b = 18;
        int c = 159;
        long d = -156785L;
        float e = 15.78f;
        double f = 15.781566644646348966124;
        char g = 'a';
        boolean v = true;
        String str = "Это строка";
    }

    public static float calc(float z,float x,float m,float n)
    {
        return(z*(x+(m/n)));
    }

    public static boolean task10and20(int a, int b)
    {
        int s=a+b;
        boolean y=true;
        if (s>=10 && s<=20)
        {
            return y;
        }else{
            return !y;
        }
    }

    public static void isPozOrNegative(int x)
    {
        if(x>=0)
            System.out.println("Число положительное");
        else
            System.out.println("Число отрицательное");
    }

    public static boolean isNegative(int q)
    {
        if(q<0){
            return true;
        }
        return false;
    }

    public static void greeting(String name){
        System.out.println("Привет, "+name+"!");
    }

    public static void Year(int y){
        if(y%4==0 || y%400==0){
            if(y%100!=0){
                System.out.println("Указанный год является високосным");
            }
        }else{
            System.out.println("Указанный год не является високосным");
        }
    }
}



