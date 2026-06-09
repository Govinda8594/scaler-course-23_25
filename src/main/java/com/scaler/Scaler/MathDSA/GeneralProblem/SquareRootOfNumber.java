package com.scaler.Scaler.MathDSA.GeneralProblem;

public class SquareRootOfNumber {
    public int solve(int A) {
        int low = 0, high = A / 2;
        if (A == 1) return 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            long sqrt = (long) mid * mid;
            if (sqrt == (long) A) {
                return mid;
            } else if (sqrt < (long) A) {
                low = mid + 1;
            } else high = mid - 1;
        }
        return -1;
    }

    public int solve2(int A) {
        int sqrt = (int) Math.sqrt(A);
        if (sqrt * sqrt == A)
            return sqrt;
        else
            return -1;

    }

    int solve4(int A){
        for(int i = 1;i <= A;i++){
            int quotient = A/i;
            if(quotient * quotient == A)
                return quotient;
        }
        return -1;
    }

     int solve3(int A){
        for(int i = 1;i*i <= A;i++){
            int quotient = A/i;
            if(quotient * quotient == A)
                    return quotient;
        }
        return -1;
     }
}
