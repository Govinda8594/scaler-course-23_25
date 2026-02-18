package com.scaler.Scaler.BitManipulation;

public class SumOfAllXORPair {

    int xorpairsum(int[] A) {
        int sum = 0;
        for (int i = 0; i <= 30; i++) {
            int countsetBit = 0;
            for (int k : A) {
                if (((k >> i) & 1) == 1) {
                    countsetBit++;
                }
            }
            int pair = countsetBit * (A.length - countsetBit);
            sum += pair * (1 << i);
        }
        return 2 * sum;
    }


//    public int solve(int[] A) {
//        long sum = 0;
//        int MOD = 1000000007;
//
//        for (int i = 0; i < 31; i++) { // Adjusting to ensure bit range 0–30 inclusive
//            long countSetBit = 0;
//
//            for (int num : A) {
//                if (((num >> i) & 1) == 1) {
//                    countSetBit++;
//                }
//            }
//
//            long pairCount = countSetBit * (A.length - countSetBit);
//            sum += (pairCount * (1L << i)) % MOD; // Ensure intermediate values remain within bounds
//            sum %= MOD; // Apply modulus after summation
//        }
//
//        return (int) sum;
//    }
}
