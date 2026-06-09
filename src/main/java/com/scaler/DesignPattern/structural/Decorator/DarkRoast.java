package com.scaler.DesignPattern.structural.Decorator;

public class DarkRoast implements Beverage {
    @Override
    public int getCost() {
        return 75;
    }

    @Override
    public String getDescription() {
        return "DarkRoast";
    }
}