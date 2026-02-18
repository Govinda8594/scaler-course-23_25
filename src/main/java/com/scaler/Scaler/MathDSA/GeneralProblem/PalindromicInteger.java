package com.scaler.Scaler.MathDSA.GeneralProblem;

public class PalindromicInteger {
    public static void main(String[] args) {
        int A = 5656;
        int original = A;
        int rev = 0;
        for (; A > 0; A /= 10) {
            int rem = A % 10;
            rev = (rev * 10) + rem;
        }
        if (rev == original)
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
