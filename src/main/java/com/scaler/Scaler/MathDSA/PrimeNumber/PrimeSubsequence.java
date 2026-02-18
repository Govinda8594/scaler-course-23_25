package com.scaler.Scaler.MathDSA.PrimeNumber;

import java.util.Arrays;

//Given an array A having N positive numbers. You have to find the number of Prime subsequences of A.
//        A Prime subsequence is one that has only prime numbers, for example [2, 3], [5] are the Prime subsequences where [2, 4] and [1, 2, 3, 4] are not.
public class PrimeSubsequence {

    public int solve(int[] A) {
        int N = A.length;
        long c = 0;
        int mod = 1000000007;
        int M = 1000005;
        int res = 0;
        boolean p[] = new boolean[M];
        Arrays.fill(p, true);
        p[1] = false;
        // sieve method
        for (int i = 2; i * i < M; i++) {
            if (p[i] == true) {
                for (int j = i * i; j < M; j += i) {
                    p[j] = false;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            if (p[A[i]] == true) {
                c++;
            }
        }
        res = (int) ((int) (Math.pow(2, c) % mod));
        return res - 1;
    }
}
