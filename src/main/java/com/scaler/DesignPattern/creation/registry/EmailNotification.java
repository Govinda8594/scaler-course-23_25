package com.scaler.DesignPattern.creation.registry;

class EmailNotification implements Notification {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

class SmsNotification implements Notification {
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}

class WhatsAppNotification implements Notification {
    public void send(String message) {
        System.out.println("WhatsApp sent: " + message);
    }
}