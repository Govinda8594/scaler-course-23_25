package com.scaler.Scaler.MathDSA.Geometry;

class Rectangle {
    int x1, y1, x2, y2;

    Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1; // bottom-left
        this.x2 = x2;
        this.y2 = y2; // top-right
    }
}

public class RectangleOverlap {
    static boolean doOverlap(Rectangle r1, Rectangle r2) {
        // One rectangle is to the left of the other
        if (r1.x1 >= r2.x2 || r2.x1 >= r1.x2) return false;
        // One rectangle is below the other
        if (r1.y1 >= r2.y2 || r2.y1 >= r1.y2) return false;
        return true;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(0, 0, 2, 2);
        Rectangle r2 = new Rectangle(1, 1, 3, 3);
        System.out.println(doOverlap(r1, r2) ? "Overlap" : "No Overlap"); // Overlap
    }
}