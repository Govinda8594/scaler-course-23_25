package com.scaler.Scaler.DynamicProgramming.FindSumPattern;

public class CheckIfArrayCanBeDivideInto2SubsetWithEqualSum_k {

    public static void main2(String[] args) {
        int[] A = {1, 3, 5, 7, 9};
        int N = A.length;
        int sum = 0;
        for (int k : A) {
            sum += k;
        }

        if (subsetSum(A, sum, N)) {
            System.out.println("There exists a subset with sum " + (sum / 2) + " where all elements are positive and every element can be picked at most once.");
        } else {
            System.out.println("There does not exist a subset with sum " + (sum / 2) + " where all elements are positive and every element can be picked at most once.");
        }
        int sumK = sum / 2;
        boolean[][] dp = new boolean[N][sumK + 1];
        System.out.println(isSubsetSum(A, N - 1, sumK, dp));
    }

    /// ///////////////////////Need to trace/////////////////////////////////////////////////
//    To check if there exists a subset with sum `K` equal to the sum of `A[N]/2` where all elements are positive and every element can be picked at most once, we can use the **dynamic programming** approach. Here's how it works:
//
//            1. Calculate the sum of all elements in the array `A`.
//            2. If the sum is odd, return `false` since it is not possible to divide the array into two subsets with equal sum.
//3. Create a boolean 2D array `dp[N+1][sum/2+1]` where `dp[i][j]` is `true` if there exists a subset of elements from `A[0]...A[i-1]` with sum `j`.
//            4. Initialize the first row of the array `dp[0][j]` to `false` since we cannot form a subset from an empty set.
//            5. Initialize the first column of the array `dp[i][0]` to `true` since we can always form a subset with sum `0` by not selecting any element.
//6. For each element `A[i-1]`, iterate over all possible sums from `1` to `sum/2` and update the array `dp` as follows:
//            * If `A[i-1] > j`, then `dp[i][j] = dp[i-1][j]` since we cannot include the current element in the subset.
//            * If `A[i-1] <= j`, then `dp[i][j] = dp[i-1][j] || dp[i-1][j-A[i-1]]` since we can either include or exclude the current element in the subset.
//7. The answer is stored in `dp[N][sum/2]`.
    public static boolean subsetSum(int[] A, int sum, int N) {

        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] dp = new boolean[N + 1][sum / 2 + 1];
//        for (int j = 0; j <= sum / 2; j++) {
//            dp[0][j] = false;
//        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true; // can pick ith element with sum = 0 so mark all true
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (A[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                }
            }
        }
        return dp[N][sum / 2];
    }

    //top down
    static boolean isSubsetSum(int[] set, int index, int sum, boolean[][] memo) {
        if (index < 0) return sum == 0;

        if (memo[index][sum]) {
            return memo[index][sum];
        }

        // Option 1: Don't pick the current element
        boolean exclude = isSubsetSum(set, index - 1, sum, memo);

        // Option 2: Pick the current element (only once)
        boolean include = false;
        if (sum >= set[index]) {
            include = isSubsetSum(set, index - 1, sum - set[index], memo);
        }

        boolean result = exclude || include;
        memo[index][sum] = result;
        return result;
    }
}
