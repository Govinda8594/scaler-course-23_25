package com.scaler.Scaler.Graph.Algorithm;

//Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).
//        If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
//        Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
//        If there is no possible path from vertex i to vertex j , B[i][j] = -1
//        Note: Rows are numbered from top to bottom and columns are numbered from left to right.
//
//        Problem Constraints
//        1 <= N <= 200
//        -1 <= A[i][j] <= 1000000
public class FloydWarshallAlgorithm {
    int MAX_VALUE = 1000000 + 1;

    public int[][] solve3(int[][] A) {
        int n = A.length;
        int[][] B = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = A[i][j] == -1 ? MAX_VALUE : A[i][j];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    B[i][j] = Math.min(B[i][j], B[i][k] + B[k][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j] == MAX_VALUE) {
                    B[i][j] = -1;
                }
            }
        }
        return B;
    }
}
