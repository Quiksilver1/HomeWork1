package ru.geekbrains.HomeWork.Java2.Lesson3;


import java.util.HashSet;
import java.util.Set;

public class ArraysWithUnic {


    static Set<String> unics=new HashSet<>();
    static int[] counts={0,0,0,0,0,0,0,0,0,0,0,0};

    public static void MakeUnic(String[] arr){
        for (int i=0;i< arr.length;i++) {
            for(int j=0;j< arr.length;j++){
                if(arr[i].equalsIgnoreCase(arr[j])){
                    counts[i]++;
                }
                unics.add(arr[i]);
            }
        }
        for (int i=0;i< arr.length;i++){
            System.out.println("Word["+arr[i]+"] was used "+counts[i]+" times");
        }
        System.out.println(unics);
    }

}
