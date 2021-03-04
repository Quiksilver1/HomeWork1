package ru.geekbrains.HomeWork.Lesson7;

public class Plate {

    private int food;
    private int additive;

    public Plate(int food) {
        this.food = food;
    }

    public void info() {
        System.out.println(this);
    }

    @Override
    public java.lang.String toString() {
        return "Plate{" +
                "food=" + food +
                '}';
    }

    public int getFood() {
        return food;
    }

    public void additiveFood(int additive) {
        System.out.println("Additive:" +additive);
        this.food = food+additive;
    }

    public void decreaseFood(int appetite) {
        if(this.food>=appetite){
            this.food -= appetite;
        }
    }
}
