package com.scaler.Scaler.MathDSA.Geometry;

class Circle {
    double x, y, r;

    Circle(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}

public class CircleOverlap {
    static boolean doOverlap(Circle c1, Circle c2) {
        double dx = c1.x - c2.x;
        double dy = c1.y - c2.y;
        //    Expression	Meaning	Purpose
//    x * x + y * y	 Squared differences (sum of squares)	Represents squared Euclidean distance
//    √(x * x + y * y)	Square root of sum of squares	Actual Euclidean distance
        // Two points
//    double x1 = 3, y1 = 5; // Point A
//    double x2 = 1, y2 = 2; // Point B
//
//    // Differences
//    double dx = x1 - x2; // 3 - 1 = 2
//    double dy = y1 - y2; // 5 - 2 = 3
//
//    // x*x + y*y → Squared distance
//    double squaredDistance = dx*dx + dy*dy; // 2² + 3² = 4 + 9 = 13
//
//    // Actual Euclidean distance
//    double distance = Math.sqrt(squaredDistance); // √13 ≈ 3.605
        //    x*x + y*y = Squared Euclidean distance (scalar value).
//            √(x*x + y*y) = Actual Euclidean distance (physical length).
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance <= (c1.r + c2.r);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(0, 0, 5);
        Circle c2 = new Circle(8, 0, 4);
        System.out.println(doOverlap(c1, c2) ? "Overlap" : "No Overlap"); // No Overlap
    }
}