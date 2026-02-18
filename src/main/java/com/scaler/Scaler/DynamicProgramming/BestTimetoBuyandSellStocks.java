package com.scaler.Scaler.DynamicProgramming;

//Say you have an array, A, for which the ith element is the price of a given stock on day i.
//        If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//        Return the maximum possible profit.
//
//        Problem Constraints
//        0 <= A.size() <= 700000
//        1 <= A[i] <= 107
public class BestTimetoBuyandSellStocks {
    public int maxProfit(final int[] A) {
        if (A.length == 0 || A.length == 1) {
            return 0;
        }
        int minPrice = 0;
        int profit = 0;
        for (int j : A) {
            minPrice = Math.min(minPrice, j);
            // max stores the maximum value to the right of A[i]
            profit = Math.max(profit, j - minPrice);
        }
        return profit;
    }
}
