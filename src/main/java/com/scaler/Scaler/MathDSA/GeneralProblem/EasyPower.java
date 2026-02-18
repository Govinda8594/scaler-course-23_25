package com.scaler.Scaler.MathDSA.GeneralProblem;

import java.util.Scanner;

public class EasyPower {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int exponent = sc.nextInt();
        long result = 1;
        while (exponent != 0) {
            result *= base;
            --exponent;
        }

        System.out.println(result);
    }
}
