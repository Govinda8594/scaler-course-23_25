package com.scaler.DesignPattern.structural.Decorator;

public class HouseBlend implements Beverage {
    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public String getDescription() {
        return "HouseBlend";
    }
}
