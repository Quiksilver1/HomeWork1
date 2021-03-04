package ru.geekbrains.HomeWork.Java2.Lesson1.service;

import ru.geekbrains.HomeWork.Java2.Lesson1.Interface.Wall;
import ru.geekbrains.HomeWork.Java2.Lesson1.model.Cat;
import ru.geekbrains.HomeWork.Java2.Lesson1.model.Human;
import ru.geekbrains.HomeWork.Java2.Lesson1.model.Robot;

public class WallImpl implements Wall {

    private double height;
    Human human;
    Cat cat;
    Robot robot;

    public WallImpl(double height) {
        this.height = height;
    }



    @Override
    public void JumpHuman(Human human) {
        if(human.getJump()>=height) {
            System.out.println("Human "+human.getName()+" jump height "+height);
        }else {
            System.out.println("Human " + human.getName() + " don't jump height " + height);
            human.setReadiness(false);

        }

    }

    @Override
    public void JumpRobot(Robot robot) {
        if (robot.getJump() >= height) {
            System.out.println("Robot " + robot.getName() + " jump height " + height);
        } else {
            System.out.println("Robot " + robot.getName() + " don't jump height " + height);
            robot.setReadiness(false);
        }
    }

    @Override
    public void JumpCat(Cat cat) {
        if(cat.getJump()>=height) {
            System.out.println("Cat "+cat.getName()+" jump height "+height);
        }else{
            System.out.println("Cat "+cat.getName()+" don't jump height "+height);
            cat.setReadiness(false);
        }
    }
}