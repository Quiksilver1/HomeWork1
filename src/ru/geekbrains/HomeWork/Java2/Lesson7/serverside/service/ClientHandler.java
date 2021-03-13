package ru.geekbrains.HomeWork.Java2.Lesson7.serverside.service;

import ru.geekbrains.HomeWork.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;


public class ClientHandler {

    private MyServer myServer;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String log;
    private String pas;
    private String name;
    private boolean isAuthorized;
    long a=System.currentTimeMillis();


    public ClientHandler(MyServer myServer, Socket socket) {

        Statement statement=null;

        try {

            this.myServer = myServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.name = "";

            statement= Singleton.getConnection().createStatement();

            new Thread(() -> {
                try {
                    authentication();
                    readMessage();
                } catch (IOException | SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }

            }).start();

            new Thread(() -> {
                try {
                    Thread.sleep(120000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!isAuthorized) {
                    System.out.println(this.getName()+" leave");
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            closeConnection();
            throw new RuntimeException("Problem with ClientHandler");
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (statement!=null) {
                    statement.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void authentication() throws IOException, SQLException, ClassNotFoundException {

        Statement statement=null;

        statement= Singleton.getConnection().createStatement();

        while (true) {
            String str = dis.readUTF();
            if (str.startsWith("/auth")) { //  /auth login password
                String [] arr = str.split("\\s");
                ResultSet rsNick=statement.executeQuery("SELECT * FROM users WHERE login='"+arr[1]+"' AND password='"+arr[2]+"'");
                while(rsNick.next()) {
                    User user1 = new User().userBuilder(rsNick);
                    log=user1.getLogin();
                    pas=user1.getPassword();
                    String nick = user1.getNick();
                    System.out.println(nick);
                /*String nick = myServer
                        .getAuthService()
                        .getNickByLoginAndPassword(arr[1], arr[2]);*/
                    if (nick != null) {
                        if (!myServer.isNickBusy(nick)) {
                            isAuthorized = true;
                            sendMessage("/authok " + nick);
                            name = nick;
                            myServer.broadcastMessage("Hello " + name);
                            myServer.subscribe(this);
                            return;
                        } else {
                            sendMessage("Nick is busy");
                        }
                    } else {
                        sendMessage("Wrong login and password");
                    }
                }
            } else {
                sendMessage("Your command will be need start with /auth");
            }
        }

    }

    public void changeNick(String nick) throws SQLException, ClassNotFoundException {
        Statement statement=null;
        statement= Singleton.getConnection().createStatement();
        String previousNick=name;
        statement.executeUpdate("UPDATE users SET nick='"+nick+"' WHERE login='"+getLog()+"' AND password='"+getPas()+"'");
        System.out.println(nick);
        name=nick;
        myServer.broadcastMessage(previousNick+" changed his nick to " + name);

    }

    public void readMessage() throws IOException, SQLException, ClassNotFoundException {
        while (true) {
            String messageFromClient = dis.readUTF();
            System.out.println(name + " send message " + messageFromClient);
            if (messageFromClient.trim().startsWith("/")) {

                if (messageFromClient.startsWith("/w")) {
                    String [] arr = messageFromClient.split(" ", 3);
                    myServer.sendMessageToCertainClient(this, arr[1], name + ": " + arr[2]);
                }

                if (messageFromClient.trim().startsWith("/list")) {
                    myServer.getOnlineUsersList(this);
                }

                if (messageFromClient.trim().startsWith("/changeNick")) {
                    String [] arr = messageFromClient.split(" ", 3);
                    changeNick(arr[1]);
                }

                if (messageFromClient.trim().startsWith("/end")) {
                    return;
                }
            } else {
                myServer.broadcastMessage(name + ": " + messageFromClient);
            }
        }
    }


    public void sendMessage(String message) {
        try {
            long t=System.currentTimeMillis()-a;
            if(t>20000) {
                System.out.println(this.getName() + " leave");
                closeConnection();
            }else{
                dos.writeUTF(message);
                a = System.currentTimeMillis();
            }
        } catch (IOException ignored) {
        }
    }

    private void closeConnection() {
        myServer.unsubscribe(this);
        myServer.broadcastMessage(name + " Leave chat");
        try {
            dis.close();
            dos.close();
            socket.close();
        } catch (IOException ignored) {
        }
    }


    public String getName() {
        return name;
    }

    public String getLog() {
        return log;
    }

    public String getPas() {
        return pas;
    }

}
