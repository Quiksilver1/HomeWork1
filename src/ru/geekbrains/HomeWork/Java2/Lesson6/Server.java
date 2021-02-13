package ru.geekbrains.HomeWork.Java2.Lesson6;

import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame {

    public static void main(String[] args) throws InterruptedException {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(8082)) {
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Server start");
            socket = serverSocket.accept();
            System.out.println("Client join");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            while (true) {


                System.out.print("Client wrote you: ");
                String message = dis.readUTF();
                System.out.println(message);
                if (message.equalsIgnoreCase("/finish")) {
                    dos.writeUTF(message);
                    break;
                }
                Thread.sleep(1000);
                System.out.print("Write your message: ");
                String serverCommand = br.readLine();
                dos.writeUTF(serverCommand);
                Thread.sleep(1000);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
