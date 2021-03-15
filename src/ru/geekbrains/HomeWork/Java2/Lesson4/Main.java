package ru.geekbrains.HomeWork.Java2.Lesson4;

import ru.geekbrains.HomeWork.Java2.Lesson4.Lambda.*;

import java.util.*;

public class Main {

    static Integer[] arr = {1, 2, 3, 4, 5};
    static List<String> str=new ArrayList<>();

    public static void main(String[] args) {
        str.add("all");
        str.add("alla");
        str.add("ali");
        str.add("bla");
        str.add("alij");
        str.add("gra");


        MyLambdaSearch ser= (Integer n, Integer[] arr) -> {
            for(int l=0;l<arr.length;l++){
                if(arr[l].equals(n)){
                    return l;
                }
            }
            return -1;
        };

        System.out.println("Number was find in cell "+ser.search(2,arr));

        MyLambdaReverse ref = (string) -> {

            String result = "";
            for (int i = string.length()-1; i >= 0 ; i--)
                result += string.charAt(i);
            return result;
        };
        System.out.println("Lambda reversed = " + ref.reverse("java interview"));

        MyLamdaMaximum m=(Integer[] arr)-> {
            int max=0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        };

        System.out.println("Biggest number "+m.maximum(arr));

        MyLamdaAverage av=(Integer[] arr)->{
            int sum=0;
            for (Integer i:arr) {
                sum+=i;
            }
            return (double)sum/ arr.length;
        };

        System.out.println("Average in array "+ av.average(arr));

        MyLambdaSearchString st=(str, size)-> {
            List<String> result=new ArrayList<>();
            for (String l:str) {
                if(l.startsWith("a") && l.length()== size){
                    result.add(l);
                }
            }
            return result;
        };

        System.out.println("first letter 'a' and length 3"+ st.searchString(str,3));
    }
}


