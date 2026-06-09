package com.scaler.DesignPattern.structural.flyweight;

// Concrete Flyweight: holds intrinsic (shared) state

public class BulletType implements BulletFlyweight{
    // intrinsic state(shared) // Heavy shared data (intrinsic)
    private final String sprite;     // Heavy shared data (intrinsic)
    private final String color;

    public BulletType(String sprite, String color) {
        this.sprite = sprite;
        this.color = color;
    }

    @Override
    public void draw(int x, int y, int speed) {
        // Only x, y, speed are extrinsic (context)
        System.out.println(
                "Drawing bullet [sprite=" + sprite +
                        ", color=" + color +
                        "] at (" + x + "," + y + ") speed=" + speed
        );
    }
}
