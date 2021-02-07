package ru.geekbrains.HomeWork.Java2.Lesson1.model;



import ru.geekbrains.HomeWork.Java2.Lesson1.Interface.Treadmill;
import ru.geekbrains.HomeWork.Java2.Lesson1.service.TreadmillImpl;
import ru.geekbrains.HomeWork.Java2.Lesson1.service.WallImpl;

public class Polygon {

    public static void main(String[] args) {
        Human[] Humans=new Human[3];
        Humans[0]=new Human("Artur",1.3,1000,true);
        Humans[1]=new Human("Dima",1.9,2000,true);
        Humans[2]=new Human("Pasha",2.0,1800,true);

        Cat[] cats=new Cat[2];
        cats[0]=new Cat("Murzik",2.0,200,true);
        cats[1]=new Cat("Barsik",1.9,250,true);


        Robot[] robots=new Robot[2];
        robots[0]=new Robot("Terminator",1,10000,true);
        robots[1]=new Robot("Zhizha",3,50000,true);


        TreadmillImpl[] treadmills=new TreadmillImpl[2];
        treadmills[0]=new TreadmillImpl(500);
        treadmills[1]=new TreadmillImpl(200);
        for (Human human:Humans) {
            for (TreadmillImpl treadmill:treadmills) {
                if(human.isReadiness()){
                    treadmill.RunningHuman(human);
                }
            }
        }

        for (Cat cat:cats) {
            for (TreadmillImpl treadmill:treadmills) {
                if(cat.isReadiness()) {
                    treadmill.RunningCat(cat);
                }
            }
        }

        for (Robot robot:robots) {
            for (TreadmillImpl treadmill:treadmills) {
                if (robot.isReadiness()) {
                    treadmill.RunningRobot(robot);
                }
            }
        }

        WallImpl[] walls=new WallImpl[2];
        walls[0]=new WallImpl(1.7);
        walls[1]=new WallImpl(2.3);

        for (Human human:Humans) {
            for(WallImpl wallimpl:walls) {
                if(human.isReadiness()) {
                    wallimpl.JumpHuman(human);
                }
            }
        }

        for (Robot robot:robots) {
            for(WallImpl wallimpl:walls) {
                if(robot.isReadiness()) {
                    wallimpl.JumpRobot(robot);
                }
            }
        }

        for (Cat cat:cats) {
            for(WallImpl wallimpl:walls) {
                if(cat.isReadiness()) {
                    wallimpl.JumpCat(cat);
                }
            }
        }

    }


}