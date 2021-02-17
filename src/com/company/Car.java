package com.company;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    private static CyclicBarrier start;
    private static CountDownLatch finish;
    private static CountDownLatch ready;
    private static ArrayList<Car> carArr;
    int a =3;


    static {
        finish = Main.finish;
        ready = Main.ready;
        start = Main.start;
        carArr = Road.carArr;

    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }



    @Override
    public void run() {

            try {
                System.out.println(this.name + " готовиться");
                Thread.sleep(500 + (int) (Math.random() * 800));
                ready.countDown();
                System.out.println(this.name + " готов");
                start.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

            final ArrayList<Stage> stages = race.getStages();
        for (int q = 0; q < stages.size(); q++) {
            stages.get(q).go(this);
            if (q == a){
            }


        }
        System.out.println(carArr.get(0).getName()+" - Победитель!");

            finish.countDown();
        }

}