package com.scaler.Scaler.DynamicProgramming.FindSumPattern;

import java.util.Arrays;

public class CountSubsetWithSum_K {

    //    Given A[N] elements. find total no of subset with sum K where all elements are +ve and Every element can be picked any number of times or zero number of times.
//    write a java code for it
    static int[][] dp = null;

    static int isSubsetSum(int[] set, int i, int sum) {
        if (i < 0) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[i][sum] == -1) {
            int a = isSubsetSum(set, i - 1, sum);
            int b = 0;
            if (sum >= set[i]) {
                b = isSubsetSum(set, i - 1, sum - set[i]);
            }
            dp[i][sum] = a + b;
        }
        return dp[i][sum];
    }

    /// ////////////////////////////////////////////////////////////////////////////////////////////////
    static int isSubsetSum2(int[] set, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (set[n - 1] > sum) {
            return isSubsetSum2(set, n - 1, sum);
        }
        return isSubsetSum2(set, n - 1, sum) + isSubsetSum2(set, n - 1, sum - set[n - 1]);
    }

    static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 9;
        int n = arr.length;
        int ans = isSubsetSum2(arr, n, sum); // recusrive code
        dp = new int[n][sum + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }
        isSubsetSum(arr, n, sum); // top - down
        ans = dp[n - 1][sum];
        int count = countSubsets(arr, n, sum);
        System.out.println("The total number of subsets with sum " + sum + " is " + count);

    }

    /// //////////////////////////////////////////////////////////////////////////////////////
    static int countSubsets(int[] arr, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        // Base: one way to make 0
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    // COuntSubsetSum Element picked 0 or any no of time
    static int isSubsetSum3(int[] set, int i, int sum) {
        if (i < 0) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[i][sum] == -1) {
            int a = isSubsetSum3(set, i - 1, sum);
            int b = 0;
            if (sum >= set[i]) {
                b = isSubsetSum3(set, i, sum - set[i]);
            }
            dp[i][sum] = a + b;
        }
        return dp[i][sum];
    }
}
