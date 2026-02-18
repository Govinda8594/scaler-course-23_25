package com.scaler.Scaler.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
//        Here, the distance between two points on a plane is the Euclidean distance.
//        You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
//        NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ).
public class BClosestPointPair {

    /// ///////////using Heaps ///////////
    public int[][] solve(int[][] points, int K) {
        // sort A based on distance to origin
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Double.compare(a.distance, b.distance));

        for (int[] point : points) {
            pq.offer(new Point(point[0], point[1]));
        }

        int[][] result = new int[K][2];
        int i = 0;

        while (K-- > 0) {
            Point p = pq.poll();
            result[i][0] = p.x;
            result[i][1] = p.y;
            i++;
        }

        return result;
    }

    /// ////////////////////////////////////////////////////////////
    public int[][] bClosestPointPair(int[][] A, int B) {
        int n = A.length;
        Integer[][] mat = new Integer[A.length][2];
        for (int i = 0; i < n; i++) {
            mat[i][0] = A[i][0];
            mat[i][1] = A[i][1];
        }
        Arrays.sort(mat, new Comparator<Integer[]>() {
            public int compare(Integer[] a, Integer[] b) {
                double x = distance(a);
                double y = distance(b);
                if (x < y) {
                    return -1;
                } else if (x > y) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        int[][] ans = new int[B][2];
        for (int i = 0; i < B; i++) {
            ans[i][0] = mat[i][0];
            ans[i][1] = mat[i][1];
        }
        return ans;
    }

    public static double distance(Integer[] a) {
        double x = a[0];
        double y = a[1];
        return Math.sqrt(x * x + y * y);
    }


    static class Point {
        int x, y;
        double distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(x * x + y * y);
        }
    }
}
