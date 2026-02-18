package com.scaler.DesignPattern.Decorator.addons;


import com.scaler.DesignPattern.Decorator.Beverage;

public class Whip implements Beverage {
    Beverage cb;

    public Whip(Beverage b) {
        this.cb = b;
    }

    @Override
    public int getCost() {
        return 15 + cb.getCost();
    }
}
