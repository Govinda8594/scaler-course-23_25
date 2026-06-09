package com.scaler.Scaler.Pointer;
//You are given 3 sorted arrays A, B and C.
//        Find i, j, k such that : max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
//        Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])).
public class MinimizeAbsDifferenceOf3Array {

    public class Solution {
        public int solve(int[] A, int[] B, int[] C) {
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
}
