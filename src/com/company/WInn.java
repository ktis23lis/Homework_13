package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class WInn {
    private ArrayList<Car> carWin;

    public ArrayList<Car> getCarWin() {
        return carWin;
    }

    public WInn (Car ... cars){
        this.carWin = new ArrayList<>(Arrays.asList(cars));
    }
}

