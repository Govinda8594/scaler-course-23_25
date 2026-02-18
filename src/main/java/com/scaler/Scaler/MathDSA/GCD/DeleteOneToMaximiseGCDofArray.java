package com.scaler.Scaler.MathDSA.GCD;

//Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
//        Find the maximum value of GCD.
public class DeleteOneToMaximiseGCDofArray {
    public static void main(String[] args) {

    }

    public static int deleteOneToMaximiseGCDofArray(int[] A) {
        int len = A.length;
        int[] pfGCD = new int[len];
        int[] sfGCD = new int[len];
        pfGCD[0] = A[0];
        sfGCD[len - 1] = A[len - 1];
        for (int i = 1; i < len; i++) {
            pfGCD[i] = gcd(pfGCD[i - 1], A[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            sfGCD[i] = gcd(sfGCD[i + 1], A[i]);
        }
        int ans = Math.max(pfGCD[len - 2], sfGCD[1]);
        for (int i = 1; i <= len - 2; i++) {
            int left = pfGCD[i - 1], right = sfGCD[i + 1];
            int val = gcd(left, right);
            ans = Math.max(ans, val);
        }
        return ans;
    }

    public static int gcd(int A, int B) {
        int a = Math.abs(A);
        int b = Math.abs(B);
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
