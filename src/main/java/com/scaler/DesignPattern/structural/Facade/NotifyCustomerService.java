package com.scaler.DesignPattern.structural.Facade;

public class NotifyCustomerService {
    void sendEmail(){
        IO.println("Email sent");
    }

    void sendSMS() {
        IO.println("SMS sent");
    }
}
