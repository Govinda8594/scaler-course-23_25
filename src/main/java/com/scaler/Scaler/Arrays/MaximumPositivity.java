package com.scaler.Scaler.Arrays;

import java.util.Arrays;

public class MaximumPositivity {
    //    Given an array of integers A, of size N
//    Return the maximum size subarray of A having only non-negative elements. If there are more than one such subarray, return the one having the smallest starting index in A.
    public static void main(String[] args) {
        int[] ans = MaximumPositivity(new int[]{5, 6, 7, 3, -1, 7, 8, 1, 2});
    }

    public static int[] MaximumPositivity(int[] arr) {
        int len = arr.length, i = 0, j = 0, start = 0, end = -1;
        while (j < len) {
            if (arr[j] < 0) {
                if ((j - i) > (end - start + 1)) {
                    start = i;
                    end = j - 1;
                }
                i = j + 1;
            }
            j++;
        }
        if ((j - i) > (end - start + 1)) {
            start = i;
            end = j - 1;
        }
        return Arrays.copyOfRange(arr, start, end + 1);
    }

    public int[] solve(int[] arr) {
        int n = arr.length;
        int start = 0;
        int len = 0;
        int max_start = 0;
        int max_size = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                len++;
            } else {
                start = i + 1; // current i have -ve val , start will be i + 1 val
                len = 0;
            }
            if (len > max_size) {
                max_size = len;
                max_start = start;
            }
        }
        int[] ans = new int[max_size];
        for (int i = max_start; i < max_start + max_size; i++) {
            ans[i - max_start] = arr[i];
        }
        return ans;
    }
}