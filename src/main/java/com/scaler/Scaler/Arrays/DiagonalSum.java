package com.scaler.Scaler.Arrays;

public class DiagonalSum {
    public int solve(final int[][] A) {
        int i=0,j=0,sum = 0;
        int len = A.length;
        while(i<len && j<len){
            sum += A[i][j];
            i++;
            j++;
        }
        return sum;
    }
}
