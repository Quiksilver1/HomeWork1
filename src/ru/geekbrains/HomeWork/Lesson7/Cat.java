package ru.geekbrains.HomeWork.Lesson7;

public class Cat {
    private final String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite, boolean satiety) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }


    public void info() {
        System.out.println(this);
    }

    public void eat(Plate plate) {
        if (plate.getFood() >= appetite) {
            System.out.println(name+" is eating...");
            satiety = true;
            plate.decreaseFood(getAppetite());
            appetite = 0;
        }
    }

    public int getAppetite() {
        return appetite;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name=" + name + ", appetite=" + appetite+ ", satiety="+satiety+
                '}';

    }
}