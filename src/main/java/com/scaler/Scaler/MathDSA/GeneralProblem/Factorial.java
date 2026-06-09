package com.scaler.Scaler.MathDSA.GeneralProblem;

public class Factorial {
    public int solve(int A) {
        if (A == 1) return A;
        return solve(A - 1) * A;
    }

}
