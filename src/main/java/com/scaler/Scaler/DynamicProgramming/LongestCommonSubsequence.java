package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;
//Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
//        You need to return the length of such longest common subsequence.
//    Problem Constraints
//        1 <= Length of A, B <= 1005
//     Input Format
//        First argument is a string A.
//        Second argument is a string B.

public class LongestCommonSubsequence {
    /// /////////////////////////////Recursion bottom - up Approach

    public int solve2(String A, String B) {
        int n = A.length(), m = B.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return LCS(n - 1, m - 1, A, B, dp);
        ///////////////////////////////Code to know which character are picked
        /*int i = n-1,j = m-1;
        while(i>=0 && j>=0 && dp[i][j] != 0){
            if(A.charAt(i) == B.charAt(j)){
                System.out.print(A.charAt(i)+" ");
                i--;
                j--;
            }else{
                if(i-1 > 0 && j-1>0 && dp[i-1][j] > dp[i][j-1]){
                    i--;
                }else j--;
            }
        }*/
    }

    private int LCS(int i, int j, String A, String B, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Math.max(LCS(i - 1, j, A, B, dp), LCS(i, j - 1, A, B, dp));
        if (A.charAt(i) == B.charAt(j)) {
            ans = 1 + LCS(i - 1, j - 1, A, B, dp);
        }
        return dp[i][j] = ans;
    }

    //    Tabulation (TC - O(mn), SC - O(mn))
    public int solve4(String A, String B) {
        int[][] dp = new int[A.length() + 1][B.length() + 1];
        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[A.length()][B.length()];
    }

}
