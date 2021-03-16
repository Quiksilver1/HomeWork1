package ru.geekbrains.HomeWork.Java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    static ArrayList<Integer> numbers=new ArrayList<>();
    static Integer[] n={1,2,3};
    Box box;

    public static void main(String[] args) {
        permutation(n,0,1);
        System.out.println(Arrays.toString(n));
        makeAL(n,numbers);
        System.out.println(numbers.toString());

        Box<Apple> box1=new Box<>();
        Box<Apple> box3=new Box<>();
        Box<Orange> box2=new Box<>();
        box1.addFruit(new Apple());
        box1.addFruit(new Apple());
        box3.addFruit(new Apple());
        box3.addFruit(new Apple());
        box2.addFruit(new Orange());
        System.out.println("Box:"+box1.getWeight());
        System.out.println("Box:"+box2.getWeight());
        System.out.println(box1.balance(box3));
        box1.transfer(box3);
        System.out.println("Box:"+box3.getWeight());
        System.out.println("Box:"+box1.getWeight());
    }

    public static <T> void permutation(T[] t, int a, int b){
        T n=t[a];
        t[a]=t[b];
        t[b]=n;
    }

    public static <T> void makeAL(T[] t,ArrayList<T> list){
        for (T tmp:t) {
            list.add(tmp);
        }
    }
}
