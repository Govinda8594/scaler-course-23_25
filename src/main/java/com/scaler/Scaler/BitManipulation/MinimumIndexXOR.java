package com.scaler.Scaler.BitManipulation;

public class MinimumIndexXOR {
    public static void main(String[] args) {
//        minimumMax()
    }

    static int minimumMax(int[] a) {
        // Write your code here.
        int len = a.length, max = 0;
        // Arrays.sort(a);
        int X = a[len - 1];
        for (int i = 0; i < len; i++) {
            a[i] = a[i] ^ X;
        }
        for (int num : a) {
            max = Math.max(num, max);
        }
        return max;
    }
}
