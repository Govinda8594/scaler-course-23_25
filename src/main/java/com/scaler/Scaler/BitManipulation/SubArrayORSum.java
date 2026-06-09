package com.scaler.Scaler.BitManipulation;
//You are given an array of integers A of size N.
//        The value of a subarray is defined as BITWISE OR of all elements in it.
//        Return the sum of value of all subarrays of A % 109 + 7.


public class SubArrayORSum {
    public int solve(int[] A) {
        long n = A.length;
        long tot_subArray = (n * (n + 1)) / 2;
        long ans = 0;
        for (int i = 0; i < 32; i++) {
            long subArray = 0;
            long bitzero = 0;
            for (int j = 0; j < n; j++) {
                if ((A[j] & (1 << i)) == 0) {
                    bitzero++;
                }
                if ((A[j] & (1 << i)) > 0 || j == n - 1) {
                    subArray += (bitzero * (bitzero + 1)) / 2;
                    bitzero = 0;
                }
            }
            ans += (tot_subArray - subArray) * (long) Math.pow(2, i);
            ans = ans % 1000000007;
        }
        return (int) ans;
    }
}
