package com.scaler.DesignPattern.structural.Decorator;

public class Espresso implements Beverage {
    @Override
    public int getCost() {
        return 100;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}
