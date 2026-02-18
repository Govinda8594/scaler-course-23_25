package com.scaler.Scaler.DynamicProgramming.Catalan;

import java.util.Arrays;
//Given an integer A, how many structurally unique BST's (binary search trees) exist that can store values 1...A?
//        Problem Constraints
//        1 <= A <=18

public class UniqueBinarySearchTreesIIByCatalanSeries {
    ///Idea: This resembles the Catalan series 1,2,5,14,42,132.....
///Ath catalyn number = f(0)*f(A-1) + f(1)*f(A-2) + ..... + f(A-2)*f(1) + f(A-1)*f(0)
///TC: O(N*N)
///SC: O(N)
    int[] dp;
    //////////////////////top-down+memoization//////////////////////////////////////////////

    public int numTrees5(int A) {
        //Approach: 1D iterative DP.
        //DP state : N  i.e., no of i.
        //int[N+1] dp
        //ways(N) = sum( ways(j-1)*ways(N-j)) for all j=[1,N]
        //base case:
        //ways(0)=1
        //TC: O((N+1)*N)
        //SC: O(N+1)
        return iterativeDp(A);
    }

    public int iterativeDp(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[N];
    }

    ////////top-down//////
    public int numTrees6(int A) {
        dp = new int[A + 1];
        Arrays.fill(dp, -1);
        dp[0] = dp[1] = 1;
        return count(A);
    }

    public int count(int i) {
        if (i == 0) {
            return 1;
        }
        if (dp[i] == -1) {
            int ans = 0;
            for (int j = i - 1; j >= 0; j--) {
                ans += (count(j) * count(i - j - 1));
            }
            dp[i] = ans;
        }
        return dp[i];
    }
}
