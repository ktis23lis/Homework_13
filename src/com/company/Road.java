package com.company;

import java.util.ArrayList;

public class Road extends Stage{
    static final ArrayList<Car> carArr = new ArrayList<>();



    public Road(int length){
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() +" начал этап: " + description);
            Thread.sleep(length/c.getSpeed() * 100);
            System.out.println(c.getName()+ " закончил этап: "+description);

        }
        catch (InterruptedException e){
            e.printStackTrace();
        }carArr.add(c);

    }
}
