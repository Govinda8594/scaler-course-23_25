package com.scaler.Scaler.BitManipulation;

//Divide two integers without using multiplication, division and mod operator.
//        Return the floor of the result of the division.
//        Also, consider if there can be overflow cases i.e output is greater than INT_MAX, return INT_MAX.
//        NOTE: INT_MAX = 2^31 - 1

public class Divide {
    public static void main(String[] args) {
        divide2(-45, 9);
    }

    public static int divide(int A, int B) {
        int sign = (A < 0) ^ (B < 0) ? -1 : 1;
        if (B == 1) {                     //Edge Case
            return A;
        }
        if (A == Integer.MIN_VALUE) {     //Edge Case
            A = Integer.MAX_VALUE;
        }
        long x = Math.abs(A);
        long y = Math.abs(B);
        int quotient = 0;
        while (x >= y) {
            x = x - y;
            quotient++;
        }
        return (int) quotient * sign;
    }

    /////////////////////////////////////////////////////////////////////////////////
    public static int divide2(int A, int B) {
        if (A == (1 << 31) && B == -1)
            return (1 << 31) - 1;
        int sign = (A < 0) ^ (B < 0) ? -1 : 1;
        long a = Math.abs((long) A);
        long b = Math.abs((long) B);
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            if (a - (b << i) >= 0) {
                res += 1 << i;
                a -= b << i;
            }
        }
        return res * sign;
    }
}

