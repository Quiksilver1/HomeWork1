package ru.geekbrains.HomeWork.Lesson6;

import java.util.Random;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        int maxDogs=3;
        int maxCats=3;
        int maxAnimals=10;
        Cat[] cats=new Cat[maxCats];
        Dog[] dogs=new Dog[maxDogs];
        String[] names=new String[maxAnimals];
        Float[] jumps=new Float[maxAnimals];
        Float[] swims=new Float[maxAnimals];
        Float[] runs=new Float[maxAnimals];
        Scanner name=new Scanner(System.in);
        Scanner run=new Scanner(System.in);
        Scanner jump=new Scanner(System.in);
        Scanner swim=new Scanner(System.in);

        for (int i=0;i<maxCats;i++) {
            System.out.println("Введите имя кота(кошки) номер " + (i + 1));
            names[i] = name.next();
            System.out.println("Сколько может пробежать кот(кошка) номер " + (i + 1));
            runs[i] = run.nextFloat();
            System.out.println("Как высоко может прыгнуть кот(кошка) номер " + (i + 1));
            jumps[i] = jump.nextFloat();
            System.out.println("Сколько проплывет кот(кошка) номер " + (i + 1));
            swims[i] = swim.nextFloat();

            cats[i]=new Cat(""+names[i],runs[i],jumps[i],swims[i]);

        }

        for (int i=0;i<maxDogs;i++) {
            System.out.println("Введите имя собаки номер " + (i + 1));
            names[i] = name.next();
            System.out.println("Сколько может пробежать собака номер " + (i + 1));
            runs[i] = run.nextFloat();
            System.out.println("Как высоко может прыгнуть собака номер " + (i + 1));
            jumps[i] = jump.nextFloat();
            System.out.println("Сколько проплывет собака номер " + (i + 1));
            swims[i] = swim.nextFloat();


            dogs[i]=new Dog(""+names[i],runs[i],jumps[i],swims[i]);

        }

        System.out.println("Всего котов:"+Cat.getCount());
        System.out.println("Всего собак:"+Dog.getCount());
        System.out.println("Всего животных:"+Animal.getCount());


        for (int i=0;i<maxCats;i++) {
            Random random = new Random();
            saySmth(cats[i]);
            cats[i].run(random.nextInt(300));
            cats[i].jump(random.nextInt(3));
            cats[i].swim(random.nextInt(300));
            System.out.println(cats[i]);
        }
        for (int i=0;i<maxDogs;i++) {
            Random random = new Random();
            saySmth(dogs[i]);
            dogs[i].run(random.nextInt(300));
            dogs[i].jump(random.nextInt(3));
            dogs[i].swim(random.nextInt(300));
            System.out.println(dogs[i]);
        }


    }

    private static void saySmth(Animal animal) {
        animal.voice();
    }
}