package com.scaler.Scaler.DynamicProgramming.Catalan;
//Given a number A, return number of ways you can draw A chords in a circle with 2 x A points such that no 2 chords intersect.
//        Two ways are different if there exists a chord which is present in one way and not in other.
//        Return the answer modulo 109 + 7.
//    Problem Constraints
//        1 <= A <= 103

import java.util.Arrays;

public class IntersectingChordsinaCircleOrCatalan {

    ///////////////////////////////Tabulation+bottomup //////////////////////////
    static long mod = 1000000007;
    int[] DpArr;

    static int catalanDP(int n) {
        // Table to store results of subproblems
        long[] catalan = new long[n + 2];
        // Initialize first two values in table
        catalan[0] = 1;
        catalan[1] = 1;
        // Fill entries in catalan[] using recursive formula
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
                catalan[i] %= mod;
            }
        }
        // Return last entry
        return (int) catalan[n];
    }

    /////////////////////////////top-down || memoization/////////////////////////////////
    public int chordCnt2(int A) {
        DpArr = new int[A + 1];
        Arrays.fill(DpArr, -1);
        DpArr[0] = 1;
        DpArr[1] = 1;
        return countChrods(A);
    }

    public int countChrods(int i) {
        if (i <= 1) {
            return 1;
        }
        if (DpArr[i] != -1) {
            return DpArr[i];
        }
        if (DpArr[i] == -1) {
            long ans = 0;
            for (int j = i - 1; j >= 0; j--) {
                ans += (long) countChrods(j) % mod * (long) countChrods(i - j - 1) % mod;
                ans %= mod;
            }
            DpArr[i] = (int) (ans % mod);
        }
        return DpArr[i];
    }
}
