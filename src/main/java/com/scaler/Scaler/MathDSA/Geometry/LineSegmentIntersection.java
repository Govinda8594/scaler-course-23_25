package com.scaler.Scaler.MathDSA.Geometry;

public class LineSegmentIntersection {
    static boolean onSegment(Point p, Point q, Point r) {
        return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
    }

    static int orientation(Point p, Point q, Point r) {
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0;  // collinear
        return (val > 0) ? 1 : 2; // clockwise or counterclockwise
    }

    static boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        // General case
        if (o1 != o2 && o3 != o4) return true;

        // Special cases (collinear)
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 1), q1 = new Point(10, 1);
        Point p2 = new Point(1, 2), q2 = new Point(10, 2);
        System.out.println(doIntersect(p1, q1, p2, q2) ? "Yes" : "No"); // No

        p1 = new Point(10, 0);
        q1 = new Point(0, 10);
        p2 = new Point(0, 0);
        q2 = new Point(10, 10);
        System.out.println(doIntersect(p1, q1, p2, q2) ? "Yes" : "No"); // Yes
    }
}