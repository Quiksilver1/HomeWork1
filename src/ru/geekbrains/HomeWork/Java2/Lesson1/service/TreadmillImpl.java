package ru.geekbrains.HomeWork.Java2.Lesson1.service;

import ru.geekbrains.HomeWork.Java2.Lesson1.Interface.Treadmill;
import ru.geekbrains.HomeWork.Java2.Lesson1.model.Cat;
import ru.geekbrains.HomeWork.Java2.Lesson1.model.Human;
import ru.geekbrains.HomeWork.Java2.Lesson1.model.Robot;

public class TreadmillImpl implements Treadmill {

    private int distance;
    Human human;
    Cat cat;
    Robot robot;


    public TreadmillImpl(int distance) {
        this.distance = distance;
    }


    @Override
    public void RunningHuman(Human human) {
        if(human.getRun()>=distance ) {
            System.out.println("Human "+human.getName()+" ran distance "+distance);
        }else{
            System.out.println("Human "+human.getName()+" don't ran distance "+distance);
            human.setReadiness(false);
        }

    }

    @Override
    public void RunningRobot(Robot robot) {

        if(robot.getRun()>=distance ) {
            System.out.println("Robot "+robot.getName()+" ran distance "+distance);
        }else{
            System.out.println("Robot "+robot.getName()+" don't ran distance "+distance);
            robot.setReadiness(false);
        }

    }

    @Override
    public void RunningCat(Cat cat) {
        if(cat.getRun()>=distance ) {
            System.out.println("Cat "+cat.getName()+" ran distance "+distance);
        }else {
            System.out.println("Cat " + cat.getName() + " don't ran distance " + distance);
            cat.setReadiness(false);
        }
    }



}