package com.scaler.Scaler.Hashing;

import java.util.HashSet;

public class CountRectangle {
    //    Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
//    Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
    public int solve(int[] X, int[] Y) {
        HashSet<String> hs = new HashSet<>();
        int Xlen = X.length;
        int Ylen = Y.length, count = 0;
        for (int i = 0; i < Xlen; i++) {
            String p = X[i] + "@" + Y[i];
            hs.add(p);
        }
        for (int i = 0; i < Xlen; i++) {
            for (int j = i + 1; j < Ylen; j++) {
                int a = X[i], b = Y[i], p = X[j], q = Y[j];  // one diagonal co-ordinate (a,b) -> (p,q)
                if (a != p && b != q) {    // opposite diagonal co-ordinate should not be same
                    String p1 = a + "@" + q;   //
                    String p2 = p + "@" + b;
                    if (hs.contains(p1) && hs.contains(p2)) { // check other diagonal (a,q) -> (p,b)
                        count++;
                    }
                }
            }
        }
        return count / 2;
    }
}
