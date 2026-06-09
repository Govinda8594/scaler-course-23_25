package com.scaler.Scaler.MathDSA.GeneralProblem;

public class PrintOutput {

    public static void main(String[] args) {
        printValue(1234);
    }

    static void printValue(int value) {
        System.out.print(value % 10);
        if (value > 0) {
            value /= 10;
            printValue(value);
        }
        System.out.print(value);

    }
}
