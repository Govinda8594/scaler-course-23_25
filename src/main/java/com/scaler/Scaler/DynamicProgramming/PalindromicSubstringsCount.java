package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//Given a string A consisting of
// lowercase English alphabets. Your task is to find how many substrings of A are palindrome.
//        The substrings with different start indexes or end indexes are counted as different substrings even if they consist of same characters.
//        Return the count of palindromic substrings.
//        Note: A string is palindrome if it reads the same from backward and forward.
public class PalindromicSubstringsCount {
    public int solve(String A) {
        int n = A.length(), ans = 0;
        for (int i = 0; i < n; ++i) {
            // odd length palindrome check
            for (int k = i, j = i; k < n && j >= 0; ++k, --j) {
                if (A.charAt(k) == A.charAt(j)) {
                    ++ans;
                } else {
                    break;
                }
            }
            // even length palindrome check
            for (int k = i, j = i - 1; k < n && j >= 0; ++k, --j) {
                if (A.charAt(k) == A.charAt(j)) {
                    ++ans;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    /// ///////////////////////////////////////////////
    /*
    Gap Loop: The outer loop iterates over the possible lengths of the substring (referred to as gap).
Inner Loops: The inner loops iterate over all substrings of length gap + 1:
If the gap is 0, it means a single character, which is always a palindrome, so dp[i][j] is set to true.
If the gap is 1, it checks if both characters are the same. If they are, it sets dp[i][j] to true.
For larger gaps, it checks if the characters at positions i and j are the same, and if the inner substring A[i+1...j-1] is also a palindrome. If both conditions are met, dp[i][j] is set to true.
Count Palindromes: If a substring A[i...j] is identified as a palindrome (dp[i][j] is true), the counter count is incremented.
     */
    public int solve2(String A) {
        int count = 0;
        int N = A.length();
        boolean[][] dp = new boolean[N][N];
        for (boolean[] bool : dp) Arrays.fill(bool, false);

        for (int gap = 0; gap < N; gap++) {
            for (int i = 0, j = gap; j < N; i++, j++) {
                if (gap == 0) { // single character
                    dp[i][j] = true;
                } else {
                    boolean isSame = A.charAt(i) == A.charAt(j);
                    if (gap == 1) {  // if ab type string
                        dp[i][j] = isSame;
                    } else { // other cases for substring i .. j => A[i+1...j-1]
                        dp[i][j] = isSame && (dp[i + 1][j - 1]);
                    }
                }

                if (dp[i][j]) count++;
            }
        }

        return count;
    }

    /// //////////////////////////////////////////////////////////////////////////
    public int solve4(String A) {
        int n = A.length();
        boolean[][] dp = new boolean[n][n];
        for (boolean[] i : dp) {
            Arrays.fill(i, false);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindromic(i, j, A, dp)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean isPalindromic(int i, int j, String A, boolean[][] dp) {
        if (i >= j) {
            return true;
        }
        if (dp[i][j]) {
            return dp[i][j];
        }
        dp[i][j] = (A.charAt(i) == A.charAt(j)) && isPalindromic(i + 1, j - 1, A, dp);
        return dp[i][j];
    }
}
