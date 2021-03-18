package ru.geekbrains.HomeWork.Java3.lesson5;

public class Road extends Stage {


    public Road(int length) {
        this.length = length;
        this.counter=0;
        this.name="Участник #";
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c,int i) {
        try {
            System.out.println(i + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(i + " закончил этап: " + description);
            counter++;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}