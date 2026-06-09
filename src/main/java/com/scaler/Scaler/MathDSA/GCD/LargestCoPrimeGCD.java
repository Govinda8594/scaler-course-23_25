package com.scaler.Scaler.MathDSA.GCD;

public class LargestCoPrimeGCD {
    static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    //    You are given two positive numbers A and B . You need to find the maximum valued integer X such that:
//
//    X divides A i.e. A % X = 0
//    X and B are co-prime i.e. gcd(X, B) = 1
    public int cpFact(int A, int B) {
        while (gcd(A, B) != 1) {
            A /= gcd(A, B);
        }
        return A;
    }
}
