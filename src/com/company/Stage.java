package com.company;

public abstract class Stage {
    protected int length;//длинна
    protected String description;//описание

    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
