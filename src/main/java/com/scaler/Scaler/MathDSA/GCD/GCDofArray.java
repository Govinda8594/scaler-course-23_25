package com.scaler.Scaler.MathDSA.GCD;

public class GCDofArray {

    // O(n * log2(max of array))
    static int gcdArray(int[] array) {
        int ans = array[0];
        int len = array.length;
        for (int i = 1; i < len; i++) {
            ans = gcd(ans, array[i]);

        }
        return ans;
    }

    static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }
}
