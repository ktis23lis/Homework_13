package com.company;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int CARS_COUNT = 4;
    static final CountDownLatch finish = new CountDownLatch(CARS_COUNT);
    static final CountDownLatch ready = new CountDownLatch(CARS_COUNT);
    static final CyclicBarrier start = new CyclicBarrier(CARS_COUNT);




    public static void main (String[] args) throws InterruptedException {
        System.out.println("Выжное обявление >> Подготовка!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(100));

        Car[]cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int)(Math.random()*10));
        }
        for (int i = 0; i < cars.length ; i++) {
            new Thread(cars[i]).start();
        }

        ready.await();
        System.out.println("Важное обьявление >> Гонка началась!");
        finish.await();



        System.out.println("Важное обьявление >> Гонка закончилась!");

    }
}
