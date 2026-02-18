package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
public class MinimumCountOfNumberOfSquares {
    /// ////////////////Tabulation //////////////////
    public int MinSquares(int n) {
        // Code here
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // Maximum squares required is 'i' (1^2 + 1^2 + ... + 1^2)
        }
        // solving 1 state =>iterate 1 to n ,for each state 1 to j*j <= i
//        TC : N* sqrt(N)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }
        return dp[n];
        // return minSq(n, dp);
    }

    /// ////////////////////////////////////////////////////////////////////////
    public int countMinSquares(int A) {
        // Create an array to store the minimum count of numbers required for each sum
        int[] dp = new int[A + 1];
        // Initialize the dp array with maximum values, indicating that the values have not been calculated yet
        Arrays.fill(dp, Integer.MAX_VALUE);
        return minSqu(A, dp);
    }

    public int minSqu(int i, int[] dp) {
        // Base case : If the current sum is less than or equal to 0, we return 0.
        if (i <= 0) {
            return 0;
        }
        // If the value for the current sum has not been calculated yet, compute it.
        if (dp[i] == Integer.MAX_VALUE) {
            // Iterate through all possible perfect squares less than or equal to the current sum.
            // Here, j * j represents the perfect square.
            for (int j = 1; j * j <= i; j++) {
                // Recursively call minSqu for the remaining sum after subtracting j * j,
                // and add 1 to account for the current perfect square.
                dp[i] = Math.min(dp[i], minSqu(i - j * j, dp) + 1);
            }
        }
        return dp[i];
    }
}
