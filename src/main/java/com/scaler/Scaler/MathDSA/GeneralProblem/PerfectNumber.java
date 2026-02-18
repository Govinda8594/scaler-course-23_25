package com.scaler.Scaler.MathDSA.GeneralProblem;

public class PerfectNumber {
    //    Perfect number is a positive integer which is equal to the sum of its proper positive divisors.
//    A proper divisor of a natural number is the divisor that is strictly less than the number.
    public static void main(String[] args) {
        int A = 6;
        int divisior;
        divisior = 0;
        for (int j = 1; j <= A / 2; j++) {
            if (A % j == 0) {
                divisior = divisior + j;
            }

        }

        if (divisior == A)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    public int solve(int A) {
        int sum = 0;
        for (int i = 1; i <= A / 2; i++) {
            if (A % i == 0) {
                sum += i;
            }
        }
        if (sum == A) {
            return 1;
        }
        return 0;
    }
}
