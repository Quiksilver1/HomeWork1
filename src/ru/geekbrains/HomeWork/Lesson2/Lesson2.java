package ru.geekbrains.HomeWork.Lesson2;

import java.util.Arrays;

public class Lesson2 {

    public static void main(String[] args) {

            //Первое задание
            int[] arr = {1, 0, 1, 1, 0, 1, 0, 0, 1, 1};
            System.out.println(Arrays.toString(arr));

            for (
                    int i = 0;
                    i < arr.length; i++) {
                if (arr[i] == 0) {
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
            }
            System.out.println(Arrays.toString(arr));

        /*
        static void change(int[] arr)
        {
            for(int i=0;i<inputArray.length;i++)
            {
                arr[i]=(arr[i]==1)?0:1;-как вариант
                arr[i]=1-arr[i];-лучше так
             }
         }
         */



            //Второе задание
            int[] arr2 = new int[8];
            for (
                    int j = 1;
                    j < arr2.length; j++) {
                arr2[j] = arr2[j - 1] + 3;//arr2[j]=j*3;
            }
            System.out.println(Arrays.toString(arr2));

            //Третье задание
            int[] bigarr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
            for (
                    int k = 0;
                    k < bigarr.length; k++) {
                if (bigarr[k] < 6) {
                    bigarr[k] = bigarr[k] * 6;
                }
            }
            System.out.println(Arrays.toString(bigarr));

            //Четвертое задание
            int sr = 10;
            int sb = 10;
            int[][] sq = new int[sr][sb];
        /*
        for(int i=0;i<sq.length;i++)
        {
            sq[i][i]=1;
            sq[i][sq[i].length-1-i]=1;
         */
            for (
                    int n = 0;
                    n < sr; n++) {
                for (int m = 0; m < sb; m++) {
                    int sum = n + m;
                    if (sum == (sq.length - 1)) {
                        sq[n][m] = 1;
                    } else {
                        if (n == m) {
                            sq[n][m] = 1;
                        }
                    }
                    System.out.print(sq[n][m] + " ");
                }
                System.out.println(System.lineSeparator());
            }

            //Пятое задание
            int[] maxOrMin = {1, -15, 59, 35, 2, 7, 55};
            int max = 0;
            int min = 0;
            for (
                    int u = 0;
                    u < maxOrMin.length; u++) {
                if (maxOrMin[u] >= max) {
                    max = maxOrMin[u];
                } else if (maxOrMin[u] <= min) {
                    min = maxOrMin[u];
                }
            }
            System.out.println("Максимальное значение " + max);
            System.out.println("Минимальное значение " + min);

            int[] mas = {2, 2, 2, 1, 2, 2, 10, 1};
            int[] mas2 = {1, 1, 1, 2, 1};
            int[] mas3 = {12, 1, 1, 2, 4, 4};
            //Balance(mas);
            System.out.println(Balance(mas));
            changer(mas, 2);


        }

        //Шестое задание
        public static boolean Balance(int[] arr) {

            int sum1 = 0;
            int sum2 = 0;
            int count1 = 0;
            int count2 = 0;
            int sumCounts = 0;
            int numberArr1 = arr.length - 1;
            int numberArr2 = arr.length - 1;

            for (int i = 0; i < numberArr1; i++) {
                if (sum1 == 0) {
                    sum1 = arr[i];
                    count1 = 1;
                } else if (sum2 == sum1 && sumCounts == arr.length) {
                    System.out.println(sum2);
                    System.out.println("Баланс найден, он находится между номерами: " + count1 + " и " + (arr.length - (count2 - 1)));
                    return true;
                } else if (sum1 > sum2) {
                    for (int j = numberArr2; j >= 0; j--) {
                        sumCounts = count1 + count2;
                        numberArr2 = j;
                        if (sum2 < sum1) {
                            sum2 = sum2 + arr[j];
                            count2++;
                        } else if (sum2 == sum1 && sumCounts == arr.length) {
                            System.out.println(sum2);
                            System.out.println("Баланс найден, он находится между номерами: " + count1 + " и " + (arr.length - (count2 - 1)));
                            return true;
                        } else {
                            break;
                        }
                        i = i - 1;
                    }
                } else if (sum1 <= sum2 && sumCounts < arr.length) {
                    sum1 = sum1 + arr[i];
                    count1++;
                    sumCounts = count1 + count2;
                }
            }
            return false;
        }


        //Седьмое задание


        public static int[] changer(int[] mas, int n) {
            if (n > 0) {
                n %= mas.length;

                for (int i = 0; i < n; i++) {
                    int last = mas[mas.length - 1];
                    for (int j = mas.length - 1; j > 0; j--) {
                        mas[j] = mas[j - 1];
                    }
                    mas[0] = last;
                }
            } else if (n < 0) {
                n %= mas.length * -1;

                for (int i = 0; i > n; i--) {
                    int first = mas[0];
                    for (int j = 0; j < mas.length - 1; j++) {
                        mas[j] = mas[j + 1];
                    }
                    mas[mas.length - 1] = first;
                }

            }
            return mas;
        }


}
