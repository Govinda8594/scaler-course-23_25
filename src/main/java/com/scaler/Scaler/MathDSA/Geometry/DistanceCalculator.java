package com.scaler.Scaler.MathDSA.Geometry;

public class DistanceCalculator {
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
    static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(b.x - a.x, 2) + Math.pow(b.y - a.y, 2));
    }

    public static void main(String[] args) {
        Point p1 = new Point(3, 4);
        Point p2 = new Point(7, 1);
        System.out.println("Distance: " + distance(p1, p2)); // 5.0
    }
}