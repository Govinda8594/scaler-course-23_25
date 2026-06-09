package com.scaler.Scaler.Pointer;

public class PairSumK {

    static boolean sumK(int[] A, int B) {
        int len = A.length;
        int ptr1 = 0, ptr2 = len - 1;
        while (ptr1 < ptr2) {
            if (A[ptr1] + A[ptr2] == B)
                return true;
            else if (A[ptr1] + A[ptr2] > B)
                ptr2++;
            else ptr1++;
        }
        return false;
    }

    boolean pairSumk2(int[] A, int B) {
        int len = A.length;
        int i = 0, j = 0;
        int sum = A[0];
        while (i < len || j < len) {
            if (sum == B) {
                return true;
            } else if (sum < B) {
                j++;
                sum += A[j];
            } else {
                i++;
                sum -= A[i];
            }
        }
        return true;
    }

    boolean pairSumK(int[] A, int B) {
        int len = A.length;
        int Prefix[] = new int[len];
        Prefix[0] = A[0];
        for (int i = 1; i < len; i++) {
            Prefix[i] = Prefix[i - 1] + A[i];
        }
        for (int i = 0; i < len; i++) {
            if (Prefix[i] == B) {
                return true;
            }
        }
        int i = 0, j = 0;
        while (i < len || j < len) {
            if (A[j] - A[i] == B) {
                return true;
            }
            if (A[j] - A[i] < B) {
                j++;
            } else {
                i++;
            }
        }
        return false;
    }
}
