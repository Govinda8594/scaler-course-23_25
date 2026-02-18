package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
//        ' ? ' : Matches any single character.
//        ' * ' : Matches any sequence of characters (including the empty sequence). >= 0
//        The matching should cover the entire input string (not partial).
//    Problem Constraints
//        1 <= length(A), length(B) <= 104
//   Input Format
//        The first argument of input contains a string A.
//        The second argument of input contains a string B.
//    Output Format
//        Return 1 if the patterns match else return 0.
public class RegularExpressionMatch {
    ///////////////////////////Iterative//////////////////////////////////////////////////

    public boolean wildCard1(String txt, String pat) {
        // Your code goes here
        int n = txt.length();
        int m = pat.length();
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            if (pat.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (txt.charAt(i - 1) == pat.charAt(j - 1) || pat.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if (pat.charAt(j - 1) == '*')
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
            }
        }
        return dp[n][m] == 1;
    }

    /////////////////////////////////////////////////top-down/////////////////////////////////////////
    public boolean wildCard(String txt, String pat) {
        // Your code goes here
        int n = txt.length();
        int m = pat.length();
//        hard case optimization for reducing large number of *
        StringBuilder sb = new StringBuilder();
        sb.append(pat.charAt(0));
        for (int i = 1; i < m; ++i) {
            if (pat.charAt(i) == '*' && pat.charAt(i - 1) == '*') {
                continue;
            }
            sb.append(pat.charAt(i));
        }
        m = sb.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return ismatch(0, 0, n, m, txt, sb.toString(), dp) == 1;
    }

    int ismatch(int i, int j, int n, int m, String txt, String pat, int[][] dp) {
        if (i == n && j == m)
            return 1;
        if (i == n) { // if all remaining ones are
            if (checkValid(pat, j)) {
                return 1;
            }
            return 0;
        }
        if (j == m) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        dp[i][j] = 0;
        if (txt.charAt(i) == pat.charAt(j) || pat.charAt(j) == '?')
            dp[i][j] = ismatch(i + 1, j + 1, n, m, txt, pat, dp);
        else if (pat.charAt(j) == '*') {
            int move = ismatch(i, j + 1, n, m, txt, pat, dp);
            int stay = ismatch(i + 1, j, n, m, txt, pat, dp);
            dp[i][j] = move | stay;
        }
        return dp[i][j];
    }

    boolean checkValid(String B, int index) {
        for (int i = index; i < B.length(); i++) {
            if (B.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
