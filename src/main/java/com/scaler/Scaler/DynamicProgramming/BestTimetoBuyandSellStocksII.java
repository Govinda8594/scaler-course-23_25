package com.scaler.Scaler.DynamicProgramming;
//Say you have an array, A, for which the ith element is the price of a given stock on day i.
//        Design an algorithm to find the maximum profit.
//        You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
//        However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
// Problem Constraints
//        0 <= len(A) <= 1e5
//        1 <= A[i] <= 1e7

import java.util.Arrays;

public class BestTimetoBuyandSellStocksII {

    int[][] dp;

    public int maxProfit2(final int[] A) {
        int N = A.length;
        //base case if Array is empty return 0
        if (N == 0) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 1; i < A.length; i++) {
            int currentProfit = A[i] - A[i - 1];
            if (currentProfit > 0) {
                maxProfit += currentProfit;
            }
        }
        return maxProfit;
    }

    ////////////////////////////////////////////////////////////////////////////
    public int checkProfit(int[] A, int n, int index, int buy) {
        if (index == n) {
            return 0;
        }
        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }
        int profit = 0;
        // buy or don't buy
        if (buy == 1) {
            profit = Math.max(checkProfit(A, n, index + 1, 0) - A[index], checkProfit(A, n, index + 1, 1));
        } else {
            profit = Math.max(checkProfit(A, n, index + 1, 1) + A[index], checkProfit(A, n, index + 1, 0));
        }
        dp[index][buy] = profit;
        return profit;
    }

    public int maxProfit3(final int[] A) {
        int n = A.length;
        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return checkProfit(A, n, 0, 1);
    }

    /////////////////////////////////////////////////////////////////////////////
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxProfit5(final int[] A) {
        int n = A.length;
        int[][] dp = new int[n + 1][2];
//Base Case: after n u can't do anything right
        dp[n][0] = dp[n][1] = 0;
        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    dp[idx][buy] = Math.max(dp[idx + 1][0], A[idx] + dp[idx + 1][1]);
                } else {
                    dp[idx][buy] = Math.max(dp[idx + 1][0] - A[idx], dp[idx + 1][1]);
                }
            }
        }
        return dp[0][1];
    }
}
