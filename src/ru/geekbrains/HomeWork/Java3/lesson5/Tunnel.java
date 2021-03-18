package ru.geekbrains.HomeWork.Java3.lesson5;


public class Tunnel extends Stage {
    public Tunnel(int length) {
        this.length = length;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c,int i) {
        try {
            try {
                System.out.println(i + " готовится к этапу(ждет): " + description);
                System.out.println(i + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(i + " закончил этап: " + description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
