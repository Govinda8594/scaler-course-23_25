package com.scaler.Scaler.MathDSA.Geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Key Differences:
//        Algorithm	Time Complexity	Key Mechanism	Best For
//        Jarvis March	O(nh)	"Gift Wrapping" approach	Small hulls (h << n)
//        QuickHull	O(n log n) avg/worst O(n²)	Divide & Conquer	Well-distributed points
//        Graham Scan	O(n log n)	Polar angle sorting + stack	General purpose
//        Interview Tip:
//
//        Use Graham Scan for general cases (most efficient)
//
//        Use Jarvis March when expected hull is small
//
//        Mention QuickHull's similarity to Quicksort when discussing average cases
public class ConvexHull {
    public static int orientation(Point p, Point q, Point r) {
        int val = (int) ((q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y));
        if (val == 0) return 0;  // collinear
        return (val > 0) ? 1 : 2; // clockwise or counterclockwise
    }

    public static List<Point> convexHull(Point[] points) {
        int n = points.length;
        if (n < 3) return Arrays.asList(points);

        // Find bottommost point
        int ymin = (int) points[0].y, minIdx = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].y < ymin || (points[i].y == ymin && points[i].x < points[minIdx].x)) {
                ymin = (int) points[i].y;
                minIdx = i;
            }
        }

        // Swap bottommost to front
        Point temp = points[0];
        points[0] = points[minIdx];
        points[minIdx] = temp;

        // Sort by polar angle from points[0]
        final Point p0 = points[0];
        Arrays.sort(points, 1, n, (p1, p2) -> {
            int o = orientation(p0, p1, p2);
            if (o == 0) return (distSq(p0, p2) >= distSq(p0, p1)) ? -1 : 1;
            return (o == 2) ? -1 : 1;
        });

        // Build hull
        Stack<Point> stack = new Stack<>();
        stack.push(points[0]);
        stack.push(points[1]);

        for (int i = 2; i < n; i++) {
            while (stack.size() > 1 && orientation(stack.get(stack.size() - 2), stack.peek(), points[i]) != 2) {
                stack.pop();
            }
            stack.push(points[i]);
        }

        return new ArrayList<>(stack);
    }

    private static int distSq(Point p1, Point p2) {
        return (int) ((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    public static void main(String[] args) {
        Point[] points = new Point[]{
                new Point(0, 3), new Point(1, 1), new Point(2, 2),
                new Point(4, 4), new Point(0, 0), new Point(1, 2),
                new Point(3, 1), new Point(3, 3)
        };
        List<Point> hull = convexHull(points);
        for (Point p : hull) System.out.println("(" + p.x + ", " + p.y + ")");
    }
}