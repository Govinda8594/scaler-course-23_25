package com.scaler.Scaler.Hashing;

import java.util.HashMap;
import java.util.Map;

//Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane. A[i] describe x coordinates of the ith point in the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the 2D plane.
//        Find and return the maximum number of points that lie on the same line.
public class PointOnSameLine {

    public int solve3(int[] A, int[] B) {
        int ans = 0;
        int n = A.length;
        HashMap<Double, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (A[i] == A[j] && B[i] == B[j]) {
                    cnt++;
                    continue;
                }
                double slope = (double) (B[j] - B[i]) / (double) (A[j] - A[i]);
                mp.put(slope, mp.getOrDefault(slope, 0) + 1);
            }
            ans = Math.max(ans, cnt);
            for (double tmp : mp.keySet()) {
                ans = Math.max(ans, mp.get(tmp) + cnt);
            }
            mp.clear();
        }
        return ans;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    public int maxPoints(int[] A, int[] B) {
        int n = A.length;
        if (n <= 2) return n; // Edge case: 0, 1, or 2 points
        int max = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicates = 1; // Include the current point
            int localMax = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue; // Skip same point
                if (A[i] == A[j] && B[i] == B[j]) {
                    duplicates++; // Count duplicates
                    continue;
                }
                int dx = A[j] - A[i]; // Delta x
                int dy = B[j] - B[i]; // Delta y
                String slope;
                if (dx == 0) {
                    slope = "inf"; // Vertical line
                } else if (dy == 0) {
                    slope = "0"; // Horizontal line
                } else {
                    int gcd = gcd(Math.abs(dx), Math.abs(dy)); // GCD for normalization
                    dx /= gcd;
                    dy /= gcd;
                    if (dx < 0) { // Ensure consistent representation
                        dx = -dx;
                        dy = -dy;
                    }
                    slope = dy + "/" + dx; // Normalized slope
                }
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopeMap.get(slope));
            }
            max = Math.max(max, localMax + duplicates);
        }
        return max;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b); // Helper for GCD calculation
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int maxPoints(int[][] p) {
        int n = p.length;
        if (n <= 2) {
            return n;
        }
        int ans = 2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = 2;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
//                        (y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)
                        int x = (p[j][1] - p[i][1]) * (p[k][0] - p[i][0]);
                        int y = (p[k][1] - p[i][1]) * (p[j][0] - p[i][0]);
//                        This condition checks if the slopes between points (i, j) and (i, k) are equal, indicating collinearity.
                        if (x == y) { //
                            temp++;
                        }
                    }
                }
                if (temp > ans) {
                    ans = temp;
                }
            }
        }
        return ans;
    }
}
