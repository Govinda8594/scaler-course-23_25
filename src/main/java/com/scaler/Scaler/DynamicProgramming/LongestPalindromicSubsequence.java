package com.scaler.Scaler.DynamicProgramming;

//Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).
//        You need to return the length of longest palindromic subsequence.
public class LongestPalindromicSubsequence {
    int[][] dpArr;

    public int solve1(String A) {
        String B = new StringBuilder(A).reverse().toString();
        return LCS(A, B);
    }

    //////////////////////////////////////////////////////////////////////////////////
    public int longestPalinSubseq(String s) {
        // code here
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        int[][] dp = new int[n][n];
        dp[0][0] = (s.charAt(0) == rev.charAt(0)) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = (s.charAt(i) == rev.charAt(0)) ? 1 : dp[i - 1][0];
            dp[0][i] = (s.charAt(0) == rev.charAt(i)) ? 1 : dp[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s.charAt(i) == rev.charAt(j))
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[n - 1][n - 1];
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    public int LCS(String A, String B) {
        int m = A.length();
        int n = B.length();
        // Create a 2D array to store the lengths of LCS for all subproblems
        int[][] DP = new int[m + 1][n + 1];
        // Fill the DP array in a bottom-up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    // Base case: if either string is empty, LCS length is 0
                    DP[i][j] = 0;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    // If characters at current indices are equal, include them in LCS
                    DP[i][j] = 1 + DP[i - 1][j - 1];
                } else {
                    // If characters are not equal, choose the maximum LCS length from the previous subproblems
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }
        // Return the LCS length for the entire strings A and B
        return DP[m][n];
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve3(String A) {
        int n = A.length();
        dpArr = new int[n][n];
        return recursion(A, 0, n - 1, n);
    }

    public int recursion(String A, int i, int j, int n) {
        if (i == n || j < 0) {
            return 0;
        }
        if (dpArr[i][j] != 0) {
            return dpArr[i][j];
        }
        if (A.charAt(i) == A.charAt(j)) {
            dpArr[i][j] = recursion(A, i + 1, j - 1, n) + 1;
        } else {
            int x = recursion(A, i + 1, j, n);
            int y = recursion(A, i, j - 1, n);
            dpArr[i][j] = Math.max(x, y);
        }
        return dpArr[i][j];

    }
}
