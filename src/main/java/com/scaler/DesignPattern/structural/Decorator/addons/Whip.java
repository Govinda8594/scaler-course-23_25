package com.scaler.DesignPattern.structural.Decorator.addons;


import com.scaler.DesignPattern.structural.Decorator.Beverage;

public class Whip extends AddOnDecorator {
    Beverage cb;

    public Whip(Beverage b) {

        super(b);
        this.cb = b;
    }

    @Override
    public int getCost() {
        return 15 + cb.getCost();
    }

    @Override
    public String getDescription() {
        return "Whip";
    }
}
