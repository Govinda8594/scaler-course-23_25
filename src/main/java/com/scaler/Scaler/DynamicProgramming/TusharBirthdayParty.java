package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

//As it is Tushar's Birthday on March 1st, he decided to throw a party to all his friends at TGI Fridays in Pune.
// Given are the eating capacity of each friend, filling capacity of each dish and cost of each dish.
// A friend is satisfied if the sum of the filling capacity of dishes he ate is equal to his capacity.
// Find the minimum cost such that all of Tushar's friends are satisfied (reached their eating capacity).
//        NOTE:
//        Each dish is supposed to be eaten by only one person. Sharing is not allowed.
//        Each friend can take any dish unlimited number of times.
//        There always exists a dish with filling capacity 1 so that a solution always exists.
//
//        Problem Constraints
//        |A| <= 1000 capcity of friend
//        |B| <= 1000 // filling capacity of dish
//        |C| <= 1000 // cost of each dish

public class TusharBirthdayParty {
    // top - down
    public int solve(final int[] A, final int[] B, final int[] C) {
        int max = Integer.MIN_VALUE, min = 0, n = B.length;
        for (int j : A) {
            max = Math.max(j, max);
        }
        int[][] dp = new int[n][max + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        for (int manCap : A) {
            min += getMinCost(n - 1, manCap, B, C, dp);
        }
        return min;
    }

    public int getMinCost(int i, int manCap, int[] foodCap, int[] cost, int[][] dp) {
        if (manCap == 0) {
            return 0;
        }
        if (i < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][manCap] != -1) {
            return dp[i][manCap];
        }
        int notTake = getMinCost(i - 1, manCap, foodCap, cost, dp);
        long ans = 0L;
        if (manCap >= foodCap[i]) {
            ans = Math.min(notTake, (long) getMinCost(i, manCap - foodCap[i], foodCap, cost, dp) + cost[i]);
        } else {
            ans = notTake;
        }
        dp[i][manCap] = (int) ans;
        return dp[i][manCap];
    }

    ///////////////////////Iterative Approch + bottom-up//////////////////////////////////////////////////////////////////
    public int solve5(final int[] A, final int[] B, final int[] C) {
        // Get the maximum capacity
        int maxCapacity = Integer.MIN_VALUE;
        for (int k : A) {
            maxCapacity = Math.max(maxCapacity, k);
        }
        int[] dp = new int[maxCapacity + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // We are going to find for all the capacities from 1 to MaxCapacity
        for (int i = 1; i <= maxCapacity; i++) {
            // For each capacity, iterate through each filling capacity
            for (int j = 0; j < B.length; j++) {
                // If the eating capacity is more than filling capacity
                // Pull the cost and update DP Array
                if (i >= B[j]) {
                    dp[i] = Math.min(dp[i], dp[i - B[j]] + C[j]);
                }
            }
        }
        // Traverse through DP Array for eating capacity getting minimum cost
        int ans = 0;
        for (int j : A) {
            ans += dp[j];
        }
        return ans;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve3(final int[] A, final int[] B, final int[] C) {
        int totalCost = 0;
        // Find the max of Array A
        int maxA = A[0];
        for (int i = 1; i < A.length; i++) {
            maxA = Math.max(maxA, A[i]);
        }
        // Adding all the cost value to hashmap for easy retrieval mapping dish with min cost
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            // Multiple dishes wish same filling capacities and different cost there in
            // test cases so we need to put below check
            if (hm.containsKey(B[i])) {
                hm.put(B[i], Math.min(hm.get(B[i]), C[i]));
            } else {
                hm.put(B[i], C[i]);
            }
        }
        // Create dp array of size maxA+1, so that it will store the min cost for all the eating capacities
        int[] dp = new int[maxA + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // When eating capacity is 0 then cost will be 0
        dp[0] = 0;
        for (int i = 1; i <= maxA; i++) {
            int minVal = Integer.MAX_VALUE;
            if (hm.containsKey(i)) {
                dp[i] = hm.get(i);
            }
            for (int j = 0; j <= i; j++) {
                minVal = Math.min(minVal, dp[j] + dp[i - j]);
            }
            dp[i] = minVal;
        }
        // Find minimum cost for each filling capacities and add it to total cost
        for (int j : A) {
            totalCost += dp[j];
        }
        return totalCost;
    }
}
