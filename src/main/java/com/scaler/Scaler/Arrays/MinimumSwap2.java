package com.scaler.Scaler.Arrays;

public class MinimumSwap2 {
    public static void main(String[] args) {
    }
    //    Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
//
//    It is allowed to swap any two elements (not necessarily consecutive).
//
//    Find the minimum number of swaps required to sort the array in ascending order.
    public int minimumSwap2(int[] A) {
        int count = 0;
        int i = 0;
//  arrange in ascending order from 1 to N-1
        while (i < A.length) {
            if (A[i] == i) {
                i++;
            } else {
                count++;
                int temp = A[i];
                A[i] = A[temp];
                A[temp] = temp;
            }
        }
        return count;
    }
}
