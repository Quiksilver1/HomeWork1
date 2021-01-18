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

    //@Override
    public String toString() {
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

    //@Override
    public String toString() {
        return "Cat{" +
                "name=" + name + ", appetite=" + appetite+ ", satiety="+satiety+
                '}';

    }
}

public class TestEatCat {

    public static void main(String[] args) {
        Cat[] cats=new Cat[5];
        cats[0] = new Cat("Barsik", 5,false);
        cats[1] = new Cat("Archi", 7,false);
        cats[2] = new Cat("Stich", 8,false);
        cats[3] = new Cat("Kuzya", 2,false);
        Plate plate = new Plate(13);
        plate.info();


        for(int i=0;i<cats.length-1;i++) {
            cats[i].eat(plate);
            plate.info();
            cats[i].info();
        }

        plate.additiveFood(25);
        plate.info();

        for(int i=0;i<cats.length-1;i++) {
            cats[i].eat(plate);
            plate.info();
            cats[i].info();
        }

    }
}


