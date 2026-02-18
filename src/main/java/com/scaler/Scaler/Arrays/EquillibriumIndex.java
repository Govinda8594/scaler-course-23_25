package com.scaler.Scaler.Arrays;

public class EquillibriumIndex {


    public int solve(int[] A) {
        int n = A.length;
        int[] prefSum = new int[n];
        prefSum[0] = A[0];
        for (int i = 1; i < n; i++) {
            prefSum[i] = prefSum[i - 1] + A[i];
        }
        for (int i = 0; i < n; i++) {
            int leftSum = (i == 0) ? 0 : prefSum[i - 1];
            int rightSum = prefSum[n - 1] - prefSum[i];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public int solve2(int[] A) {
        int n = A.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        leftSum[0] = 0;
        rightSum[n - 1] = 0;
        for (int i = 1; i < n; i++) {
            leftSum[i] = leftSum[i - 1] + A[i - 1];
        }
        for (int i = n - 2; i > 0; i--) {
            rightSum[i] = rightSum[i + 1] + A[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (leftSum[i] == rightSum[i]) {
                return i;
            }
        }
        return -1;
    }


}
