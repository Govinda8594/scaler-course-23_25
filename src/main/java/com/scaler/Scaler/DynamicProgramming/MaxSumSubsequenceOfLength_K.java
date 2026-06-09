package com.scaler.Scaler.DynamicProgramming;

public class MaxSumSubsequenceOfLength_K {
    //    Given an array sequence [A1 , A2 ...An], the task is to find the maximum possible sum of increasing subsequence S of length K such that Si1<=Si2<=Si3.........<=Sin.
    public int max_sum(int[] arr, int K) {
        // Code here
        int N = arr.length;
        int[][] dp = new int[K + 1][N + 1];
        dp[1][0] = arr[0]; // for the first element, K is 1, its dp is going to be number itself. this is taken care in loop.

        int maxSum = Integer.MIN_VALUE;
        for (int j = 0; j < N; j++) {
            dp[1][j] = arr[j];
            for (int i = 0; i < j; i++) {
                if (arr[j] >= arr[i]) {
                    for (int k = 1; k < K && dp[k][i] > 0; k++) {
                        if (dp[k][i] + arr[j] > dp[k + 1][j]) {
                            dp[k + 1][j] = dp[k][i] + arr[j];
                            //System.out.println(dp[K][j] + " j:" + j + " k:" + k  + " i:" + i + " dp:" + dp[k][i]);
                        }
                    }
                }
            }
            //System.out.println("max:" + dp[K][j] + " J:" + j);
            maxSum = Math.max(maxSum, dp[K][j]);
        }
        return (maxSum == 0) ? -1 : maxSum;
        // int n = arr.length;
        // int[][][] dp = new int[k + 1][n + 1][n + 1];
        // for (int[][] arr1 : dp) {
        //     for (int[] a : arr1)
        //         Arrays.fill(a, Integer.MIN_VALUE);
        // }

        // int sum = maxSum(arr, -1, 0, k, dp);
        // if (sum == Integer.MIN_VALUE)
        //     return -1 ;
        // return sum;

    }

    int maxSum(int[] arr, int pIdx, int idx, int kCounter, int[][][] dp) {
        if (kCounter <= 0) {
            return 0; // we have an increasing with 3 non-decreasing elements.
        }

        if (idx >= arr.length) {
            return Integer.MIN_VALUE; // otherwise it will overflow by adding into take/notTake.
        }
        if (dp[kCounter][pIdx + 1][idx] != Integer.MIN_VALUE) {
            return dp[kCounter][pIdx + 1][idx];
        }

        int take = Integer.MIN_VALUE;
        if (pIdx == -1 || arr[idx] >= arr[pIdx]) {
            take = maxSum(arr, idx, idx + 1, kCounter - 1, dp); // if prev ele < curr ele, dec count and add in take
            if (take != Integer.MIN_VALUE) {
                take = take + arr[idx];
            }
        }

        int notTake = maxSum(arr, pIdx, idx + 1, kCounter, dp);

        return dp[kCounter][pIdx + 1][idx] = Math.max(take, notTake);
    }
}
