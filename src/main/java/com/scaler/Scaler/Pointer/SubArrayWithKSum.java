package com.scaler.Scaler.Pointer;

public class SubArrayWithKSum {
    public int[] solve(int[] A, int B) {
        int p1 = 0, p2 = 1;
        while (p2 < A.length && p1 < p2) {
            if (A[p1] + A[p2] == B) {
                return new int[]{A[p1], A[p2]};
            } else if (A[p1] + A[p2] < B) {
                p2++;
            } else {
                p1++;
            }
        }
        return new int[]{-1};
    }
}
