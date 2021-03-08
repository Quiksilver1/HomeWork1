package ru.geekbrains.HomeWork.Java2.Lesson7.serverside.service;

import ru.geekbrains.HomeWork.Java2.Lesson7.serverside.interfaces.AuthService;


import java.sql.SQLException;
import java.sql.Statement;


public class BaseAuthService implements AuthService {


//    private final List<Entry> entryList;

    public BaseAuthService() throws SQLException, ClassNotFoundException {
        Statement statement=null;
        statement= Singleton.getConnection().createStatement();
        /*entryList = new ArrayList<>();
        entryList.add(new Entry("D", "1", "One"));
        entryList.add(new Entry("V", "1", "Two"));
        entryList.add(new Entry("Vl", "1", "Three"));*/

        statement.executeUpdate("DELETE FROM users");

        statement.executeUpdate("INSERT INTO users (login,password,nick) VALUES ('D','1','One')");
        statement.executeUpdate("INSERT INTO users (login,password,nick) VALUES ('V','1','Two')");
        statement.executeUpdate("INSERT INTO users (login,password,nick) VALUES ('VL','1','Three')");
    }

    @Override
    public void start() {
        System.out.println("AuthService start");
    }

    @Override
    public void stop() {
        System.out.println("AuthService stop");
    }

    /*@Override
    public String getNickByLoginAndPassword(String login, String password) {
        for (Entry e : entryList) {
            if (e.login.equals(login) && e.password.equals(password)) {
                return e.nick;
            }
        }
        return null;
    }

    private static class Entry {
        private final String login;
        private final String password;
        private final String nick;

        public Entry(String login, String password, String nick) {
            this.login = login;
            this.password = password;
            this.nick = nick;
        }
    }*/
}