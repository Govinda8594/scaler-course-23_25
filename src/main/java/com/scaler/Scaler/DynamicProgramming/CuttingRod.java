package com.scaler.Scaler.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

//Problem Description
//        Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
//        Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
//        Problem Constraints
//        1 <= N <= 1000
//        0 <= A[i] <= 106

public class CuttingRod {
    //////////////////////////Bottom-up///////////////////////////////////////////////////
    public int solve1(int[] A) {
        int size = A.length;
        int[] dp = new int[size + 1];
        Arrays.fill(dp, -1);
        return cutting(size, A, dp);
    }

    public int cutting(int size, int[] A, int[] dp) {
        if (size == 0) return 0;
        if (dp[size] != -1) return dp[size];
        int ans = 0;
        for (int i = 1; i <= size; i++) {
            ans = Math.max(ans, A[i - 1] + cutting(size - i, A, dp));
        }
        return dp[size] = ans;
    }

    ////////////////////////tabulation 1Dp //////////////////
    public int solve8(int[] A) {
        int n = A.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int res = 0;
            for (int cut = 1; cut <= i; cut++) {
                res = Math.max(res, A[cut - 1] + dp[i - cut]);
            }
            dp[i] = res;
        }
        return dp[n];
    }

    /////////////////////////top -down 2Dp //////////////////////////
    public int solve(ArrayList<Integer> A) {
        int[][] dp = new int[A.size()][A.size() + 1];
        for (int i = 0; i < A.size(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return maxValue(A.size(), dp, 0, A);
    }

    private int maxValue(int len, int[][] dp, int index, ArrayList<Integer> A) {
        if (len == 0) {
            return 0;
        }
        int ans = 0;
        if (index == A.size()) {
            return Integer.MIN_VALUE;
        }
        if (dp[index][len] != -1) {
            return dp[index][len];
        }
        if (len - index - 1 >= 0) {  // can we cut the rod if yes take price
            ans = A.get(index) + maxValue(len - index - 1, dp, index, A);
        }
        // if not move to next
        ans = Math.max(maxValue(len, dp, index + 1, A), ans);
        return dp[index][len] = ans;
    }

    ///////////////////////top-dowm 1DP////////////////////////////////////////////////////////////
    public int solve4(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(A, 0, A.length, dp);
    }

    public int solve(int[] A, int idx, int n, int[] dp) {
        if (idx == n) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int maxPrice = 0;
        for (int i = idx; i < n; i++) {
            maxPrice = Math.max(maxPrice, A[i - idx] + solve(A, i + 1, n, dp));
        }
        return dp[idx] = maxPrice;
    }
}
