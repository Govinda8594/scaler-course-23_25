package com.scaler.Scaler.Arrays;

import java.util.Arrays;

public class PairInSortedArray {
    public static void main(String[] args) {
        pairsInDifference(new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}, 1);
    }


    // Array is sorted
    static boolean pairsInDifference(int[] A, int k) {
        Arrays.sort(A);
        int len = A.length;
        if (k < 0) k = k * -1;
        int ptr1 = 0, ptr2 = 1;
        while (ptr2 < len && ptr1 != ptr2) {
            if (A[ptr2] - A[ptr1] == k) {
                return true;
            } else if (A[ptr2] - A[ptr1] > k) {
                ptr1++;
                if (ptr1 == ptr2) ptr2++;
            } else ptr2++;
        }
        return false;
    }

    // Array is sorted
    static boolean pairsInSum(int[] A, int k) {
        Arrays.sort(A);  // this logic works when array is sorted
        int len = A.length;
        int ptr1 = 0, ptr2 = len - 1;
        while (ptr2 > ptr1 && ptr1 != ptr2) {
            if (A[ptr2] + A[ptr1] == k) {
                return true;
            } else if (A[ptr2] + A[ptr1] > k) {
                ptr2--;
            } else ptr1++;
        }
        return false;
    }
}
