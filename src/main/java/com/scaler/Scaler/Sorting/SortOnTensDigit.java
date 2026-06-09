package com.scaler.Scaler.Sorting;

import java.util.Arrays;

public class SortOnTensDigit {
    public static void main(String[] args) {
        getSortOnTensDigits(new int[]{15, 11, 7, 19});
    }

    static int[] getSortOnTensDigits(int[] A) {
        int len = A.length;
        Integer[] I = new Integer[len];
        for (int i = 0; i < len; i++) {
            I[i] = A[i];
        }
        Arrays.sort(I, (a, b) -> {
            int i = (a / 10) % 10;  // for ten place value divide 10 and then mod 10
            int j = (b / 10) % 10;
            if (i == j) {
                if (a <= b) return 1;
                else return -1;
            } else if (i < j) {
                return -1;
            } else
                return 1;
        });
        for (int i = 0; i < len; i++) {
            A[i] = Integer.valueOf(I[i]);
        }
        return A;
    }

    public int[] optimize(int[] A) {
        Integer[] arr = new Integer[A.length];
        for (int i = 0; i < A.length; i++)
            arr[i] = A[i];
        Arrays.sort(arr, (a, b) -> {
            int c = (a / 10) % 10;
            int d = (b / 10) % 10;
            if (c == d) return b - a;
            else return c - d;
        });
        for (int i = 0; i < A.length; i++)
            A[i] = arr[i];
        return A;
    }
}
