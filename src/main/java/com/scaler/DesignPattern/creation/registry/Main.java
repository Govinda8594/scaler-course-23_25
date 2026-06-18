package com.scaler.DesignPattern.creation.registry;

public class Main {
    public static void main(String[] args) {

        NotificationRegistry.register("EMAIL", EmailNotification::new);
        NotificationRegistry.register("SMS", SmsNotification::new);
        NotificationRegistry.register("WHATSAPP", WhatsAppNotification::new);

        Notification notification = NotificationRegistry.get("EMAIL");
        notification.send("Your order is confirmed");

        Notification sms = NotificationRegistry.get("SMS");
        sms.send("OTP is 123456");
    }
}