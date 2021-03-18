package ru.geekbrains.HomeWork.Java3.lesson5;

public abstract class Stage {
    protected int length;
    protected int counter;
    protected String name;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c, int i);
}

