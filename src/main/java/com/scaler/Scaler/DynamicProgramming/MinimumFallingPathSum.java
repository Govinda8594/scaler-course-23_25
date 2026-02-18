package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

public class MinimumFallingPathSum {
    /*
    Given N * N matrix find min sum we can get such that
 a) In every row we should pick one element
 b) No 2 elements chosen in adjacent sows cannot be in same colum
     */
    public int minFallingPathSum(int[][] grid) {
        int N = grid.length;
        int[][] dp = new int[N][N];

        // Initialize first row
        System.arraycopy(grid[0], 0, dp[0], 0, N);

        for (int i = 1; i < N; i++) {
            // Precompute prefix and suffix min for previous row
            int[] prefixMin = new int[N];
            int[] suffixMin = new int[N];

            prefixMin[0] = dp[i - 1][0];
            for (int j = 1; j < N; j++) {
                prefixMin[j] = Math.min(prefixMin[j - 1], dp[i - 1][j]);
            }

            suffixMin[N - 1] = dp[i - 1][N - 1];
            for (int j = N - 2; j >= 0; j--) {
                suffixMin[j] = Math.min(suffixMin[j + 1], dp[i - 1][j]);
            }

            // Fill current row
            for (int j = 0; j < N; j++) {
                int minPrev = Integer.MAX_VALUE;
                if (j > 0) minPrev = Math.min(minPrev, prefixMin[j - 1]);
                if (j < N - 1) minPrev = Math.min(minPrev, suffixMin[j + 1]);

                dp[i][j] = grid[i][j] + minPrev;
            }
        }

        // Final answer: min in last row
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < N; j++) {
            result = Math.min(result, dp[N - 1][j]);
        }

        return result;
    }


    public int minSum(int[][] matrix) {
        int N = matrix.length;
        int[][] dp = new int[N][N];

        // Initialize the first row of dp with the first row of the matrix
        System.arraycopy(matrix[0], 0, dp[0], 0, N);

        // Fill the DP table
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < N; k++) {
                    if (k != j) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + matrix[i][j]);
                    }
                }
            }
        }

        // Find the minimum sum in the last row of the DP table
        int minSum = Integer.MAX_VALUE;
        for (int j = 0; j < N; j++) {
            minSum = Math.min(minSum, dp[N - 1][j]);
        }

        return minSum;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    public int minSum2(int[][] matrix) {
        int N = matrix.length;
        // memo[row][lastExcluded + 1], where lastExcluded == -1 maps to index 0
        int[][] memo = new int[N][N + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return findMinSum(matrix, 0, -1, N, memo);
    }

    private int findMinSum(int[][] matrix, int row, int excludeCol, int N, int[][] memo) {
        if (row == N) {
            return 0;
        }

        // map excludeCol (-1..N-1) → idx (0..N)
        int idx = excludeCol + 1;
        if (memo[row][idx] != -1) {
            return memo[row][idx];
        }

        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < N; col++) {
            if (col == excludeCol) continue;

            int candidate = matrix[row][col]
                    + findMinSum(matrix, row + 1, col, N, memo);
            minSum = Math.min(minSum, candidate);
        }

        memo[row][idx] = minSum;
        return minSum;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    private int findMinSum(int[][] matrix, int row, int excludeCol, int N) {
        if (row == N) {
            return 0;
        }

        int minSum = Integer.MAX_VALUE;
        for (int col = 0; col < N; col++) {
            if (col != excludeCol) {
                int currentSum = matrix[row][col] + findMinSum(matrix, row + 1, col, N);
                minSum = Math.min(minSum, currentSum);
            }
        }
        return minSum;
    }

}
