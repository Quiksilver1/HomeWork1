package ru.geekbrains.HomeWork.Java2.Lesson5.Methods;

public class FirstMethod {

    public static void m1(float[] arr,int size){
        for (int f=0;f<size;f++) {
            arr[f]=1f;
        }
        long a=System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println((System.currentTimeMillis() - a));

    }
}
