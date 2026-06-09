package com.scaler.Scaler.DynamicProgramming;

import java.util.HashMap;

//Given a strictly increasing array A of positive integers forming a sequence.
//        A sequence X1, X2, X3, ..., XN is fibonacci like if
//        N > =3
//        Xi + Xi+1 = Xi+2 for all i+2 <= N
//        Find and return the length of the longest Fibonacci-like subsequence of A.
//        If one does not exist, return 0.
//        NOTE: A subsequence is derived from another sequence A by deleting any number of elements (including none) from A, without changing the order of the remaining elements.
//        Problem Constraints
//        3 <= length of the array <= 1000
//        1 <= A[i] <= 109
//        Input Format
//        The only argument given is the integer array A.

public class Length_of_Longest_Fibonacci_Subsequence {

    public int solve3(int[] A) {
        int n = A.length, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = A[i] - A[j];
                int k = map.get(diff);
                if (map.containsKey(diff) && k < j) {
                    dp[i][j] = Math.max(dp[i][j], dp[j][k] + 1);
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return (maxLen == 0) ? 0 : maxLen + 2;
    }
}
