package ru.geekbrains.HomeWork.Java2.Lesson3;

import java.util.*;

public class Contact {

    private int counts = 1;

    public static Map<Integer, String> contact = new HashMap<>();

    public static void see(){
        for (Map.Entry<Integer, String> item : contact.entrySet()) {
            System.out.printf("Key: %s  Value:%s  \n", item.getKey(),item.getValue());
        }
    }


    public static void add(int callnumber, String lastname) {
        contact.put(callnumber, lastname);
    }


    public static void get(String lastname) {

        for (Map.Entry<Integer, String> item : contact.entrySet()) {
            if(item.getValue().equalsIgnoreCase(lastname)){
                System.out.println("Callnumber "+lastname+" :"+item.getKey());
            }
        }
    }
}






