package com.scaler.Scaler.DynamicProgramming;

//
//Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//        Return the minimum sum of the path.
//        NOTE: You can only move either down or right at any point in time.
//
//        Problem Constraints
//        1 <= M, N <= 2000
//        -1000 <= A[i][j] <= 1000

public class MinimumSumPathInMatrix {
    Integer[][] dp;

    // Example usage
    public static void main(String[] args) {
        int[][] A = {
                {5, 3, 7},
                {1, 8, 4},
                {2, 6, 9}
        };
        int result = new MinimumSumPathInMatrix().minPathSum(A);
        System.out.println("Minimum path sum: " + result);
    }

    public int minPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        // dp[i][j] = minimum sum to reach cell (i,j) from (0,0)
        int[][] dp = new int[n][m];

        // 1. Base initialization: start cell
        dp[0][0] = A[0][0];

        // 2. First row (can only come from the left)
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + A[0][j];
        }

        // 3. First column (can only come from above)
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + A[i][0];
        }

        // 4. Fill the rest of the table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // You can arrive at (i,j) either from (i-1,j) or (i,j-1)
                dp[i][j] = A[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        // 5. Answer is bottom-right corner
        return dp[n - 1][m - 1];
    }

    //top down approach with memoization

    public int minPathSum2(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        dp = new Integer[n][m];
        return findMinSum(0, 0, n, m, A);
    }

    public int findMinSum(int x, int y, int n, int m, int[][] A) {
        if (x >= n || y >= m) {
            return 10001;
        }
        if (x == n - 1 && y == m - 1) {
            return A[x][y];
        }
        if (dp[x][y] != null) {
            return dp[x][y];
        }
        int down = findMinSum(x + 1, y, n, m, A);
        int right = findMinSum(x, y + 1, n, m, A);
        dp[x][y] = A[x][y] + Math.min(down, right);
        return dp[x][y];
    }
}
