package com.scaler.DesignPattern.creation.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

class NotificationRegistry {

    private static final Map<String, Supplier<Notification>> registry = new HashMap<>();

    public static void register(String type, Supplier<Notification> supplier) {
        registry.put(type.toUpperCase(), supplier);
    }

    public static Notification get(String type) {
        Supplier<Notification> supplier = registry.get(type.toUpperCase());

        if (supplier == null) {
            throw new IllegalArgumentException("No notification registered for type: " + type);
        }

        return supplier.get();
    }
}