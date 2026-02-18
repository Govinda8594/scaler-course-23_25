package com.scaler.generics.inheritance;

public class Dog extends Mammal implements Eater {

    @Override
    public void eat() {
        System.out.println("Eating from dog");
    }

    public void run() {
        System.out.println("Running");
    }
}