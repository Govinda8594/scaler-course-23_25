package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;
//Given two sequences A and B, count number of unique ways in sequence A, to form a subsequence that is identical to the sequence B.
//        Subsequence : A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
//        Problem Constraints
//        1 <= length(A), length(B) <= 700
//        Input Format
//        The first argument of input contains a string A.
//        The second argument of input contains a string B.

public class DistinctSubsequence {
    ///////////////////////top-down///////////////////////////////////////////////
    Integer[][] dp1;

    public int numDistinct2(String A, String B) {
        int n = A.length(), m = B.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return ways(0, 0, A, B, dp);
    }

    private int ways(int i, int j, String A, String B, int[][] dp) {
        if (j == B.length()) {
            return 1;
        }
        if (i == A.length()) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = ways(i + 1, j, A, B, dp);
        if (A.charAt(i) == B.charAt(j)) {
            ans += ways(i + 1, j + 1, A, B, dp);
        }
        return dp[i][j] = ans;
    }

    ///////////////////////Java Bottom Up Approach + iterative///////////////////////////////////////////////
    public int numDistinct4(String A, String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1]; // no match move next
                if (A.charAt(j - 1) == B.charAt(i - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    //////////////////////bottom-up + reccrsion////////////////////////////////////////////////////////////////
    public int numDistinct3(String A, String B) {
        int n = A.length();
        int m = B.length();
        dp1 = new Integer[n + 1][m + 1];
        return findMaxWays(n - 1, m - 1, A, B);
    }

    public int findMaxWays(int i, int j, String A, String B) {
        //whole B string matched with A
        if (j < 0) {
            return 1;
        }
        //String B did not matched with A
        if (i < 0) {
            return 0;
        }
        if (dp1[i][j] != null) {
            return dp1[i][j];
        }

        dp1[i][j] = findMaxWays(i - 1, j, A, B); // do not consider only one option
        if (A.charAt(i) == B.charAt(j)) {
            //if characters matched I can either consider that element or do not consider
            dp1[i][j] += findMaxWays(i - 1, j - 1, A, B);
        }
        return dp1[i][j];
    }
}
