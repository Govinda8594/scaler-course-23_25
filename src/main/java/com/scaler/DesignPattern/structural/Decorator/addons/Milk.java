package com.scaler.DesignPattern.structural.Decorator.addons;

import com.scaler.DesignPattern.structural.Decorator.Beverage;

public  class Milk extends AddOnDecorator {
    protected Beverage cb;

    public Milk(Beverage b) {
        super(b);
        this.cb = b;
    }

    @Override
    public int getCost() {
        return 10 + cb.getCost();
    }

    @Override
    public String getDescription() {
        return "Milk";
    }
}
