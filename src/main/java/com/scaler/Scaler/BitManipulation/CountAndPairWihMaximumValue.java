package com.scaler.Scaler.BitManipulation;

public class CountAndPairWihMaximumValue {
    public static void main(String[] args) {

    }

    static int getAndPair(int[] A) {
        int ans = 0, len = A.length, Maxvalue = 0;
        for (int i = 30; i >= 0; i--) {
            int count = 0;
            for (int k : A) {
                if ((k >> i & 1) == 1) count++;
            }
            if (count >= 2) {
                ans += (1 << i);

                // now discard the element which has unset bits
                for (int j = 0; j < len; j++) {
                    if ((A[j] >> i & 1) == 0) {
                        A[j] = 0;
                    }
                }
            }
            for (int k : A) {
                if ((k >> i & 1) == 1) Maxvalue++;
            }
        }
        return ans;
    }


}
