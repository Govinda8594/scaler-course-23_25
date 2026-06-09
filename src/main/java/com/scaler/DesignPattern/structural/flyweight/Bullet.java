package com.scaler.DesignPattern.structural.flyweight;

//// Context class: holds only extrinsic state
public class Bullet {
    private final int x;
    private final int y;
    private final int speed;
    private final BulletFlyweight type;  // Shared flyweight

    public Bullet(int x, int y, int speed, BulletFlyweight type) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.type = type;
    }

    public void render() {
        type.draw(x, y, speed);
    }
}
