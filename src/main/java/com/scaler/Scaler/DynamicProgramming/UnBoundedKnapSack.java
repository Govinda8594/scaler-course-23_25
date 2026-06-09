package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//Given a knapsack weight A and a set of items with certain value B[i] and weight C[i],
// we need to calculate maximum amount that could fit in this quantity.
//        This is different from classical Knapsack problem,
//        here we are allowed to use unlimited number of instances of an item.
public class UnBoundedKnapSack {

    /// /////////////////////////////=> Tabulation////////////////////////////////////////////////////////////////////
    int[][] dp;

    public int solve2(int A, int[] B, int[] C) {
        int n = B.length;
        int ans = 0;
        while (A > 0) {
            int max = 0;
            int j = -1;
            // A/C[i] gives max number of instances possible for every element
            for (int i = 0; i < n; i++) {
                if ((A / C[i]) * B[i] > max) { //looking for max weight,amount per weight
                    max = (A / C[i]) * B[i];
                    j = i;
                }
            }
            if (j != -1) {
                A = A % C[j]; //calculating remaining weight limit
                ans += max;
            } else {
                break;
            }
        }
        return ans;
    }

    /// /////////////////////////////////////////////Tabulation + Space Optimization//////////////////////////////////////////////////////////////////////////////////
    public int solve1(int A, int[] B, int[] C) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, 0);
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j < C.length; j++) {
                if (C[j] <= i) {
                    dp[i] = Math.max(dp[i], dp[i - C[j]] + B[j]);
                }
            }
        }
        return dp[A];
    }

    /// ///////////////////////Recursion + DP + top-down/////////////////////////////////////////////////////////////////////
    public int solve(int A, int[] B, int[] C) {
        int N = B.length;
        dp = new int[N][A + 1];
        // Initialize the dp array with -1
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= A; j++) {
                dp[i][j] = -1;
            }
        }
        // Call the knapSack function to solve the problem
        return knapSack(N - 1, A, C, B);
    }

    public int knapSack(int i, int j, int[] wei, int[] val) {
        // Base case If no items left or capacity becomes 0, return 0
        if (i < 0 || j <= 0) {
            return 0;
        }
        if (dp[i][j] == -1) { // if it calculate for first time
            int a = knapSack(i - 1, j, wei, val);
            if (j >= wei[i]) {
                a = Math.max(a, val[i] + knapSack(i, j - wei[i], wei, val));
            }
            dp[i][j] = a;
        }
        return dp[i][j];
    }
}
