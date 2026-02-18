package com.scaler.Scaler.DynamicProgramming;
//Given an array of integers A representing chain of 2-D matices such that the dimensions of ith matrix is A[i-1] x A[i].
//        Find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.
//        Return the minimum number of multiplications needed to multiply the chain.
//        Problem Constraints
//        1 <= length of the array <= 1000
//        1 <= A[i] <= 100

import java.util.Arrays;

public class MinimumIterationToMultiply_N_Given_Matrix {
    // Function to find the most efficient way to multiply given sequence of matrices
    static int calculateMinimumCost(int[] matrixSizes, int numberOfMatrices) {
        // Create a 2D array to store the minimum cost of matrix multiplications
        int[][] cost = new int[numberOfMatrices][numberOfMatrices];
        int i, j, matrixChainLength, costCandidate, q;
        // Zero multiplication needed for single matrix
        for (i = 1; i < numberOfMatrices; i++) {
            cost[i][i] = 0;
        }
        // Calculate cost for all chains of length 2 to numberOfMatrices
        for (matrixChainLength = 2; matrixChainLength < numberOfMatrices; matrixChainLength++) {
            for (i = 1; i < numberOfMatrices - matrixChainLength + 1; i++) {
                j = i + matrixChainLength - 1;
                if (j == numberOfMatrices) {
                    continue;
                }
                cost[i][j] = Integer.MAX_VALUE;
                for (costCandidate = i; costCandidate <= j - 1; costCandidate++) {
                    // Calculate cost of current chain
                    q = cost[i][costCandidate] + cost[costCandidate + 1][j] + matrixSizes[i - 1] * matrixSizes[costCandidate] * matrixSizes[j];
                    if (q < cost[i][j]) {
                        cost[i][j] = q;
                    }
                }
            }
        }
        return cost[1][numberOfMatrices - 1];
    }

    public static void main(String args[]) {
        // Array of matrices
        int[] matrixSizes = new int[]{1, 2, 3, 4};
        int numberOfMatrices = matrixSizes.length;
        // Display the minimum number of multiplications
        System.out.println("Minimum number of multiplications is " + calculateMinimumCost(matrixSizes, numberOfMatrices));
    }

    ///////////////////////////Approach 1: Memoization (Recursion + DP array)
    //TC: O(n^3)
    //SC: O(n^2) for dp array + recursion stack space (2n = max width of recursion tree)/////////////////////////////////////////////////////////////////////////
    public int solve2(int[] A) {
        int N = A.length;
        int[][] dp = new int[N + 1][N + 1];
        return minCost(dp, 1, N - 1, A);
    }

    public int minCost(int[][] dp, int i, int j, int[] A) {
        //base case i and j equals there is no cost so return 0
        if (i == j) {
            return 0;
        }
        // if we are entering this subproblem for the first time
        if (dp[i][j] == 0) {
            dp[i][j] = Integer.MAX_VALUE;
            // iterate over possible partition points k as intermidiate
            for (int k = i; k < j; k++) {
                // recursively calculate the cost for left and right submatrices
                int l = minCost(dp, i, k, A);
                int r = minCost(dp, k + 1, j, A);
                int cost = A[i - 1] * A[k] * A[j];
                dp[i][j] = Math.min(dp[i][j], l + r + cost);
            }
        }
        // if we already have the minimum cost for this subproblem, return it
        return dp[i][j];
    }
    //////////////////////Approach 2: Tabulation (Iterative approach)
    //Iterations: no of cells in grid/2 => n*n/2 as only half matrix is being used
    //TC: O(n^3)
    //SC: O(n^2) for dp array/////////////////////////////////////////////////////////////////

    public int solve3(int[] A) {
        return tabulation_mcm(A);
    }

    public int tabulation_mcm(int[] A) {
        int n = A.length;
        // initialize dp array with max value as we need to find the min value
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        // start from bottom row to top row
        for (int i = n; i >= 1; i--) {
            // start from left column to right column
            for (int j = i; j < n; j++) {
                // base case
                if (i == j) {
                    dp[i][j] = 0;
                }
                // recursive relation converted to iterative code
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            dp[i][k] + dp[k + 1][j] + (A[i - 1] * A[k] * A[j]));
                }
            }
        }
        // answer will be stored at dp[1][n-1]
        return dp[1][n - 1];
    }
}
