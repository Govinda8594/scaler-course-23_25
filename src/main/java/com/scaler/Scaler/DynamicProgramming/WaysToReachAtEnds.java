package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//No ofways to go from TL 10,0 to BR n i m s cells using only 2 direction upward and downward
public class WaysToReachAtEnds {

    static int[][] dp = null;
    int mod = 1000000007;

    public static void main(String[] args) {
        int n = 5, m = 6;
        dp = new int[n][m];
        Arrays.fill(dp, -1);
        waysToreach(n - 1, m - 1);
        System.out.println(dp[n - 1][m - 1]);
    }

    static int waysToreach(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] == -1) {
            dp[i][j] = waysToreach(i - 1, j) + waysToreach(i, j - 1);
        }
        return dp[i][j];
    }
    ////////////////////////////////////////////////////////////////////

    long numberOfPaths(int m, int n) {
        // code here
        long[][] dp = new long[m][n];
        for (long[] arr : dp)
            Arrays.fill(arr, 1);
        // dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
            }
        }
        return dp[m - 1][n - 1];
    }
}
