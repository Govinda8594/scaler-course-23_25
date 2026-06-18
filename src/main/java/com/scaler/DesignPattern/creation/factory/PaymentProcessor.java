package com.scaler.DesignPattern.creation.factory;

interface PaymentProcessor {
    void process(double amount);
}

class CardPaymentProcessor implements PaymentProcessor {
    public void process(double amount) {
        System.out.println("Processing card payment: " + amount);
    }
}

class UpiPaymentProcessor implements PaymentProcessor {
    public void process(double amount) {
        System.out.println("Processing UPI payment: " + amount);
    }
}

class WalletPaymentProcessor implements PaymentProcessor {
    public void process(double amount) {
        System.out.println("Processing wallet payment: " + amount);
    }
}