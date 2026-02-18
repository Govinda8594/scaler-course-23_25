package com.scaler.Scaler.MathDSA.Geometry;

public class ClosestPair {    //    Expression	Meaning	Purpose
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

    static double bruteForce(Point[] points) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dist = distance(points[i], points[j]);
                if (dist < min) min = dist;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(2, 3), new Point(12, 30),
                new Point(40, 50), new Point(5, 1),
                new Point(12, 10), new Point(3, 4)
        };
        System.out.println("Min distance: " + bruteForce(points));
    }
}