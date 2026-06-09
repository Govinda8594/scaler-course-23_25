package com.scaler.Scaler.Pointer;

import java.util.Arrays;
//Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
//
//        If the answer does not exist return an array with a single integer "-1".
//
//        First sub-array means the sub-array for which starting index in minimum.
public class ReturnSubArraySumK {
    public static void main(String[] args) {

    }

    public int[] subArraySumwithK(int[] A, int B) {
        // this logic work when arrays is sorted and have positive number of elements
        int len = A.length;
        int start = 0, end = 0;
        int sum = A[start];
        while (end < len && start <= end) {
            if (sum == B) {
                return Arrays.copyOfRange(A, start, end + 1);
            } else if (sum < B) {
                end++;
                if (end < len)
                    sum += A[end];
            } else {
                sum -= A[start];
                start++;
                if (start > end && start <= len - 1) {
                    end++;
                    sum += A[end];
                }
            }
        }
        return new int[]{-1};
    }
}
