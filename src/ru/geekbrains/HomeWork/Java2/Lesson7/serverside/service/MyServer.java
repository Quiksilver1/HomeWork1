package ru.geekbrains.HomeWork.Java2.Lesson7.serverside.service;

import ru.geekbrains.HomeWork.Java2.Lesson7.serverside.interfaces.AuthService;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class MyServer {
    private final int PORT = 8081;

    public List<ClientHandler> getClients() {
        return clients;
    }

    private List<ClientHandler> clients;

    private AuthService authService;

    public MyServer() {
        Statement statement=null;
        try (ServerSocket server = new ServerSocket(PORT)){

            authService = new BaseAuthService();
            authService.start();

            clients = new ArrayList<>();

            while (true) {
                System.out.println("Server wait connection");
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress().getCanonicalHostName());
                System.out.println("Client is joined");
                new ClientHandler(this, socket);
            }

        } catch (IOException e){
            System.out.println("Server is down");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized void broadcastMessage(String message) {
        try {
            for (ClientHandler c : clients) {
                c.sendMessage(message);
            }
        }catch(ConcurrentModificationException ignored){
        }
    }

    public synchronized void sendMessageToCertainClient(ClientHandler from, String toName, String message) {
        try {
            for (ClientHandler c : clients) {
                if (c.getName().equals(toName)) {
                    c.sendMessage(message);
                    from.sendMessage(message);
                }
            }
        }catch (ConcurrentModificationException ignored){
        }
    }


    public synchronized void getOnlineUsersList(ClientHandler clientHandler) {
        StringBuilder sb = new StringBuilder("");
        for (ClientHandler c : clients) {
            if (!c.equals(clientHandler)) {
                sb.append(c.getName()).append(", ");
            }
        }
        int size = sb.length();
        sb.deleteCharAt(size - 1);
        sb.deleteCharAt(size - 2);
        clientHandler.sendMessage(sb.toString());
    }




    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler c : clients) {
            if (c.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }


}
