package com.scaler.Scaler.MathDSA.GeneralProblem;

public class SumOfDigit {
    public static void main(String[] args) {
        int num = 565;
        int sum = 0;

        int digit = 0;
        while (num > 0) {
            digit = num % 10;
            num = num / 10;
            sum += digit;
        }
        System.out.println(sum);
    }
}
