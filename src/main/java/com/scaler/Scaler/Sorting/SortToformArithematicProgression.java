package com.scaler.Scaler.Sorting;

import java.util.Arrays;

public class SortToformArithematicProgression {
//    Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.
//    A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.
    public int solve(int[] A) {
        int len = A.length;
        Arrays.sort(A);
        for(int i = 1; i+1 < len; i++){
            if(A[i]-A[i-1] != A[i+1] - A[i])
                return 0;
        }
        return 1;
    }
}
