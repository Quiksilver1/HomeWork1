package ru.geekbrains.HomeWork.Java2.Lesson7.serverside.interfaces;

public interface AuthService {
    void start();
    void stop();
    String getNickByLoginAndPassword(String login, String password);
}