package com.scaler.Scaler.DynamicProgramming;

//Rishik likes candies a lot. So, he went to a candy-shop to buy candies.
//        The shopkeeper showed him N packets each containg A[i] candies for cost of C[i] nibbles, each candy in that packet has a sweetness B[i].
//        The shopkeeper puts the condition that Rishik can buy as many complete candy-packets as he wants but he can't buy a part of the packet.
//        Rishik has D nibbles, can you tell him the maximum amount of sweetness he can get from candy-packets he will buy?
//        Problem Constraints
//        1 <= N <= 700
//        1 <= A[i] <= 1000
//        1 <= B[i] <= 1000
//        1 <= C[i],D <= 1000

public class BuyingCandies {
    int[][] dp;

    /// ////////////////////////////top-down////////////////////////////////////////////////////////////////
    public int helper(int[] candy, int[] sweetness, int[] cost, int i, int cap) {
        if (i < 0 || cap == 0) {
            return 0;
        }
        if (dp[i][cap] != -1) {
            return dp[i][cap];
        }
        int a = helper(candy, sweetness, cost, i - 1, cap);
        if (cap >= cost[i]) {
            a = Math.max(a, helper(candy, sweetness, cost, i, cap - cost[i]) + sweetness[i]);
        }
        dp[i][cap] = a;
        return a;
    }

    public int recursiveUnbounded(int[] val, int[] wt, int w, int n) {
        if (n < 0) {
            return 0;
        }
//        or not take it
        int ignore = recursiveUnbounded(val, wt, w, n - 1);
        if (wt[n] <= w) {
            // Take it
            int take = val[n] + recursiveUnbounded(val, wt, w - wt[n], n);
            return Math.max(take, ignore);
        }
        return ignore;
    }

    public int solve5(int[] A, int[] B, int[] C, int D) {
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i] * B[i];
        }
        // return recursiveUnbounded(B, C, D, B.length-1);
        // int[][] dp = new int[D+1][B.length];
        // for(int[] row: dp) Arrays.fill(row, -1);
        // return helper(B, C, D, B.length-1, dp);
        // Iterative Solution(Tabulation)
        int[][] dp = new int[D + 1][B.length + 1];
        for (int i = 0; i <= D; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= B.length; i++) {
            for (int j = 1; j <= D; j++) {
                int ignore = dp[j][i - 1];
                int take = 0;
                if (C[i - 1] <= j) {
                    // Take it or not take it
                    take = B[i - 1] + dp[j - C[i - 1]][i];
                }
                dp[j][i] = Math.max(take, ignore);
            }
        }
        return dp[D][B.length];
    }
}
