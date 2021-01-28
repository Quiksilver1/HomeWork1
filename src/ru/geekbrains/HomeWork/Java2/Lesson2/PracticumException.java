package ru.geekbrains.HomeWork.Java2.Lesson2;

import ru.geekbrains.HomeWork.Java2.Lesson2.MyException.MyArrayDataException;
import ru.geekbrains.HomeWork.Java2.Lesson2.MyException.MyArraySizeException;


public class PracticumException {

    static String[][] str = {{"8", "3", "4"}, {"7", "7i", "8"}, {"8", "9", "e"} };



    static int lastI = 0;
    static int lastJ = 0;
    static int sum = 0;
    static int[] c=new int[3];

    public static void main(String[] args) throws MyArrayDataException {


        try {
            TestException(str);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            sum=c[0];
            System.out.println("Sum before exception:"+sum);
            throw new MyArrayDataException("Wrong type in arr["+c[1]+"]["+(c[2])+"]");
        }


    }

    public static int[] TestException(String[][] arr) throws MyArraySizeException {
        if (arr[0].length > 4 || arr.length > 4) {
            throw new MyArraySizeException("Length array bigger than four");
        }


        Integer a = 0;
        for (int i = 0; i < arr[0].length; i++) {
            lastI = i;
            for (int j = 0; j < arr.length; j++) {
                lastJ = j;
                c[1] = lastI;
                c[2] = lastJ;
                a = Integer.valueOf(arr[i][j]);
                sum += a;
                c[0]=(sum);
            }
        }
        return c;
    }
}
