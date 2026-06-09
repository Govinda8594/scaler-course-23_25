package com.scaler.Scaler.DynamicProgramming;

//Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
//        Also given an integer C which represents knapsack capacity.
//        Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
//        NOTE:
//        You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
//          Problem Constraints
//        1 <= N <= 103
//        1 <= C <= 103
//        1 <= A[i], B[i] <= 103
public class KnapsackProblem {

    /// ////////////////////////////top down //////////////////////////
    int[][] dp;

    public int solve(int[] A, int[] B, int C) {
        int N = A.length;
        dp = new int[N][C + 1];
        // Initialize the dp array with -1
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= C; j++) {
                dp[i][j] = -1;
            }
        }
        // Call the knapSack function to solve the problem
        return knapSack(N - 1, C, B, A);
    }

    public int knapSack(int i, int j, int[] wei, int[] val) {
        // Base case If no items left or capacity becomes 0, return 0
        if (i < 0 || j <= 0) {
            return 0;
        }
        if (dp[i][j] == -1) { // if it calculate for first time
            int a = knapSack(i - 1, j, wei, val);
            if (j >= wei[i]) {
                a = Math.max(a, val[i] + knapSack(i - 1, j - wei[i], wei, val));
            }
            dp[i][j] = a;
        }
        return dp[i][j];
    }

    // check which item are picked call call after fill dp table i = n- 1,j = Capacity
    void printTheItem(int i, int j, int[] wei) {
        while (i >= 0 && j > 0) {
            if (i == 0) {
                if (dp[0][j] != 0) {
                    System.out.println(0);
                    break;
                }
                break;
            }

            if (dp[i][j] == dp[i - 1][j]) {
                /// item is skipped
                i--;
            } else {
                // item is picked
                System.out.println(i);
                j = j - wei[i];
                i--;
            }
        }
    }

    /// //////////////////Bottom Up/////////////////////////////////////////////////// N2 space   ///

    public int solve2(int[] A, int[] B, int C) {
        int n = A.length;
        int[][] dp = new int[n + 1][C + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= C; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int val1 = dp[i - 1][j]; // item not picked
                    int val2 = 0;
                    if (B[i - 1] <= j) {
                        val2 = dp[i - 1][j - B[i - 1]] + A[i - 1]; // item picked
                    }
                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }
        return dp[n][C];
    }

    //Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
//        Also given an integer C which represents knapsack capacity.
//        Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
//        NOTE: You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
//        Problem Constraints
//        1 <= N <= 500
//        1 <= C, B[i] <= 106
//        1 <= A[i] <= 50

    /// ///////* Using 1D Array */////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve5(int[] A, int[] B, int C) {
        int N = B.length;
        int[] dp = new int[C + 1];
        for (int i = 1; i < 1 + N; i++) {
            for (int j = C; j >= 0; j--) {
                if (B[i - 1] <= j) {
                    dp[j] = Math.max(dp[j], A[i - 1] + dp[j - B[i - 1]]);
                }
            }
        }
        return dp[C];
    }

    /* Using 2D Array */
    public int solve6(int[] A, int[] B, int C) {
        int N = B.length;
        int[][] dp = new int[N + 1][C + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= C; j++) {
                int rem = j - B[i - 1];
                if (rem >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], A[i - 1] + dp[i - 1][rem]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[N][C];
    }

    /// work for both above statement
    /// ///////////////Tabulation////////////////// N space ////////////////////////////
    public int solve3(int[] A, int[] B, int C) {
        int[] dp = new int[C + 1];
        for (int i = B[0]; i <= C; i++) {
            dp[i] = A[0];
        }
        for (int i = 1; i <= A.length - 1; i++) {
            //tabulation start
            for (int j = C; j >= 0; j--) {
                int notTake = dp[j];
                int take = Integer.MIN_VALUE;
                if (B[i] <= j) {
                    take = A[i] + dp[j - B[i]];
                }
                dp[j] = Math.max(take, notTake);
            }
        }
        return dp[C];
    }

    public int solve4(int[] A, int[] B, int C) {
        int[] dp = new int[C + 1];
        for (int i = 0; i < A.length; i++) {
            for (int j = C; j >= B[i]; j--) {
                dp[j] = Math.max(dp[j], A[i] + dp[j - B[i]]);
            }
        }
        return dp[C];
    }
}
