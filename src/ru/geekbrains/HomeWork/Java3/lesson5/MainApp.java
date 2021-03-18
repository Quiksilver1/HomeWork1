package ru.geekbrains.HomeWork.Java3.lesson5;

public class MainApp {
    public static final int CARS_COUNT = 4;
    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(50), new Tunnel(50), new Road(200));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        cars[0].run();
    }
}
