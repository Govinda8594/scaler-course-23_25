package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;
//The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
//        The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
//        Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
//        In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
//        Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.
//
//        Problem Constraints
//        1 <= M, N <= 500
//        -100 <= A[i] <= 100

public class DungeonPrinces {
    static int[][] dp1 = null;

    public static void main(String[] args) {
        int[][] arr = {{4, 5, 6, 5, 7}, {1, 2, 3, 4, 5}, {-4, -6, 3, 5, -7}};
        int n = arr.length, m = arr[0].length;
        dp1 = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp1[i], -1);
        }
        minimumHealth(0, 0, arr, n, m);
        System.out.println(dp1[n - 1][m - 1]);
    }

    static int minimumHealth(int i, int j, int[][] arr, int n, int m) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        if (i == n - 1 && j == m - 1) {
            return Math.max(1, 1 - arr[i][j]);
        }
        if (dp1[i][j] == -1) {
            int a = minimumHealth(i + 1, j, arr, n, m);
            int b = minimumHealth(i, j + 1, arr, n, m);
            dp1[i][j] = Math.max(1, Math.min(a, b) - arr[i][j]);
        }
        return dp1[i][j];
    }
    ////////////////////////////////////////////////////////////////////////

    public int calculateMinimumHP1(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                //base case
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = Math.max(1, 1 - A[i][j]);
                } else if (i == m - 1) {
                    dp[i][j] = Math.max((dp[i][j + 1] - A[i][j]), 1);
                } else if (j == n - 1) {
                    dp[i][j] = Math.max((dp[i + 1][j] - A[i][j]), 1);
                } else {
                    dp[i][j] = Math.max((Math.min(dp[i + 1][j], dp[i][j + 1]) - A[i][j]), 1);
                }
            }
        }
        return dp[0][0];
    }
}
