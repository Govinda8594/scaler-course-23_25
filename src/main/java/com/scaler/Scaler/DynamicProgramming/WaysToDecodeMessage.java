package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//        'A' -> 1
//        'B' -> 2
//        ...
//        'Z' -> 26
//        Given an encoded message denoted by string A containing digits, determine the total number of ways to decode it modulo 109 + 7.
public class WaysToDecodeMessage {
    ////////////////////////////bottom-up//////////////////////////////////////////
    private int[] dp;
    private String A;

    public int numDecodings2(String A) {
        int N = A.length();
        if (N == 0) {
            return 0;
        }
        if (A.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[N + 1];
        int m = 1000000007;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            int x = Character.getNumericValue(A.charAt(i - 1));
            int y = Character.getNumericValue(A.charAt(i - 2));
            if (x >= 1 && x <= 9) {
                dp[i] = dp[i - 1] % m;
            }
            if (y == 1 || (y == 2 && x <= 6)) {
                dp[i] += dp[i - 2] % m;
            }
        }
        return dp[N] % m;
    }

    ///////////////////////////top-down//recusrion//////////////////////////////////////////
    public int numDecodings3(String A) {
        int n = A.length();
        if (A.isBlank()) {
            return 0;
        }
        dp = new int[n];
        Arrays.fill(dp, -1);
        this.A = A;
        return rec(n - 1);
    }

    private int rec(int index) {
        if (index < 0) {
            return 1;
        }
        if (dp[index] != -1) {
            return dp[index] % 1000000007;
        }
        int ways = 0;
        if (A.charAt(index) > '0') {
            ways = rec(index - 1);
            ways %= 1000000007;
        }
        if (isValidTwoDigits(index)) {
            ways += rec(index - 2);
            ways %= 1000000007;
        }
        return dp[index] = ways;
    }

    private boolean isValidTwoDigits(int index) {
        return index > 0 && (A.charAt(index - 1) == '1' || A.charAt(index - 1) == '2' && A.charAt(index) < '7');
    }
}
