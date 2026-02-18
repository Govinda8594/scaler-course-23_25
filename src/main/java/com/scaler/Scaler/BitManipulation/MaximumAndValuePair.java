package com.scaler.Scaler.BitManipulation;

//Given an array A. For every pair of indices i and j (i != j), find the maximum A[i] & A[j].
public class MaximumAndValuePair {
    public static void main(String[] args) {
    }

    public boolean checkBit(int b, int i) {
        return ((b >> i) & 1) == 1;
    }

    public int solve(int[] A) {
        int n = A.length;
        //checking bit from left to right MSB to LSB for two maximaum set bits
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int count = 0;
            for (int k : A) {
                if (checkBit(k, i)) {
                    count++;
                }
            }
            //if we found two bits that are set and their count is greater than equal two we add or set ith bit 1
            if (count >= 2) {
                ans = ans | (1 << i);
                // now discard the element which has unset bits
                //traverse again to the array to check bits and if bit is unset we directly create A[j]=0 for that element
                for (int j = 0; j < n; j++) {
                    if (!checkBit(A[j], i)) {
                        A[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
