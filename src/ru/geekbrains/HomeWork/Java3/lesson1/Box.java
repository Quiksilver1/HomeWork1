package ru.geekbrains.HomeWork.Java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;
    private String name;

    public Box(String name,ArrayList<T> fruits){
        this.name=name;
        this.fruits=fruits;
    }

    public void addFruit(T fruit){
        this.fruits.add(fruit);
    }

    public String getName() {
        return name;
    }

    public int[] getBox(){
        int[] apples=new int[fruits.size()];
        int[] oranges=new int[fruits.size()];
        int aAmount=0;
        int oAmount=0;
        for (T fruit:fruits) {
            if (fruit.getClass().getName().contains("Apple")) {
                apples[aAmount] = 1;
                aAmount++;
            } else {
                oranges[oAmount] = 1;
                oAmount++;
            }
        }
        if (oAmount>0){
            System.out.println("Box "+this.name+":"+Arrays.toString(oranges));
            return oranges;
        }else if(aAmount>0){
            System.out.println("Box "+this.name+":"+Arrays.toString(apples));
            return apples;
        }else{
            System.out.println("Box "+this.name+":"+"Empty");
            return null;
        }
    }

    public float getWeight() {
        float weight=0;
        for (T fruit : fruits) {
            if (fruit.getClass().getName().contains("Apple") ) {
                weight+=1.0f;
            }else{
                weight+=1.5f;
            }
        }
        return weight;
    }

    public boolean balance(Box<T> another) {
        return Math.abs(this.getWeight() - another.getWeight()) < 0.0001;
    }

    public void transfer(Box<T> another) {
        for (T fruit:this.fruits) {
            another.fruits.add(fruit);
        }
        this.fruits.clear();
        System.out.print("New content ");
        Arrays.toString(another.getBox());
        this.getBox();
    }
}
