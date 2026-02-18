package com.scaler.Scaler.MathDSA.GCD;

//Given 2 non-negative integers A and B, find gcd(A, B)
//        GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor of both A and B. Both A and B fit in a 32 bit signed integer.
//        Note: DO NOT USE LIBRARY FUNCTIONS.
public class FastGCD {

    public static void main(String[] args) {
        new FastGCD().gcdOfTwo1(36, 10);
    }

    int gcdOfTwo(int A, int B) {
        int gcd = 1;
        for (int i = Math.min(A, B); i >= 1; i--) {
            if (A % i == 0 && B % i == 0) {
                gcd = i;
                System.out.println(i);
                break;
            }
        }
        return gcd;
    }

    // Euclidean Algorithm of A,B => (A%B,B)
    public int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    int gcdOfTwo1(int A, int B) {
        int gcd = 0;
        while (A > 0 && B > 0) {
            if (A > B) A = A % B;
            else B = B % A;
            if (A == 0) gcd = B;
            else gcd = A;
        }
        return gcd;
    }
}
