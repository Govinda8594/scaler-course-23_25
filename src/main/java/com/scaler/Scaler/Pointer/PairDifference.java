package com.scaler.Scaler.Pointer;

public class PairDifference {

    static boolean sumK(int[] A, int B) {
        int len = A.length;
        if (B < 0) {
            // reverse the pair for answser;
            B *= -1;
        }
        int ptr1 = 0, ptr2 = 1;
        while (ptr2 < len) {
            if (A[ptr1] - A[ptr2] == B) {
                return true;
            } else if (A[ptr1] - A[ptr2] > B) {
                ptr1++;
            } else {
                ptr2++;
            }
        }
        return false;
    }
}
