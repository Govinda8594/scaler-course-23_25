package com.scaler.Scaler.Sorting;

public class PlaceElementAtCorrectPosition {


    static void rearrange2(int[] A) {
        int len = A.length;
        int p1 = 1, p2 = len - 1;
        while (p1 <= p2) {
            if (A[0] >= A[p1]) {
                p1++;
            } else if (A[0] < A[p2]) {
                p2--;
            } else {
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
                p2--;
                p1++;
            }
        }
        int temp = A[0];
        A[0] = A[p2];
        A[p2] = temp;
    }

    static void rearrange(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        int p1 = 0, p2 = 0;
        for (int i = 0; i < len; i++) {
            if (A[i] <= A[0]) {
                B[i] = A[i];
                p1++;
            } else {
                B[p2] = A[i];
                p2++;
            }
        }
        B[p1] = A[0];
    }

    static int swapInSubarrayRearrange(int[] A,int start,int end) {
        int len = A.length;
        int p1 = start, p2 = end;
        while (p1 <= p2) {
            if (A[start] >= A[p1]) {
                p1++;
            } else if (A[start] < A[p2]) {
                p2--;
            } else {
                int temp = A[p1];
                A[p1] = A[p2];
                A[p2] = temp;
                p2--;
                p1++;
            }
        }
        int temp = A[start];
        A[start] = A[p2];
        A[p2] = temp;
        return p2;
    }
}
