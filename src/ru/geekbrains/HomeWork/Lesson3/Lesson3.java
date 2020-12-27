package ru.geekbrains.HomeWork.Lesson3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int x;

        Scanner repeat = new Scanner(System.in);
        int r;

        Scanner Word = new Scanner(System.in);
        String o = "apple";


      /*  do {
            Random rand=new Random();
            int w= rand.nextInt(10);

            for (int attempt = 1; attempt < 4; attempt++) {
                System.out.println("Введите число от 0 до 9");
                x = scan.nextInt();
                if (x == w) {
                    System.out.println("Поздравляю, это правильный ответ! Вы угадали с попытки под номером " + attempt);
                    break;
                } else if (x > w) {
                    System.out.println("Загаданное число меньше. Осталось попыток " + (3 - attempt));
                } else {
                    System.out.println("Загаданное число больше.Осталось попыток " + (3 - attempt));
                }
                if(attempt==3 && x!=w) {
                    System.out.println("Вы не угадали");
                }
            }
            System.out.println("Повторить игру еще раз?1-да/0-нет");
            r=repeat.nextInt();
        }while(r!=0);
*/

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        char[] c = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        String[] c1 = {"a", "b", "c", "d", "e", "f", "g", "h", "p", "m", "z", "n", "k", "u", "t"};
        Random randWords = new Random();
        int rw = randWords.nextInt(25);
        String answer = words[rw];
        do {
            for (int y = 0; y < 14; y++) {
                System.out.println("Угадайте загаданное слово");
                c1[y] = scan.next();
                o = c1[y];
                if (c1[y].intern() == words[rw]) {
                    System.out.println("Поздравляю!Вы угадали загаданное слово");
                    break;
                } else {
                    for (int j = 0; j < c1[y].length() - 1 && j < words[rw].length() - 1; j++) {
                        if (c1[y].charAt(j) == answer.charAt(j)) {
                            c[j] = c1[y].charAt(j);
                        }
                    }
                    System.out.println("Вы не угадали, подсказка: совпали буквы");
                    String str = String.valueOf(c);
                    System.out.println(str);
                }
            }
        } while (o.intern() != words[rw]);
    }
}


