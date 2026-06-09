package com.scaler.DesignPattern.structural.Decorator.addons;


import com.scaler.DesignPattern.structural.Decorator.Beverage;

public class Mocha extends AddOnDecorator {
    Beverage cb;

    public Mocha(Beverage b) {
        super(b);
        this.cb = b;
    }

    @Override
    public int getCost() {
        return 20 + cb.getCost();
    }

    @Override
    public String getDescription() {
        return "Mocha";
    }


}
