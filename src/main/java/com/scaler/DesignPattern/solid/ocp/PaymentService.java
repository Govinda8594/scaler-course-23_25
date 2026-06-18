package com.scaler.DesignPattern.solid.ocp;


// BAD Example
class PaymentService_1 {
    public void pay(String type) {
        if (type.equals("CARD")) {
            System.out.println("Card payment");
        } else if (type.equals("UPI")) {
            System.out.println("UPI payment");
        }
    }
}

// Better Example

interface Payment {
    void pay();
}

class CardPayment implements Payment {
    public void pay() {
        System.out.println("Card payment");
    }
}

class UpiPayment implements Payment {
    public void pay() {
        System.out.println("UPI payment");
    }
}

class PaymentService {
    public void process(Payment payment) {
        payment.pay();
    }
}