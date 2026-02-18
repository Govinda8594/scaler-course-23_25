package com.scaler.Scaler.MathDSA.Modulo;

//Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.
public class GreatestPossibleValue {

    // case 1 A > B, where A implies
    // A = B - (B- A)
    // we have A % (B-A), subsitute A
    // (B - (B-A)) % (B-A) apply mod
    // => A % (B-A) = B % (B-A) - (B-A)%(B-A)
    // => A % (B-A) = B % (B-A)

    // case 2 A < B, where B = B =>
    // B = A - (A- B)
    // => B%(A - B) = (A - (A-B)) % (A-B)
    //  => B % (A-B) = A % (A-B) - (A-B)%(A-B)
    //   => A%(A-B)  = B % (B-A)
    public int solve(int A, int B) {
        return Math.abs(A - B);
    }
}
