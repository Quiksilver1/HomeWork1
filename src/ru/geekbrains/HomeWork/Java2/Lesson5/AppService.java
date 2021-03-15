package ru.geekbrains.HomeWork.Java2.Lesson5;

public class AppService implements Runnable{

    @Override
    public void run() {
        System.out.println("new thread");
    }
}
