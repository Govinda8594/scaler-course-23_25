package com.scaler.Scaler.Heap;

import java.util.PriorityQueue;
//We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
//        Here, the distance between two points on a plane is the Euclidean distance.
//        You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
//        NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).


public class ClosestPointToOrigin {
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
    public int[][] solve(int[][] A, int B) {
        int n = A.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(n, (p1, p2) -> p1.distance - p2.distance);
        for (int i = 0; i < n; i++) {
            int x = A[i][0];
            int y = A[i][1];
            Pair p = new Pair(i, x * x + y * y);
            pq.offer(p);
        }
        int[][] res = new int[B][2];
        while (B > 0) {
            Pair t = pq.poll();
            res[--B] = A[t.index];
        }
        return res;
    }

    class Pair {
        int index;
        int distance;

        Pair(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
