package com.scaler.Scaler.MathDSA.Geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity:
//        Best/Average: O(n log n)
//        Worst-case: O(n²) (degenerate cases)
public class QuickHull {
    // Returns side relative to line (a, b)
    private static int findSide(Point a, Point b, Point p) {
        return (int) ((p.y - a.y) * (b.x - a.x) - (p.x - a.x) * (b.y - a.y));
    }

    // Returns perpendicular distance
    private static int lineDist(Point a, Point b, Point p) {
        return Math.abs(findSide(a, b, p));
    }

    private static void findHull(Point[] points, int n, Point a, Point b, List<Point> hull) {
        if (n == 0) return;

        // Find farthest point from line (a,b)
        int maxDist = 0, idx = -1;
        for (int i = 0; i < n; i++) {
            int dist = lineDist(a, b, points[i]);
            if (dist > maxDist) {
                maxDist = dist;
                idx = i;
            }
        }

        if (idx == -1) return;
        Point c = points[idx];
        hull.add(c);

        // Partition points into three sets:
        // Left of (a,c), left of (c,b), and colinear
        List<Point> leftAC = new ArrayList<>();
        List<Point> leftCB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i == idx) continue;
            Point p = points[i];
            if (findSide(a, c, p) > 0) leftAC.add(p);
            else if (findSide(c, b, p) > 0) leftCB.add(p);
        }

        // Recursively process partitions
        findHull(leftAC.toArray(new Point[0]), leftAC.size(), a, c, hull);
        findHull(leftCB.toArray(new Point[0]), leftCB.size(), c, b, hull);
    }

    public static List<Point> convexHull(Point[] points) {
        int n = points.length;
        if (n < 3) return Arrays.asList(points);

        // Find min and max x-coordinates
        int minX = 0, maxX = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].x < points[minX].x) minX = i;
            if (points[i].x > points[maxX].x) maxX = i;
        }

        Point a = points[minX], b = points[maxX];
        List<Point> hull = new ArrayList<>();
        hull.add(a);
        hull.add(b);

        // Split points into left and right of line (a,b)
        List<Point> left = new ArrayList<>();
        List<Point> right = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Point p = points[i];
            int side = findSide(a, b, p);
            if (side > 0) left.add(p);
            else if (side < 0) right.add(p);
        }

        // Find hull partitions recursively
        findHull(left.toArray(new Point[0]), left.size(), a, b, hull);
        findHull(right.toArray(new Point[0]), right.size(), b, a, hull);

        return hull;
    }

    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(0, 3), new Point(1, 1), new Point(2, 2),
                new Point(4, 4), new Point(0, 0), new Point(1, 2),
                new Point(3, 1), new Point(3, 3)
        };
        List<Point> hull = convexHull(points);
        for (Point p : hull)
            System.out.println("(" + p.x + ", " + p.y + ")");
    }
}