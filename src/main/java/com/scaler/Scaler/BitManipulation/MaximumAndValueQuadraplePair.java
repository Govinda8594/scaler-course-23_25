package com.scaler.Scaler.BitManipulation;

public class MaximumAndValueQuadraplePair {
    public static void main(String[] args) {

    }
//    Given an array A. For Qudrapel pair of indices i and j (i != j), find the maximum A[i] & A[j].

    // Maximum in quadraple Pair A&B&C&D such that i != j !=  k != l
    // Google question
    static int getAndPair(int[] A) {
        int ans = 0, len = A.length;
        for (int i = 30; i >= 0; i--) {
            int count = 0;
            for (int k : A) {
                if ((k >> i & 1) == 1) count++;
            }
            if (count >= 4) {
                ans += (1 << i);

                // now discard the element which has unset bits
                for (int j = 0; j < len; j++) {
                    if ((A[j] >> i & 1) == 0) {
                        A[j] = 0;
                    }
                }
            }
        }
        return ans;
    }
}
