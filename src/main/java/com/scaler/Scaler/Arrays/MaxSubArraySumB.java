package com.scaler.Scaler.Arrays;

public class MaxSubArraySumB {
//    You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
//    But the sum must not exceed B.

    public int maxSubarray(int A, int B, int[] C) {
        int max = 0;
        int sum= 0;
        int end = 0;
        int start = 0;
        while(end<A){
            if(sum + C[end] <= B){
                sum += C[end];
                max = (int)Math.max(sum,max);
                end++;
            }else{
                sum -= C[start];
                start++;
            }
        }
        return max;
    }

    public int maxSubarray1(int A, int B, int[] C) {
        int ans = 0;
        for (int i = 0; i < A; i++) {
            int sum = 0;
            for (int j = i; j < A; j++) {
                sum += C[j];
                if (sum <= B)
                    ans = Math.max(ans, sum);
                else break;
            }
        }
        return ans;
    }
}
