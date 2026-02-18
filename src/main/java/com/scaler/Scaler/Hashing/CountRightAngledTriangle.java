package com.scaler.Scaler.Hashing;

import java.util.HashMap;
import java.util.Map;

//Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.
//        Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.
//        NOTE: The answer may be large so return the answer modulo (109 + 7).
public class CountRightAngledTriangle {
    public static void main(String[] args) {
        countRightAngledTriangles(new int[]{1, 1, 2, 3, 3}, new int[]{1, 2, 1, 2, 1});
    }

    public static int countRightAngledTriangles(int[] A, int[] B) {
        int n = A.length;
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            xMap.put(A[i], xMap.getOrDefault(A[i], 0) + 1);
            yMap.put(B[i], yMap.getOrDefault(B[i], 0) + 1);
        }
        int count = 0;
        // considering total point parallel to x-axis and y-axis ,that way we can create right-angles triangle
        for (int i = 0; i < n; i++) {
            int xCount = xMap.get(A[i]);
            int yCount = yMap.get(B[i]);
            count += (xCount - 1) * (yCount - 1);
        }
        return count % 1000000007;
    }

    //    Frequency Maps Setup:
//    freqX and freqY store the counts of each x and y coordinate encountered in the input arrays.
//    pointFreq stores the counts of each distinct point (x, y) to handle duplicates.
//    Triangle Counting:
//    For each point (x, y), calculate:
//    countX: Number of points with the same x-coordinate, excluding those at (x, y).
//    countY: Number of points with the same y-coordinate, excluding those at (x, y).
//    The product countX * countY gives the number of valid triangles where (x, y) is the right-angle vertex.
//    Modulo Operation: The result is taken modulo 1000000007 to handle large numbers as specified.
    public static int countRightAngledTriangles1(int[] A, int[] B) {
        int mod = 1000000007;
        int n = A.length;
        Map<Integer, Integer> freqX = new HashMap<>();
        Map<Integer, Integer> freqY = new HashMap<>();
        Map<String, Integer> pointFreq = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = A[i];
            int y = B[i];
            freqX.put(x, freqX.getOrDefault(x, 0) + 1);
            freqY.put(y, freqY.getOrDefault(y, 0) + 1);
            String key = x + "," + y;
            pointFreq.put(key, pointFreq.getOrDefault(key, 0) + 1);
        }

        long totalCount = 0;
        for (int i = 0; i < n; i++) {
            int x = A[i];
            int y = B[i];
            String key = x + "," + y;
            long countX = freqX.get(x) - pointFreq.get(key);
            long countY = freqY.get(y) - pointFreq.get(key);
            totalCount = (totalCount + countX * countY) % mod;
        }

        return (int) (totalCount % mod);
    }
}
