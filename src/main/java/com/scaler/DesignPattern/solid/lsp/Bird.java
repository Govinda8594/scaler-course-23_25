package com.scaler.DesignPattern.solid.lsp;

// Bad Example
class Bird_1 {
    public void fly() {
        System.out.println("Flying");
    }
}

class Ostrich_1 extends Bird_1 {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly");
    }
}

// Better Example
interface Bird {
    void eat();
}

interface FlyingBird extends Bird {
    void fly();
}

class Sparrow implements FlyingBird {
    public void eat() {}
    public void fly() {
        System.out.println("Sparrow flying");
    }
}

class Ostrich implements Bird {
    public void eat() {}
}