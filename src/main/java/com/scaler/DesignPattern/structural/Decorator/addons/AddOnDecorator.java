package com.scaler.DesignPattern.structural.Decorator.addons;

import com.scaler.DesignPattern.structural.Decorator.Beverage;

public abstract class AddOnDecorator implements Beverage {
    protected Beverage beverage;
    AddOnDecorator(Beverage bg){
        this.beverage = bg;
    }
    @Override
    public int getCost() {
        return beverage.getCost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }
}
