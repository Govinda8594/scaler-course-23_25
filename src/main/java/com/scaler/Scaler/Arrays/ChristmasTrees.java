package com.scaler.Scaler.Arrays;

public class ChristmasTrees {
    //    You are given an array A consisting of heights of Christmas trees and an array B of the same size consisting of the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you are supposed to choose 3 trees (let's say, indices p, q, and r),
//    such that Ap < Aq < Ar, where p < q < r.
//            The cost of these trees is Bp + Bq + Br.
//
//            You are to choose 3 trees such that their total cost is minimum. Return that cost.
//
//            If it is not possible to choose 3 such trees return -1.
    public static void main(String[] args) {
//        contributionTechinque();
    }

    public static int contributionTechinque(int[] A, int[] B) {
        int len = A.length, ans = Integer.MAX_VALUE, currentsum = 0;
        for (int j = 1; j < len - 1; j++) {
            currentsum = B[j];
            int leftsum = Integer.MAX_VALUE, rightsum = Integer.MAX_VALUE;
            for (int i = j - 1; i >= 0; i--) {
                if (A[i] < A[j] && B[i] < leftsum) {
                    leftsum = B[i];
                }
            }
            for (int k = j + 1; k < len; k++) {
                if (A[k] > A[j] && B[k] < rightsum) {
                    rightsum = B[k];
                }
            }
            if (leftsum != Integer.MAX_VALUE && rightsum != Integer.MAX_VALUE) {
                currentsum = currentsum + leftsum + rightsum;
                ans = Math.min(ans, currentsum);
            }
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    public int solve(int[] A, int[] B) {
        int len = A.length;
        int minsum = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            if (B[i] < minsum) {
                for (int j = i + 1; j < len - 1; j++) {
                    if (A[i] < A[j] && B[i] + B[j] < minsum) {
                        for (int k = j + 1; k < len; k++) {
                            if (A[j] < A[k]) {
                                int sum = B[i] + B[j] + B[k];
                                minsum = Math.min(sum, minsum);
                            }
                        }
                    }
                }
            }
        }
        return (minsum == Integer.MAX_VALUE) ? -1 : minsum;
    }
}
