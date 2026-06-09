package com.scaler.DesignPattern.structural.flyweight;

public class ClientApp {
    static void main() {
        BulletFlyweight pistolBullet =
                BulletFactory.getBulletType("pistol.png", "yellow");

        BulletFlyweight sniperBullet =
                BulletFactory.getBulletType("sniper.png", "red");

        // Creating many bullets with shared intrinsic state
        Bullet b1 = new Bullet(10, 20, 5, pistolBullet);
        Bullet b2 = new Bullet(15, 25, 5, pistolBullet);
        Bullet b3 = new Bullet(100, 300, 20, sniperBullet);

        b1.render();
        b2.render();
        b3.render();
        }
}
