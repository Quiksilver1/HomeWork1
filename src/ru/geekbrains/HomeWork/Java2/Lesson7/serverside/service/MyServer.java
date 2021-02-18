package ru.geekbrains.HomeWork.Java2.Lesson7.serverside.service;

import ru.geekbrains.HomeWork.Java2.Lesson7.serverside.interfaces.AuthService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    private final int PORT = 8081;

    public List<ClientHandler> getClients() {
        return clients;
    }

    private List<ClientHandler> clients;

    private AuthService authService;

    public AuthService getAuthService() {
        return this.authService;
    }

    public MyServer() {
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
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized void broadcastMessage(String message) throws  IOException{
        if (message.startsWith("/w")) { //  /private message
            String[] arr = message.split("\\s");
            String nick = arr[1];
            String nickMessage = arr[2];
            if (nick != null && nickMessage != null) {
                for (ClientHandler c : clients) {
                    if (nick.equals(c.getName())) {
                        c.sendMessage(c.getName()+": "+nickMessage);
                        break;
                    }
                }
            }
        }else {
            for (ClientHandler c : clients) {
                c.sendMessage(message);
            }
        }
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
