package com.scaler.Scaler.MathDSA.Modulo;

//Given an array A of size N. Rearrange the given array so that A[i] becomes A[A[i]] with O(1) extra space.
public class RearrangeElementInModular {
    public int[] arrange(int[] A) {
//        old data = A[i] / n
//        new data = A[i] % n
        int size = A.length;
        // storing 2 type of data in one data
        for (int i = 0; i < size; i++) {
            A[i] = A[i] * size;
        }
        int idx = 0, val = 0;
        for (int i = 0; i < size; i++) {
            // A[i] = a[A[i]]
            idx = A[i] / size;
            val = A[idx] / size;
            A[i] = A[i] + val;
        }
        for (int i = 0; i < size; i++) {
            A[i] = A[i] % size;
        }
        return A;
    }
}
