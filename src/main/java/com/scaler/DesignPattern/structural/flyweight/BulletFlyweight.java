package com.scaler.DesignPattern.structural.flyweight;

//The Flyweight pattern focuses on
// memory efficiency by sharing common parts of objects (intrinsic state)
// and keeping unique parts (extrinsic state) separate.
// Flyweight interface
public interface BulletFlyweight {
    void draw(int x, int y, int speed);
}
