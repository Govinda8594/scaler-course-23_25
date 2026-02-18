package com.scaler.Scaler.Arrays;

public class MinorDiagonalSum {
//    You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
//
//    Minor diagonal of a M X M matrix A is a collection of elements A[i, j] such that i + j = M + 1 (where i, j are 1-based).
    public int solve(final int[][] A) {
        int i = A.length -1,j = 0,sum = 0;
        while(j < A.length && i >= 0){
            sum += A[j++][i--];
        }
        return sum;
    }
}
