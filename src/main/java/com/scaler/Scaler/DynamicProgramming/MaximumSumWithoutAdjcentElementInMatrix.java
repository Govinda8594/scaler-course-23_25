package com.scaler.Scaler.DynamicProgramming;

//Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
//        However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
//        Return the maximum possible sum.
//        Note: You are allowed to choose more than 2 numbers from the grid.
public class MaximumSumWithoutAdjcentElementInMatrix {
    public int adjacent3(int[][] A) {
//col max array
        int len = A[0].length;
        int[] arr = new int[len];
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Math.max(A[0][i], A[1][i]);
        }
        int ans = maxSum(arr, len - 1, dp);
        return ans;
    }

    public int maxSum(int[] arr, int end, int[] dp) {
// ----------------Memoization or recursive or topToBottom approach------------------------- //
// base case
        if (dp[end] != 0) {
            return dp[end];
        }
        if (end == 0) {
            return arr[0];
        }
        if (end == 1) {
            return Math.max(arr[0], arr[1]);
        }
//include the element
        int include = arr[end] + maxSum(arr, end - 2, dp);
//exclude the element
        int exclude = maxSum(arr, end - 1, dp);
        dp[end] = Math.max(include, exclude);
        return dp[end];
    }

    // // ----------------Tabulation or iterative or BottomToTop approach------------------------- //
    public int maxSum2(int[] arr, int end, int[] dp) {
        if (end == 1) {
            return Math.max(arr[0], arr[1]);
        }
        if (end == 0) {
            return arr[0];
        }
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }

    //---------------Iterative approach with constant space-----------------------------------//
    public int maxSum3(int[] arr, int end, int[] dp) {
        if (end == 1) {
            return Math.max(arr[0], arr[1]);
        }
        if (end == 0) {
            return arr[0];
        }
        int a = arr[0];
        int b = Math.max(arr[0], arr[1]);
        int c = 0;
        for (int i = 2; i < dp.length; i++) {
            c = Math.max(b, arr[i] + a);
            a = b;
            b = c;
        }
        return c;
    }
}
