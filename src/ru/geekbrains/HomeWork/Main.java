package ru.geekbrains.HomeWork;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static int d;
    static int i;
    //public static void main(String[] args) {
//        byte[] buf = new byte[20];
//
//        File file=new File("C:\\Program Files\\Java\\HomeWork\\src\\demo.txt");
//        System.out.println(file.isFile());
//        System.out.println(file.getAbsolutePath());
//
//        byte[] outData = new byte[10 * 10];
//        for (int i = 0; i < outData.length; i++) {
//            outData[i] = 69;
//        }
//        try (FileOutputStream out = new FileOutputStream("C:\\Program Files\\Java\\HomeWork\\src\\demo.txt")){
//
//            DataOutputStream dos=new DataOutputStream(out);
//            dos.writeInt(643);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        try (FileInputStream in = new FileInputStream("C:\\Program Files\\Java\\HomeWork\\src\\demo.txt")) {
//           *//* int count;
//            while ((count = in.read(buf)) > 0) {
//                for (int i = 0; i < count; i++) {
//                    System.out.print((char) buf[i]);
//                }
//            }*//*
//            DataInputStream dis=new DataInputStream(in);
//            System.out.println(dis.readInt());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//

            public static void main(String[] args) {
                File file=new File("demo.txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,true))) {
                    /*for (int i = 0; i < 20; i++) {
                        writer.write("Java\n");
                    }*/
                    file.deleteOnExit();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String str;
                    ArrayList<String> arr=new ArrayList<>();
                    while ((str = reader.readLine()) != null) {
                        arr.add(str);
                    }
                    System.out.println(arr.get(arr.size()-1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }




}

