package ru.geekbrains.HomeWork.Java2.Lesson5;

import ru.geekbrains.HomeWork.Java2.Lesson5.Methods.FirstMethod;
import ru.geekbrains.HomeWork.Java2.Lesson5.Methods.SecondMethod;

public class AppRun1 {

    static final int size = 10000000;
    static final int h = size / 2;
    static float[] arr = new float[size];


    public static void main(String[] args) {

        FirstMethod firstMethod = new FirstMethod();
        firstMethod.m1(arr, size);

        SecondMethod secondMethod = (arr, size) -> {
            float[] a1 = new float[h];
            float[] a2 = new float[h];
            final int[] time = {0};
            for (int f = 0; f < size; f++) {
                arr[f] = 1f;
            }
            long a = System.currentTimeMillis();

            Thread t1 = new Thread(() -> {

                System.arraycopy(arr, 0, a1, 0, h);
                System.arraycopy(arr, h, a2, 0, h);

                for (int i = 0; i < h; i++) {
                    a1[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

                });

            Thread t2 = new Thread(() -> {

                    for (int i = 0; i < h; i++) {
                        a2[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                    }

                    System.arraycopy(a1, 0, arr, 0, h);
                    System.arraycopy(a2, 0, arr, h, h);

            });

            t1.start();
            t2.start();

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return (System.currentTimeMillis() - a);
        };

        System.out.println(secondMethod.m1(arr, size));
    }
}
