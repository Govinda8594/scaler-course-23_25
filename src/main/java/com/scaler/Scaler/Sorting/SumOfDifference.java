package com.scaler.Scaler.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//Given an integer array, A of size N.
//        You have to find all possible non-empty subsequences of the array of numbers and then,
//        for each subsequence, find the difference between the largest and smallest number in that subsequence.
//        Then add up all the differences to get the number.
//        As the number may be large, output the number modulo 1e9 + 7 (1000000007).
//        NOTE: Subsequence can be non-contiguous.
public class SumOfDifference {
    public int solve(int[] A) {
        int mod = 1000 * 1000 * 1000 + 7;
        int n = A.length;
        Arrays.sort(A);
        long max = 0L;
        long min = 0L;
        long pow = 1L;

        for (int i = 0; i < n; i++) {
            max = (max + (A[i] * pow) % mod) % mod;
            min = (min + (A[n - i - 1] * pow) % mod) % mod;
            pow = (pow * 2) % mod;
        }
        return (int) ((max - min + mod) % mod);
    }

    public int solve(ArrayList<Integer> A) {
        int mod = 1000000007;
        Collections.sort(A);
        int n = A.size();
        long max = 0;
        long min = 0;
        for (int i = 0; i < n; i++) {
            // number * no of subsequences the number exists in
            max = ((max + (long) A.get(i) * pow(2, i, mod)) % mod); //total max calculation
            min = ((min + (long) A.get(i) * pow(2, n - i - 1, mod)) % mod);  //total min calculation
        }
        return (int) (max - min + mod) % mod;  // (a-b)%m = (a%m - b%m + m)%m
    }

    long pow(int a, int n, int mod) {

        if (n == 0) {
            return 1;
        }
        long p = pow(a, n / 2, mod);
        long res = (p * p) % mod;
        if (n % 2 == 0) {
            return res;
        }
        return (res * a) % mod;

    }

}
