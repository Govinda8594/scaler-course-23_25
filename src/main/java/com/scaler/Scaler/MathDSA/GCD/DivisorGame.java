package com.scaler.Scaler.MathDSA.GCD;

//Scooby has 3 three integers A, B, and C.
//        Scooby calls a positive integer special if it is divisible by B and it is divisible by C. You need to tell the number of special integers less than or equal to A.
public class DivisorGame {

    public static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    public int solve(int A, int B, int C) {
        int gcd = gcd(B, C);
        int lcm = (B * C) / gcd;
        return A / lcm;
    }
}
