package com.scaler.Scaler.Arrays;

public class MaxElementInWindowSizeK {
    public static int[] maxInWindow(int[] A, int k) {
        int n = A.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, A[j]);
            }
            result[i] = max;
        }
        return result;
    }
}
