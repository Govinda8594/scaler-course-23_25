package com.scaler.Scaler.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

//You are trying to send signals to aliens using a linear array of A laser lights.
// You don't know much about how the aliens are going to percieve the signals,
// but what you know is that if two consecutive lights are on then the aliens might take it as a sign of danger
// and destroy the earth.
//        Find and return the total number of ways in which you can send a signal without compromising
//        the safty of the earth. Return the ans % 109 + 7.
public class WaysToSendSignal {

    /////////////////////////////////////////////////////////////////////////
    // Top down : TC - O(n), SC - O(n2)
    static final int MOD = 1_000_000_007;
    int mod = 1000000007;
    private Map<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) {
        WaysToSendSignal obj = new WaysToSendSignal();
        int A = 5;
        System.out.println("Total valid combinations: " + obj.countWays(A));
    }
    ///////////////////////Recursion///////////////////////////////////////////////////////

    /// SC:O(N)
    public int solve2(int A) {
        int[] dp = new int[A + 1];
        int mod = 1000000007;
        dp[1] = 2;
        dp[2] = 3;
        for (int i = 3; i <= A; i++) {
            dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
        }
        return dp[A] % mod;
    }

    //// with SC:O(1)
    public int solve1(int A) {
        int mod = 1000000007;
        int a = 2;// no.of ways to send when A=1;
        int b = 3;// no.of ways to send signal when A=2;
        int c = 0;
        if (A == 1) {
            return 2;
        }
        if (A == 2) {
            return 3;
        }
        for (int i = 3; i <= A; i++) {
            c = (a % mod + b % mod) % mod;
            a = b;
            b = c;
        }
        return c % mod;
    }

    public int solve4(int A) {
        if (A == 0) {
            return 1; // ways for first light is off or on
        }
        if (A == 1) {
            return 2; // ways for second light is off or on
        }
        if (hm.containsKey(A)) {
            return hm.get(A);
        }
        int ans = (int) (solve4(A - 1) + solve4(A - 2)) % 1000000007;
        hm.put(A, ans);
        return ans;
    }

    public int countWays(int A) {
        // dp[i][used] → number of ways from position i onward
        // used = 1 if previous signal was on, 0 otherwise
        // n = 2, n = 3
        // 1 0          1 0 1
        // 0 1          0 1 0
        // 0 0          0 0 0    1 1 0  -> invalid -> two consecutive signal danger to alien
        // 1 1 -> invalid signal 0 1 1 -> invalid
        Integer[][] dp = new Integer[A + 1][2];
        return solve(0, A, 0, dp);
    }

    private int solve(int index, int total, int prevUsed, Integer[][] dp) {
        // Base case: reached end of sequence
        if (index == total) return 1;

        // Memoization check
        if (dp[index][prevUsed] != null)
            return dp[index][prevUsed];

        int ways = 0;

        // Option 1: Skip current signal
        ways = solve(index + 1, total, 0, dp);

        // Option 2: Pick current element (only if previous wasn't picked)
        if (prevUsed == 0) {
            ways = (ways + solve(index + 1, total, 1, dp)) % MOD;
        }

        // Store result and return
        return dp[index][prevUsed] = ways;
    }
}
