package com.scaler.DesignPattern.Decorator;


import com.scaler.DesignPattern.Decorator.addons.Milk;
import com.scaler.DesignPattern.Decorator.addons.Whip;

public class Client {
    public static void main(String[] args) {
        Beverage b = new Espresso();
        b.getCost();

        // Espresso with WHip and Milk
        Beverage cb = new Espresso();
        cb = new Whip(cb);
        cb = new Milk(cb);
        System.out.println(cb.getCost());
    }
}
