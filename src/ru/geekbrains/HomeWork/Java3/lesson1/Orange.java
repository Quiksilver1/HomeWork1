package ru.geekbrains.HomeWork.Java3.lesson1;

public class Orange extends Fruit {

    private final float weight;

    public Orange() {
        this.weight=1.5f;
    }

    public float getWeight() {
        return weight;
    }

    public static void getName(){
        System.out.println("Orange");
    }

}
