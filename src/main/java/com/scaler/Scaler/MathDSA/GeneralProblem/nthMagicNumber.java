package com.scaler.Scaler.MathDSA.GeneralProblem;

public class nthMagicNumber {
    public int solve(int A) {
        int ans = 0, power = 5;
        while (A > 0) {
            int r = A % 2;
            A = A / 2;
            ans += r * power;
            power *= 5;
        }
        return ans;
    }
}
