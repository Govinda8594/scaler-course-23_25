package com.scaler.DesignPattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

// Factory: returns shared BulletType objects
public class BulletFactory {
    private static final Map<String, BulletType> cache = new HashMap<>();

    public static BulletType getBulletType(String sprite, String color) {
        String key = sprite + "_" + color;
        BulletType type = cache.get(key);

        if (type == null) {
            type = new BulletType(sprite, color);
            cache.put(key, type);
        }
        return type;
    }
}
