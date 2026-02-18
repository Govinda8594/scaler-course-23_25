package com.scaler.Scaler.MathDSA.GeneralProblem;

public class PerfectSquare {
    //    A perfect square is an integer that is the square of an integer.
//    For example 16 is perfect square as it is the square of an integer 4 (42 = 16)
    public int solve2(int A) {
        int sqrt = (int) Math.sqrt(A);
        if (sqrt * sqrt == A)
            return sqrt;
        else
            return -1;

    }

    public int solve(int A) {
        int low = 0, high = A / 2;
        if (A == 1) return 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            long sqrt = (long) mid * mid;
            if (sqrt == (long) A) {
                return 1;
            } else if (sqrt < (long) A)
                low = mid + 1;
            else high = mid - 1;
        }
        return 0;
    }
}
