package ru.geekbrains.HomeWork.Java2.Lesson3;

import java.util.*;

public class Phonebook {


    public static void main(String[] args) {

        int min = 10;
        int max = 1000000;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff);

        Contact.add((random.nextInt(i)), "Zaicev");
        Contact.add((random.nextInt(i)), "Ivanov");
        Contact.add((random.nextInt(i)), "Petrov");
        Contact.add((random.nextInt(i)), "Sidorov");
        Contact.add((random.nextInt(i)), "Antonov");
        Contact.add((random.nextInt(i)), "Ivanov");
        Contact.see();

        Contact.get("Ivanov");

    }
}


