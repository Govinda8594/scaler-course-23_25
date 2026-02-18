package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;
import java.util.TreeSet;

//Given a matrix of integers A of size N x 2 describing dimensions of N envelopes, where A[i][0] denotes the height of the ith envelope and A[i][1] denotes the width of the ith envelope.
//        One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
//        Find the maximum number of envelopes you can put one inside other.
public class RussianDollEnvelop {
    int[][] dp;

    public static void main(String[] args) {
        int[][] A = new int[][]{
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3}
        };

        RussianDollEnvelop russianDollEnvelop = new RussianDollEnvelop();
        russianDollEnvelop.solve2(A);
    }

    //    LIS Application
    public int solve(int[][] A) {
        int n = A.length;
        // Ascending order based on height
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp = new int[n];
        //same as length of longest increasing subsequence problem
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // check height ,then width
                if (A[j][1] < A[i][1] && A[j][0] < A[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxLength = 0;
        for (int l : dp) {
            maxLength = Math.max(maxLength, l);
        }
        return maxLength + 1;
    }

    //////////////////////////////////////////////////////////////////////////////////////
    public int solve5(int[][] A) {
        Arrays.sort(A, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return Integer.compare(e2[1], e1[1]);
            } else {
                return Integer.compare(e1[0], e2[0]);
            }
        });
        int[] nums = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            nums[i] = A[i][1];
        }
        return lis(nums);
    }

    public int lis(int[] nums) {
        TreeSet<Integer> bst = new TreeSet<>();
        for (int num : nums) {
            Integer higher = bst.ceiling(num);
            if (higher == null) {
                bst.add(num);
            } else {
                bst.remove(higher);
                bst.add(num);
            }
        }
        return bst.size();
    }

    ////////////////////////top-down////////////////////////////////////////////////////////
    public int solve2(int[][] A) {
        int n = A.length;
        dp = new int[n + 1][n + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        // Descending order
        Arrays.sort(A, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });
        // i -> current idx; j -> previous idx
        return helper(A, n, 0, -1);
    }

    private int helper(int[][] A, int n, int i, int j) {
        if (i >= n) {
            return 0;
        }
        if (dp[i][j + 1] != -1) {
            return dp[i][j + 1];
        }
        int len = helper(A, n, i + 1, j);//not take
        if (j == -1 || ((A[i][0] < A[j][0]) && (A[i][1] < A[j][1]))) {
            len = Math.max(len, 1 + helper(A, n, i + 1, i)); //take
        }
        return dp[i][j + 1] = len;
    }
}
