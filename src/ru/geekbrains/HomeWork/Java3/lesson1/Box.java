package ru.geekbrains.HomeWork.Java3.lesson1;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    protected ArrayList<T> fruits=new ArrayList<>();

    public void addFruit(T fruit){
        this.fruits.add(fruit);
    }

    public ArrayList<T> getBox() {
        return fruits;
    }
    
    public float getWeight() {
        if (fruits.isEmpty()) {
            return 0;
        }
        return fruits.size() * fruits.get(0).getWeight();
    }

    public boolean balance(Box<T> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    public void transfer(Box<T> another) {
        another.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}
