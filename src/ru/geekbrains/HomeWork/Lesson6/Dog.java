package ru.geekbrains.HomeWork.Lesson6;

public class Dog extends Animal {

    private static int count;

    public static int getCount() {
        return count;
    }

    public Dog(String name, float run,float jump,float swim) {
        super(name, run,jump,swim);
        count++;
    }

    @Override
    public void voice() {
        System.out.println("Гав!");
    }

    @Override
    public void jump(float jump) {
        if (jump<=this.jump) {
            System.out.println(name+" has jumped "+jump+"!");
        }else{
            System.out.println(name+" doesn't jumped "+jump+"!");
        }
    }

    @Override
    public void swim(float swim) {
        if (swim<=this.swim) {
            System.out.println(name+" finished swim "+swim+"!");
        }else{
            System.out.println(name+" doesn't finished swim "+swim+"!");
        }
    }

    @Override
    public void run(float run) {
        if (run<=this.run) {
            System.out.println(name+" finished run "+run+"!");
        }else{
            System.out.println(name+" doesn't finished run "+run+"!");
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", jump=" + jump +
                ", swim=" + swim + ", run=" + run +'\'' +
                '}';
    }
}