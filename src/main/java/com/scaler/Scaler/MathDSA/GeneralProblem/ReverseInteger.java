package com.scaler.Scaler.MathDSA.GeneralProblem;

public class ReverseInteger {
    public static void main(String[] args) {

        int result = 0, A = -123;
        while (A != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                System.out.println("result: " + 0);
            } else {
                result = result * 10 + (A % 10);
            }
            A /= 10;
        }
        System.out.println("result: " + result);

    }
}
