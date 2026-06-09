package com.scaler.Scaler.DynamicProgramming.FindSumPattern;

import java.util.Arrays;

public class DivideArrayIn2SubsetWhereSumisMinimized {

    static int[][] dp = null;

    static void main(String[] args) {
        int[] A = {1, 6, 11, 5};
        divideArray(A);
    }

    //    To divide an array `A` of size `N` into two subsets such that the difference between both is minimum, we can use the **dynamic programming** approach. Here's how it works:
//
//            1. Calculate the sum of all elements in the array `A`.
//            2. Create a boolean 2D array `dp[N+1][sum/2+1]` where `dp[i][j]` is `true` if there exists a subset of elements from `A[0]...A[i-1]` with sum `j`.
//            3. Initialize the first row of the array `dp[0][j]` to `false` since we cannot form a subset from an empty set.
//            4. Initialize the first column of the array `dp[i][0]` to `true` since we can always form a subset with sum `0` by not selecting any element.
//5. For each element `A[i-1]`, iterate over all possible sums from `1` to `sum/2` and update the array `dp` as follows:
//            * If `A[i-1] > j`, then `dp[i][j] = dp[i-1][j]` since we cannot include the current element in the subset.
//            * If `A[i-1] <= j`, then `dp[i][j] = dp[i-1][j] || dp[i-1][j-A[i-1]]` since we can either include or exclude the current element in the subset.
//6. The answer is stored in `dp[N][sum/2]`.
//            7. To find the two subsets with minimum difference, we can start from `dp[N][sum/2]` and traverse the array backwards to find the elements that were included in the subset. The elements that were not included in the subset form the other subset.
    public static void divideArray(int[] A) {
        int N = A.length;
        int sum = 0;
        for (int k : A) {
            sum += k;
        }
        boolean[][] dp = new boolean[N + 1][sum / 2 + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = true; // Sum 0 is always possible (empty subset)

        }
//        - or each element and target sum:
//        - Exclude the element → dp[i - 1][j]
//        - Include the element → dp[i - 1][j - A[i - 1]]
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (A[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - A[i - 1]];
                }
            }
        }

        // Find Closest Possible Subset Sum to sum/2
//        - Finds the largest j ≤ sum/2 such that a subset sum of j is possible.
        int target = sum / 2;
        while (target >= 0 && !dp[N][target]) {
            target--;
        }

        int sum1 = target;
        int sum2 = sum - sum1;

        System.out.println("The two subsets with minimum difference are:" + sum2);
        //First Subset (Backtracking from DP table)
//  - Backtracks to find which elements were included in the subset that formed sum1.

        // Track picked elements for subset1
        System.out.print("{ ");
        boolean[] picked = new boolean[N]; // marked all not picked
        int i = N, j = sum1;
        while (i > 0 && j > 0) {
            if (dp[i - 1][j]) { // element not picked simpily move
                i--;
            } else { // element picked ,decrease sum or j and move
                picked[i - 1] = true;
                j -= A[i - 1];
                i--;
            }
        }


        for (int k = 0; k < N; k++) {
            if (picked[k]) {
                System.out.print(A[k] + " ");
            }
        }
        System.out.println("}");

        // Remaining elements go to subset2
        // Second Subset (Remaining elements):
//        - Prints the remaining elements not used in the first subset.
        System.out.print("{ ");
        for (int k = 0; k < N; k++) {
            if (!picked[k]) {
                System.out.print(A[k] + " ");
            }
        }
        System.out.println("}");
    }

    /// ///////////////////////////////////////////////////////////////////////////////////////////

    public static void main2(String[] args) {
        int[] A = {1, 3, 5, 7, 9};
        int N = A.length;
        int sum = 0;
        for (int j : A) {
            sum += j;
        }
        int k = sum / 2;
        dp = new int[N][sum + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        isSubsetSum2(A, N, k);
        int sum1 = k, sum2 = sum - sum1;
        while (dp[N - 1][sum1] == 0) {
            sum1--;
            sum2++;
        }
        System.out.println("Minimum Difference between subset sum is" + (sum1 - sum2));
    }

    static int isSubsetSum2(int[] set, int i, int sum) {
        if (i < 0) {
            if (sum == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        if (dp[i][sum] == -1) {
            int a = isSubsetSum2(set, i - 1, sum);
            int b = 0;
            if (sum >= set[i]) {
                b = isSubsetSum2(set, i - 1, sum - set[i]);
            }
            dp[i][sum] = a | b;
        }
        return dp[i][sum];
    }
}
