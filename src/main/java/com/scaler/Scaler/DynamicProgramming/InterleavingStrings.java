package com.scaler.Scaler.DynamicProgramming;
//Given A, B, C find whether C is formed by the interleaving of A and B.
//        Problem Constraints
//        1 <= length(A), length(B) <= 100
//        1 <= length(C) <= 200
//        Input Format
//        The first argument of input contains a string, A.
//        The second argument of input contains a string, B.
//        The third argument of input contains a string, C.

public class InterleavingStrings {

    Boolean[][] dp = null;

    public boolean isInterLeave(String s1, String s2, String s3) {
        // Your code here

        int n = s1.length(), m = s2.length(), k = s3.length();
        if (k != n + m)
            return false;
        boolean[][] dp = new boolean[n + 1][m + 1];
        return isMatch(0, 0, 0, n, m, k, s1, s2, s3, dp);
    }

    boolean isMatch(int i, int j, int k, int n, int m, int l, String a, String b, String c, boolean[][] dp) {
        if (i == n && j == m && k == l) {
            return true;
        }
        if (k == l) {
            return false;
        }
        if (dp[i][j]) {
            return dp[i][j];
        }
        boolean matchA = (i < n && a.charAt(i) == c.charAt(k)) && isMatch(i + 1, j, k + 1, n, m, l, a, b, c, dp);
        boolean matchB = (j < m && b.charAt(j) == c.charAt(k)) && isMatch(i, j + 1, k + 1, n, m, l, a, b, c, dp);
        dp[i][j] = matchA || matchB;
        return dp[i][j];
    }

    /////////////////////////Easy - Tabulation || bottom-up///////////////////////////////////////////////////

    public int isInterleave4(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), k = s3.length();
        if (k != n + m)
            return 0;
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        // Fill the DP array for the base cases
        for (int j = 1; j <= m; j++) {
            dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        // Fill the DP array using the optimized approach
        for (int i = 1; i <= n; i++) {
            dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);
            for (int j = 1; j <= m; j++) {
                dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[m] ? 1 : 0;
    }
}
