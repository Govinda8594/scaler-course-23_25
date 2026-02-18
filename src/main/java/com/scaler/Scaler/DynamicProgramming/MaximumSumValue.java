package com.scaler.Scaler.DynamicProgramming;

import java.util.ArrayList;

//You are given an array A of N integers and three integers B, C, and D.
//        You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
public class MaximumSumValue {

    /// Tabulation + space optimization
    public int solve(ArrayList<Integer> A, int B, int C, int D) {
        //Keep track of the maximum cumulative sum of three variables B, C and D
        //We are taking cumulative of B, C and D since i<=j<=k
        int n = A.size();
        int maxB = A.get(0) * B; //First value
        int maxC = A.get(0) * C + maxB; //Second cumulative value
        int maxD = A.get(0) * D + maxC; //Third and final cumulative value that should be maximum at the end
        for (int i = 1; i < n; i++) {
            maxB = Math.max(maxB, A.get(i) * B);
            maxC = Math.max(maxC, A.get(i) * C + maxB);
            maxD = Math.max(maxD, A.get(i) * D + maxC);
        }
        return maxD;
    }

    /// /////////////////////////////////////////////////////////////Tabulation + dp table
    public int solve2(int[] A, int B, int C, int D) {
        int n = A.length;
        int[][] dp = new int[n + 1][3]; // dp array to store answer of previous states
        for (int i = 0; i <= n; i++) {
            dp[i][0] = dp[i][1] = dp[i][2] = -1000000000; // Initialize the dp array with minus infinity
        }
        for (int i = 1; i <= n; i += 1) {
            dp[i][0] = Math.max(dp[i - 1][0], A[i - 1] * B); // Maximum value of A[i]*B
            dp[i][1] = Math.max(dp[i - 1][1], dp[i][0] + A[i - 1] * C); // Maximum value of A[i]*B + A[j]*C
            dp[i][2] = Math.max(dp[i - 1][2], dp[i][1] + A[i - 1] * D); // Maximum value of A[i]*B + A[j]*C + A[k]*D
        }
        return dp[n][2]; // return the answer.
    }

    /// ////////////////////////////////Recursion////////////////////////////////////////////////////////

    private int util(int[] A, int[] val, int i, int j, int[][] dp) {
        int n = A.length;
        if (i == n) {
            return -1000000000;
        }
        if (j == 3) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int res = Integer.MIN_VALUE;
        int ans1 = (A[i] * val[j]) + util(A, val, i, j + 1, dp); // force to use same index for next value, take and move
        int ans2 = (A[i] * val[j]) + util(A, val, i + 1, j + 1, dp);  // force to use next index for next value,leave and move
        int ans3 = util(A, val, i + 1, j, dp); // Dont use the current index for calculation use next indexes, move
        res = Math.max(ans1, Math.max(ans2, ans3)); // return max out of it
        return dp[i][j] = res;
    }

    public int solve(int[] A, int B, int C, int D) {
        return util(A, new int[]{B, C, D}, 0, 0, new int[A.length][3]);
    }
}
