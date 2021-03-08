package ru.geekbrains.HomeWork.Java3.lesson1;

public class Apple extends Fruit {

    private final float weight;

    public Apple() {
        this.weight=1.0f;
    }

    public float getWeight() {
        return weight;
    }

    public static void getName(){
        System.out.println("Apple");
    }
}
