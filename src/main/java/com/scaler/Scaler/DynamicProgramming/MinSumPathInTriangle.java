package com.scaler.Scaler.DynamicProgramming;

//Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
//        Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row
//        Problem Constraints
//        |A| <= 1000
//        A[i] <= 1000
//        Input Format
//        First and only argument is the vector of vector A defining the given triangle
//        Output Format
//        Return the minimum sum
//        Example Input
//        Input 1:
//
//        A = [
//        [2],
//        [3, 4],
//        [6, 5, 7],
//        [4, 1, 8, 3]
//        ]
//        Input 2:
//        A = [ [1] ]
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//         Explanation 2:
//         Only 2 can be collected.

public class MinSumPathInTriangle {
    // Top Down Approach
    public int minimumTotal1(int[][] a) {
        int[][] dp = new int[a.length][];
        for (int i = 0; i < a.length; i++) {
            int[] list = a[i];
            dp[i] = new int[list.length];
        }
        return solve(a, 0, 0, dp);
    }

    int solve(int[][] a, int row, int col, int[][] dp) {
        if (row == a.length) {
            return 0;
        }
        if (dp[row][col] != 0) {
            return dp[row][col];
        }
        int ans = 0;
        ans += a[row][col];
        ans += Math.min(solve(a, row + 1, col, dp), solve(a, row + 1, col + 1, dp));
        dp[row][col] = ans;
        return ans;
    }

    // Bottom Up approach
    public int minimumTotal(int[][] a) {
        int N = a.length;
        for (int i = N - 2; i >= 0; i--) {
            int M = a[i].length;
            for (int j = 0; j < M; j++) {
                int left = a[i + 1][j]; //left adjacent
                int right = a[i + 1][j + 1]; //right adjacent
                a[i][j] = Math.min(left, right) + a[i][j];
            }
        }
        return a[0][0];
    }

    // DP + Memoization )(N)
    public int minimumTotal2(int[][] A) {
        int m, n;
        m = A.length;
        n = A[m - 1].length;
        int[] dp = new int[n + 1];
        int size = n;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < size; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + A[i][j];
            }
            size--;
        }
        return dp[0];
    }

    //////////////////////// // DP + Memoization )(N2)////////////////////////////////////////////
    public int minimumTotal3(int[][] a) {
        int n = a.length;
        int[][] dp = new int[n][n];
        System.arraycopy(a[n - 1], 0, dp[n - 1], 0, n);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = dp[i + 1][j];
                int diagonal = dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, diagonal) + a[i][j];
            }
        }
        return dp[0][0];
    }


}
