package com.scaler.Scaler.DynamicProgramming;

//Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
//        You have the following 3 operations permitted on a word:
//        Insert a character
//        Delete a character
//        Replace a character
//
//        Problem Constraints
//        1 <= length(A), length(B) <= 450
///        Input Format
//        The first argument of input contains a string, A.
//        The second argument of input contains a string, B.
//    Output Format
//        Return an integer, representing the minimum number of steps required.

public class EditDistance {

    int[][] DP;

    //////////////////////////////Recursion LCS approch///////////////////////

    public int minDistance(String A, String B) {
        int N = A.length(); // size of string A
        int M = B.length(); // size of string B
        DP = new int[N][M];
        return edit(A, B, N - 1, M - 1);
    }

    public int edit(String A, String B, int i, int j) {
        // Base case if i reaches the start of string A, return j + 1
        if (i < 0) {
            return j + 1;
        }
        // Base case if j reaches the start of string B, return i + 1
        if (j < 0) {
            return i + 1;
        }
        if (DP[i][j] != 0) { // if it is already in DP then return it
            return DP[i][j];
        }
        // If the characters at indices i and j are equal, move to the previous indices and continue
        if (A.charAt(i) == B.charAt(j)) {
            DP[i][j] = edit(A, B, i - 1, j - 1);
        } else {
            // If the characters are not equal, we have three options: delete, insert, or replace
            int delete = edit(A, B, i - 1, j);       // Delete the character at index i in string A
            int insert = edit(A, B, i, j - 1);       // Insert the character at index j in string B into A
            int replace = edit(A, B, i - 1, j - 1);  // Replace the character at index i in A with the character at index j in B
            // Find the minimum among the three options and store it in DP[i][j]
            DP[i][j] = Math.min(Math.min(delete, insert), replace) + 1;
        }
        return DP[i][j];
    }
    ////////////////////////////Tabulation////////////////////////////////////////////////

    public int minDistance1(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // character matches from both string , take diagonally opposite
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //Take Min of , diagonally opposite or left or right + 1
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public int minDistance3(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        return minOperation(word1, word2, 0, 0, n, m, Integer.MAX_VALUE);
    }

    int minOperation(String a, String b, int i, int j, int n, int m, int minVal) {
        if (i >= n)
            return m - j;
        if (j >= m)
            return n - i;

        if (a.charAt(i) == b.charAt(j))
            minVal = minOperation(a, b, i + 1, j + 1, n, m, minVal);
        else {
            int insert = minOperation(a, b, i + 1, j, n, m, minVal);
            int delete = minOperation(a, b, i, j + 1, n, m, minVal);
            int replace = minOperation(a, b, i + 1, j + 1, n, m, minVal);
            minVal = Math.min(minVal, Math.min(insert, Math.min(delete, replace))) + 1;
        }
        return minVal;
    }
}
