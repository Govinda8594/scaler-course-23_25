package com.scaler.Scaler.Sorting;

import java.util.Arrays;
//Given an array of integers A of size N where N is even.
//
//        Divide the array into two subsets such that
//
//        1.Length of both subset is equal.
//        2.Each element of A occurs in exactly one of these subset.
//        Magic number = sum of absolute difference of corresponding elements of subset.
//
//        Note: You can reorder the position of elements within the subset to find the value of the magic number.
//
//        For Ex:-
//        subset 1 = {1, 5, 1},
//        subset 2 = {1, 7, 11}
//        Magic number = abs(1 - 1) + abs(5 - 7) + abs(1 - 11) = 12
//        Return an array B of size 2, where B[0] = maximum possible value of Magic number modulo 109 + 7, B[1] = minimum possible value of a Magic number modulo 109 + 7.
public class MaximumMinimumAbsDifference {
    public int[] solve(int[] A) {
        int mod = (int) Math.pow(10, 9) + 7;
        Arrays.sort(A);
        long max = 0L;
        long min = 0L;
        int n = A.length;
        // for (int i = 0; i < n / 2; i++) {
        //     max = (max + (Math.abs(A[i] - A[n - i - 1])) % mod) % mod;
        // }
        int l = 0, r = n - 1;
        while (l < r) {
            max = (max + (Math.abs(A[r] - A[l])) % mod) % mod;
            l++;
            r--;
        }
        for (int i = 1; i < n; i += 2) {
            min = (min + (Math.abs(A[i] - A[i - 1])) % mod) % mod;
        }
        return new int[]{
                (int) max % mod, (int) min % mod
        };
    }
}
