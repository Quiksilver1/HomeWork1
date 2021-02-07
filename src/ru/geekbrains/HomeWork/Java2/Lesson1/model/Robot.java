package ru.geekbrains.HomeWork.Java2.Lesson1.model;

public class Robot {

    private String name;
    private double jump;
    private int run;
    private boolean readiness=true;

    public Robot(String name,double jump,int run,boolean readiness){
        this.name=name;
        this.jump=jump;
        this.run=run;
    }

    public boolean isReadiness() {
        return readiness;
    }

    public void setReadiness(boolean readiness) {
        this.readiness = readiness;
    }

    public void Run(){
        System.out.println("Robot:"+name+" can run");
    }

    public void Jump(){
        System.out.println("Robot:"+name+" can jump");
    }

    public int getRun() {
        return run;
    }

    public String getName() {
        return name;
    }

    public double getJump() {
        return jump;
    }
}