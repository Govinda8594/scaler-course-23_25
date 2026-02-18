package com.scaler.Scaler.Arrays;

public class SumOfAllSubMatrics {

    public static void main(String[] args) {
    }

    public static int SumOfAllSubMatrics(int[][] A) {
        int sum = 0;
        int M = A.length;
        int N = A[0].length;
        // contributions technice
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sum += A[i][j] * (i + 1) * (j + 1) * (M - i) * (N - j);
            }
        }
        return sum;
    }
}
