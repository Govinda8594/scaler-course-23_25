package com.scaler.Scaler.Arrays;

public class CountEvenNumberInRange {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[][] B = new int[][]{{0, 2}, {2, 4}, {1, 4}};
        int[] ans = CountEvenNumberInRange(A, B);
    }

    public static int[] CountEvenNumberInRange(int[] A, int[][] B) {
        int len = A.length;
        int b_len = B.length;
        int[] pf = new int[len];
        int[] result = new int[b_len];
        pf[0] = 1 - (A[0] % 2);
        for (int i = 1; i < len; i++) {
            pf[i] = pf[i - 1] + (1 - A[i] % 2);
        }
        int l = 0;
        int r = 0;
        for (int j = 0; j < b_len; j++) {
            l = B[j][0];
            r = B[j][1];
            if (l == 0)
                result[j] = pf[r];
            else
                result[j] = pf[r] - pf[l - 1];
        }
        return result;
    }
}
