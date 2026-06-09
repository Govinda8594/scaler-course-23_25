package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//Given at Calculate max subsequence sum
//        Note In a subsequence 2 adjacent elements cannot bepicked
//        note2 Empty subsequence is also valid
public class MaxSubsequenceSumWithoutAdjcentElementInArray {
    static int[] dp = null;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        maxSubsequenceSum2(arr, 0);
        System.out.println(dp[0]);
    }

    /////////////////////////////////////////////////////////
    static int maxSubsequenceSum2(int[] arr, int i) {
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i] == -1) {
            dp[i] = Math.max(maxSubsequenceSum2(arr, i + 1), maxSubsequenceSum2(arr, i + 2) + arr[i]);
        }
        return dp[i];
    }
}
