package ru.geekbrains.HomeWork.Java3.lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #";
    }
    @Override
    public void run() {
        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        CyclicBarrier cbf = new CyclicBarrier(CARS_COUNT);
        Semaphore smp = new Semaphore(2);
        for (int i = 0; i < CARS_COUNT; i++) {
            final int w = i+1;
            new Thread(() -> {
                try {
                    System.out.println(w + " готовится");
                    Thread.sleep(500 + (int) (Math.random() * 800));
                    System.out.println(w + " готов");
                    cb.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (w == 1) {
                    System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
                }
                for (int j = 0; j < race.getStages().size(); j++) {
                    if(j == 1){
                        try {
                            smp.acquire();
                            race.getStages().get(j).go(this, w);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finally {
                            smp.release();
                        }
                    }else{
                        race.getStages().get(j).go(this, w);
                    }
                    if (j == race.getStages().size() - 1) {
                        if(race.getStages().get(race.getStages().size()-1).counter==1)
                            System.out.println((race.getStages().get(race.getStages().size()-1).name+w)+"-WIN");
                        try {
                            cbf.await();
                        } catch (InterruptedException | BrokenBarrierException e) {
                            e.printStackTrace();
                        }
                        if(w == 1) {
                            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
                        }
                    }
                }
            }).start();
        }
    }
}
