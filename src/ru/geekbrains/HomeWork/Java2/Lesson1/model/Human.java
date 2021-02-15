package ru.geekbrains.HomeWork.Java2.Lesson1.model;

public class Human {

    private String name;
    private double jump;
    private int run;
    private boolean readiness=true;


    public Human(String name, double jump, int run, boolean readiness){
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

    public int getRun() {
        return run;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getJump() {
        return jump;
    }

    public void setJump(double jump) {
        this.jump = jump;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public void Run(){
        System.out.println("Human:"+name+" can run");
    }

    public void Jump(){
        System.out.println("Human:"+name+" can jump");
    }


}
