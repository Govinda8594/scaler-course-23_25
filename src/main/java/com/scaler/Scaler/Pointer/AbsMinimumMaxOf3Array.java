package com.scaler.Scaler.Pointer;
//Given three sorted arrays A, B and Cof not necessarily same sizes.

//        Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively. i.e. minimize | max(a,b,c) - min(a,b,c) |.
public class AbsMinimumMaxOf3Array {

    public int minimize(final int[] A, final int[] B, final int[] C) {
        int diff = Integer.MAX_VALUE;
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        int i, j, k;
        for (i = 0, j = 0, k = 0; i < A.length && j < B.length && k < C.length; ) {
            //  max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) = max(A[i], B[j], C[k]) - min(A[i], B[j], C[k])
            minimum = Math.min(A[i], Math.min(B[j], C[k]));
            maximum = Math.max(A[i], Math.max(B[j], C[k]));
            diff = Math.min(diff, maximum - minimum);
            if (diff == 0) {
                break;
            }
            if (A[i] == minimum) {
                i++;
            } else if (B[j] == minimum) {
                j++;
            } else {
                k++;
            }
        }
        return diff;
    }
    /////////////////////////////////////////////////////////////////////////////////////

    public int minimize2(final int[] A, final int[] B, final int[] C) {
        int ans = Integer.MAX_VALUE;
        int n1 = A.length, n2 = B.length, n3 = C.length;
        int l1 = 0, l2 = 0, l3 = 0;
        while (l1 < n1 && l2 < n2 && l3 < n3) {
            int e1 = A[l1], e2 = B[l2], e3 = C[l3];
            int current = Math.max(Math.abs(e1 - e2), Math.max(Math.abs(e2 - e3), Math.abs(e3 - e1)));
            ans = Math.min(ans, current);
            if (e1 <= e2 && e1 <= e3) {
                l1++;
            } else if (e2 <= e1 && e2 <= e3) {
                l2++;
            } else {
                l3++;
            }
        }
        return ans;
    }
}
