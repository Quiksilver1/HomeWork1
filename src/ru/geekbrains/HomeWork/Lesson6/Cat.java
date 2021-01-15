package ru.geekbrains.HomeWork.Lesson6;

public final class Cat extends Animal {

    private static int count;

    public static int getCount() {
        return count;
    }


    public Cat(String name, float run,float jump,float swim) {
        super(name,run,jump,swim);
        this.swim=0;
        count++;
    }


    @Override
    public void voice() {
        System.out.println("Mяу!");
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
        System.out.println("Cats don't liked swimming(");

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
        return "Cat{" +
                "name='" + name + '\'' +
                ", jump=" + jump +
                ", swim=" + swim + ", run=" + run +'\'' +
                '}';
    }
}