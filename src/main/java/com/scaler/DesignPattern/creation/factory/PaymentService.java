package com.scaler.DesignPattern.creation.factory;

class PaymentService {
    public void makePayment(String mode, double amount) {
        PaymentProcessor processor = PaymentProcessorFactory.getProcessor(mode);
        processor.process(amount);
    }
}