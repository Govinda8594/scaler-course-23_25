package com.scaler.DesignPattern.structural.Decorator;


import com.scaler.DesignPattern.structural.Decorator.addons.Milk;
import com.scaler.DesignPattern.structural.Decorator.addons.Whip;

public class Client {
    public static void main(String[] args) {
        Beverage b = new Espresso(); // only espresso
        b.getCost(); // 100
        b.getDescription(); // esprosso
        // Espresso with WHip and Milk
        Beverage cb = new Espresso();
        cb = new Whip(cb); // add whip 100 + 15 => 115
        cb = new Milk(cb); // add milk 115 + 10 => 125
        System.out.println(cb.getCost()); // total = 125
        System.out.println(cb.getDescription()); // espresso + milk + whip;
    }
}
