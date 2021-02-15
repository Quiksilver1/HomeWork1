package ru.geekbrains.HomeWork.Java2.Lesson1.Interface;

import ru.geekbrains.HomeWork.Java2.Lesson1.model.Cat;
import ru.geekbrains.HomeWork.Java2.Lesson1.model.Human;
import ru.geekbrains.HomeWork.Java2.Lesson1.model.Robot;

public interface Wall {

    void JumpHuman(Human human);

    void JumpRobot(Robot robot);

    void JumpCat(Cat cat);
}


