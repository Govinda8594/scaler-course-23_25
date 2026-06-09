package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//Given a string A,
// partition A such that every substring of the partition is a palindrome.
//        Return the minimum cuts needed for a palindrome partitioning of A.
//A = "aba"
public class PalindromePartitioning2 {

    public int minCut2(String input) {
        int n = input.length();
        boolean[][] isPalindrome = isPalindrome(input, n);
        return minCutsIterative(input, isPalindrome, n);
    }

    public boolean[][] isPalindrome(String input, int n) {
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], true);
        }
        // str of length 1 is always true
        // check for str of len 2 and 2+ size
        for (int length = 2; length <= n; ++length) {
            for (int start = 0; start <= n - length; ++start) {
                int end = start + length - 1;  // then end idx
                // ababa
                // dp[start + 1][end - 1] for inner string validation
                dp[start][end] = dp[start + 1][end - 1] && input.charAt(start) == input.charAt(end);
            }
        }
        return dp;
    }

    public int minCutsIterative(String input, boolean[][] isPalindrome, int n) {
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; ++i) {
            int ans = Integer.MAX_VALUE;
            for (int j = i; j >= 0; --j) {
                if (isPalindrome[j][i]) {
                    ans = Math.min(ans, j - 1 < 0 ? 0 : dp[j - 1] + 1);
                }
            }
            dp[i] = ans;
        }
        return dp[n - 1];
    }

    /// //////////////////////////////////////////////////////////////////
    public int minCut1(String A) {
        int N = A.length();
        int[] dp = new int[N];
        return partition_count(0, N, A, dp) - 1; // Subtract 1 to exclude the final cut after the last palindrome
    }

    public int partition_count(int i, int N, String A, int[] dp) {
        if (i == N) { // Base case: reached the end of the string
            return 0; // No cuts needed
        }
        if (dp[i] == 0) { // If the minimum cuts for the current substring is calculating for first time
            int min_cuts = Integer.MAX_VALUE;
            for (int j = i; j < N; j++) {
                if (isPalindrome(i, j, A)) {
                    int cuts = 1 + partition_count(j + 1, N, A, dp); // Calculate cuts for the remaining substring
                    min_cuts = Math.min(min_cuts, cuts); // Update the minimum cuts
                }
            }
            dp[i] = min_cuts; // Store the minimum cuts for the current substring in the dp array
        }
        return dp[i]; // Return the minimum cuts for the current substring
    }

    // Check function for palindrome for a given string
    public boolean isPalindrome(int i, int j, String str) {
        while (i <= j) { // Check if the substring is a palindrome
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
