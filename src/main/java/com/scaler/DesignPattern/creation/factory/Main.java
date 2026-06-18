package com.scaler.DesignPattern.creation.factory;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.makePayment("UPI", 500.00);
    }
}