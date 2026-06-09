package com.scaler.Scaler.Arrays;

public class SingleNumberUniqueNumber {
    // Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
    // take xor
    public int singleNumber(final int[] A) {
        int ans = 0;
        int len = A.length;
        for (int j : A) {
            ans = ans ^ j;
        }
        return ans;
    }
}
