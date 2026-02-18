package com.scaler.Scaler.DynamicProgramming.FindSumPattern;

import java.util.Arrays;

public class ExistASubsetPickedZer0TimesORAnyNoOfTimes {
    //    Given A[N] elements.
    //    find minimum no of element required to get sum K
    //    where all elements are +ve and Every element can be picked any number
    //    of times or zero number of times.
//    write a java code for it.

    static boolean isSubsetSum(int[] set, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        // Base cases
        for (int i = 0; i <= n; i++)
            dp[i][0] = true;
//        for (int j = 1; j <= sum; j++)
//            dp[0][j] = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= set[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - set[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }

    public static void main3(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 11;
        int n = arr.length;
        int count = minElements(arr, n, sum);
        System.out.println("The minimum number of elements required to get a sum of " + sum + " is " + count);
    }

    static int minElements(int[] arr, int n, int sum) {
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= sum; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] <= i) {
                    int sub_res = dp[i - arr[j]];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < dp[i]) {
                        dp[i] = sub_res + 1;
                    }
                }
            }
        }
        return dp[sum];
    }
}
