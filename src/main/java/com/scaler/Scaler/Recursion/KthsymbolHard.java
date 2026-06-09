package com.scaler.Scaler.Recursion;
//On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
//        Given row number A and index B, return the Bth indexed symbol in row A. (The values of B are 0-indexed.).
public class KthsymbolHard {

    public int solve(int A, long B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        int val = solve(A - 1, B / 2);
        if (B % 2 == 0) {
            return val;
        } else {
            return 1 - val;
        }
    }

    public int solve2(int A, long B) {
        if (B == 0 || A == 1) {
            return 0;
        }
        if (B % 2 == 0) {
            return solve2(A - 1, B / 2);
        } else {
            return 1 - solve2(A - 1, B / 2);
        }
    }
}
