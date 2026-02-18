package com.scaler.Scaler.DynamicProgramming.Catalan;

public class CountBalancedParanthesisOrCatalanSeries {
    //How many n pairs of balanced parenthesis are there
    static long mod = 1000000007;

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

    static int catalanRecursion(int n) {
        if (n <= 1)
            return 1;
        int c = 0;
        for (int j = n - 1; j >= 0; j--) {
            c += catalanRecursion(j) * catalanRecursion(n - j - 1);
        }
        return c;
    }
}
