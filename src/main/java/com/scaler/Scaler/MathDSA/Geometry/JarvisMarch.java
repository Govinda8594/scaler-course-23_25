package com.scaler.Scaler.MathDSA.Geometry;

import java.util.ArrayList;
import java.util.List;

//    Time Complexity: O(nh)
//        (n = total points, h = hull points)
public class JarvisMarch {
    // Returns side relative to line (p, q, r)
    private static int orientation(Point p, Point q, Point r) {
        int val = (int) ((q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y));
        if (val == 0) return 0;  // collinear
        return (val > 0) ? 1 : 2; // clockwise (1) or counterclockwise (2)
    }

    public static List<Point> convexHull(Point[] points) {
        int n = points.length;
        if (n < 3) return new ArrayList<>();

        // Find leftmost point
        int leftmost = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].x < points[leftmost].x ||
                    (points[i].x == points[leftmost].x && points[i].y < points[leftmost].y)) {
                leftmost = i;
            }
        }

        List<Point> hull = new ArrayList<>();
        int p = leftmost, q;
        do {
            hull.add(points[p]);
            q = (p + 1) % n;  // Start with next point

            for (int r = 0; r < n; r++) {
                // If r is more counterclockwise than q
                if (orientation(points[p], points[q], points[r]) == 2) {
                    q = r;
                }
            }
            p = q;  // Set p to most counterclockwise point
        } while (p != leftmost);  // Complete the hull

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