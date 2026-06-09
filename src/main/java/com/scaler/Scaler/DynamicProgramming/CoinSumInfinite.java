package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//You are given a set of coins A. In how many ways can you make
// sum B assuming you have infinite amount of each coin in the set.
//        NOTE:
//        Coins in set A will be unique. Expected space complexity of this problem is O(B).
//        The answer can overflow. So, return the answer % (106 + 7).
//        Problem Constraints
//        1 <= A <= 500
//        1 <= A[i] <= 1000
//        1 <= B <= 50000
public class CoinSumInfinite {
    /// /////////////////////combination with O(B) space//dp | iterative///////////////////////////////////////

    static long mod = 1000007;

    public int coinchange2(int[] A, int B) {
        long[] dp = new long[B + 1];
        dp[0] = 1;
        for (int coin : A) {
            for (int j = coin; j <= B; j++) {
                dp[j] = (dp[j] + dp[j - coin]) % mod;
            }
        }
        return (int) dp[B];
    }

    /// ////////////////////////////////////////////////////////////////////

    //NxB tabulation
    public int coinchange1(int[] A, int B) {
        int n = A.length;
        int mod = 1000007;
        int[][] dp = new int[n + 1][B + 1];
//        - There's 1 way to make sum 0 — pick no coins.
        dp[0][0] = 1;
//        - Using only the first coin A[0], we can make sums that are multiples of A[0]
//        - Example: if A[0] = 2, then dp[0][2] = dp[0][4] = dp[0][6] = ... = 1
        for (int i = 1; i <= B; i++) {
            if (A[0] <= i && i % A[0] == 0) {
                dp[0][i] = 1;
            }
        }
//        - Two choices for each coin A[i] and sum j:
//        - Exclude A[i] → dp[i - 1][j]
//        - Include and stay with same coin A[i] → dp[i][j - A[i]] (stay at same row since coins are unlimited)

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= B; j++) {
                if (A[i] <= j) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - A[i]]) % mod;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][B];
    }

    /// ////////////////bottom - recursion - 2dp////////////////////////////////////////////////

    public int coinchange24(int[] A, int B) {
        int m = A.length;
        int[][] dp = new int[m + 1][B + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return coinChange(m, B, A, dp);
    }

    public int coinChange(int i, int j, int[] A, int[][] dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        if (j == 0) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (j >= A[i - 1]) {
            dp[i][j] = coinChange(i - 1, j, A, dp) % 1000007 + coinChange(i, j - A[i - 1], A, dp) % 1000007;
        } else {
            dp[i][j] = coinChange(i - 1, j, A, dp) % 1000007;
        }
        return dp[i][j] % 1000007;
    }
}
