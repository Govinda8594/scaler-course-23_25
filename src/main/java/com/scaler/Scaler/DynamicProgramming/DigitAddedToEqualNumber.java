package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
//
//        Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
//
//        Since the answer can be large, output answer modulo 1000000007

public class DigitAddedToEqualNumber {

    Integer[][] dp;
    ////////////////DP + Recurison =>Memoization => top down//////////////////////////////////////////////////////////
    int mod = 1000000007;

    /// Iterative approach
    public int solve1(int A, int B) {
        int[][] dp = new int[A + 1][B + 1];
        int mod = 1000000007;
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                if (i == 1) {
                    dp[i][j] = j > 9 ? 0 : 1;
                } else {
                    for (int d = 0; d <= 9 && d <= j; d++) {
                        dp[i][j] += dp[i - 1][j - d];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        return dp[A][B];
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve2(int A, int B) {
        dp = new Integer[A + 1][B + 1];
        long ans = 0L;
        for (int i = 1; i < 10; i++) {
            ans += findWays(A - 1, B - i);
            ans %= mod;
        }
        return (int) ans % mod;
    }

    public int findWays(int digitLeft, int sum) {
        if (sum < 0) {
            return 0;
        }
        if (digitLeft == 0 && sum == 0) {
            return 1;
        }
        if (digitLeft == 0) {
            return 0;
        }
        if (dp[digitLeft][sum] != null) {
            return dp[digitLeft][sum];
        }
        long ans = 0L;
        for (int i = 0; i < 10; i++) {
            ans += findWays(digitLeft - 1, sum - i);
            ans %= mod;
        }
        dp[digitLeft][sum] = (int) ans % mod;
        return dp[digitLeft][sum];
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    long countWays(int n, int sum) {
        // Initialize a 2D array for memoization and fill it with -1
        long[][] dp = new long[n][sum];
        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));

        long answer = 0;

        // Loop through possible first digits (1 to 9, or sum whichever is smaller)
        for (int i = 1; i < 10; i++) {
            // Recursively call countWays for the remaining digits and sum
            answer += countWays(n - 1, sum - i, dp);
            // Take modulo to avoid overflow
            answer %= mod;
        }

        // Return the result, if it's 0, return -1
        return answer == 0 ? -1 : answer;
    }

    private long countWays(int digitLeft, int sum, long[][] dp) {
        // Base case: If no digits left, check if the sum is 0
        if (sum < 0) {
            return 0;
        }
        if (digitLeft == 0 && sum == 0) {
            return 1;
        }
        if (digitLeft == 0) {
            return 0;
        }
        if (dp[digitLeft][sum] != -1) {
            return dp[digitLeft][sum];
        }
        long count = 0;
        // Loop through all possible values for the current digit (0 to 9, or sum whichever is smaller)
        for (int i = 0; i < 10; i++) {
            // Recursively call countWays for the remaining digits and sum
            count += countWays(digitLeft - 1, sum - i, dp);
            // Take modulo to avoid overflow
            count %= mod;
        }

        // Save the result in the memoization array
        dp[digitLeft][sum] = count;

        return count;
    }
}
