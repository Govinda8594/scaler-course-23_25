package com.scaler.Scaler.DynamicProgramming.FindSumPattern;

import java.util.Arrays;


public class MinimumElementRequiredForSum_K {
    static int[][] dp = null;

    //element picked 0/1 time
    static int isSubsetSum2(int[] set, int i, int sum) {
        if (i < 0) {
            if (sum == 0) {
                return 0;
            } else {
                return set.length + 1;
            }
        }
        if (dp[i][sum] == set.length + 1) {
            int a = isSubsetSum2(set, i - 1, sum);
            int b = 0;
            if (sum >= set[i]) {
                b = isSubsetSum2(set, i - 1, sum - set[i]) + 1;
            }
            dp[i][sum] = Math.min(a, b);
        }
        return dp[i][sum];
    }

    public static void main2(String[] args) {
        int[] set = {1, 2, 3, 4, 5};
        int sum = 9;
        int n = set.length;
        int[][] dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], n + 1);
        }
        isSubsetSum2(set, n, sum);
        int ans1 = dp[n - 1][sum];
    }

    // element picked 0/any number of time
    static int isSubsetSum(int[] set, int i, int sum) {
        if (i < 0) {
            if (sum == 0) {
                return 0;
            } else {
                return set.length + 1;
            }
        }
        if (dp[i][sum] == set.length + 1) {
            int a = isSubsetSum2(set, i - 1, sum);
            int b = 0;
            if (sum >= set[i]) {
                b = isSubsetSum2(set, i, sum - set[i]) + 1;
            }
            dp[i][sum] = Math.min(a, b);
        }
        return dp[i][sum];
    }


}
