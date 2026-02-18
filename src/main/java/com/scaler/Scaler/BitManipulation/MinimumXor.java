package com.scaler.Scaler.BitManipulation;

import java.util.Arrays;
//Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.
public class MinimumXor {

    public int findMinXor(int[] A) {
        Arrays.sort(A);
        int minXor = A[0] ^ A[1],len = A.length;
        for(int i = 2;i<len;i++){
            minXor = Math.min(minXor,A[i]^A[i-1]);
        }
        return minXor;
    }
}
