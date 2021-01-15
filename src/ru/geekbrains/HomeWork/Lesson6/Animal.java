package ru.geekbrains.HomeWork.Lesson6;

public abstract class Animal {


    protected final String name;
    protected float swim;
    protected final float run;
    protected final float jump;
    private static int count;

    public static int getCount() {
        return count;
    }



    public Animal(String name, float run,float jump,float swim ){
        this.name = name;
        this.run = run;
        this.swim = swim;
        this.jump = jump;
        count++;


    }

    public abstract void voice();
    public abstract void jump(float jump);
    public abstract void swim(float swim);
    public abstract void run(float run);


    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", jump=" + jump +
                ", swim=" + swim + ", run=" + run +'\'' +
                '}';
    }
}

