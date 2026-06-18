package com.scaler.DesignPattern.creation.factory;

class PaymentProcessorFactory {

    public static PaymentProcessor getProcessor(String paymentMode) {
        switch (paymentMode.toUpperCase()) {
            case "CARD":
                return new CardPaymentProcessor();

            case "UPI":
                return new UpiPaymentProcessor();

            case "WALLET":
                return new WalletPaymentProcessor();

            default:
                throw new IllegalArgumentException("Unsupported payment mode");
        }
    }
}