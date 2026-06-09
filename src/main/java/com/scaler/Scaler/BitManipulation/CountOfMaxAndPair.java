package com.scaler.Scaler.BitManipulation;

public class CountOfMaxAndPair {

    static int getAndPair(int[] A) {
        int ans = 0, len = A.length;
        //checking bit from left to right MSB to LSB for two maximaum set bits
        for (int i = 30; i >= 0; i--) {
            int count = 0;
            for (int k : A) {
                if ((k >> i & 1) == 1) count++;
            }
            //if we found two bits that are set and their count is greater than equal two we add or set ith bit 1
            if (count >= 2) {
                ans += (1 << i);
                // now discard the element which has unset bits
                for (int j = 0; j < len; j++) {
                    if ((A[j] >> i & 1) == 0) {
                        A[j] = 0;
                    }
                }
            }
        }
        int nozero = 0;
        for (int j : A) {
            if (j != 0) {
                nozero++;
            }
        }

        return (nozero * (nozero + 1)) / 2;
    }

}
