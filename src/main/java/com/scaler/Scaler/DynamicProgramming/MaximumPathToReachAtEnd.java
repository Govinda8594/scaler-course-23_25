package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;
//Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
//        At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
//
//        Now consider if some obstacles are added to the grids.
//        Return the total number unique paths from (1, 1) to (n, m).
//
//        Note:
//        1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
//        2. Given Source Point and Destination points are 1-based index.

public class MaximumPathToReachAtEnd {

    static int[][] dp = null;

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 0, 0, 1}, {0, 1, 0, 0,}, {0, 0, 0, 0}};
        int n = arr.length, m = arr[0].length;
        dp = new int[n][m];
        Arrays.fill(dp, -1);
        waysToreach(n - 1, m - 1, arr);
        System.out.println(dp[n - 1][m - 1]);
    }

    static int waysToreach(int i, int j, int[][] arr) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (arr[i][j] == 1) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] == -1) {
            dp[i][j] = waysToreach(i - 1, j, arr) + waysToreach(i, j - 1, arr);
        }
        return dp[i][j];
    }

    /// Tabulation + space optimization => bottom up
    public int uniquePathsWithObstacles(int[][] A) {
        int N = A.length, M = A[0].length;
        int[] dp = new int[M];
        if (A[0][0] == 1) {
            return 0;
        }
        for (int i = 0, j = 0; j < M; j++) {
            if (A[i][j] == 0) {
                if (j == 0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j - 1];
                }
            } else {
                dp[j] = 0;
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    if (j != 0) {
                        dp[j] = dp[j - 1] + dp[j];
                    }
                } else {
                    dp[j] = 0;
                }
            }
        }
        return dp[M - 1];
    }

    // Approach 1: dp + Memoization => bottom up
    public int uniquePathsWithObstacles3(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        Integer[][] dp = new Integer[A.length][A[0].length];
        if (A[0][0] == 1 || A[n - 1][m - 1] == 1) {
            return 0;
        }
        int value = 1;
        int i, j;
        for (i = 0; i < n; i++) {
            if (A[i][0] == 1) {
                value = 0;
            }
            dp[i][0] = value;
        }
        value = 1;
        for (j = 0; j < m; j++) {
            if (A[0][j] == 1) {
                value = 0;
            }
            dp[0][j] = value;
        }
        for (i = 1; i < n; i++) {
            for (j = 1; j < m; j++) {
                if (A[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
