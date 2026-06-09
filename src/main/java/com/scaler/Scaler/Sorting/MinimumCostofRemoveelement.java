package com.scaler.Scaler.Sorting;

import java.util.Arrays;

public class MinimumCostofRemoveelement {
    public static void main(String[] args) {
        int minCost = removeelementmincost(new int[]{5, 7, 8, 1, 2, 8});
    }

    static int removeelementmincost(int[] A) {
        int len = A.length, sum = 0;
        Arrays.sort(A);
        for (int j : A) {
            sum += j;
        }
        int mincost = sum;
        for (int i = A.length - 1; i >= 0; i--) {
            sum -= A[i];
            mincost += sum;
        }
        return mincost;
    }

    public int optimize(int[] A) {
        Arrays.sort(A);
        int mincost = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
//            contribution technique ==> how many time a[i] occurs in array (i+1)times
            mincost = mincost + A[i] * (len - i);
        }
        return mincost;
    }
}
