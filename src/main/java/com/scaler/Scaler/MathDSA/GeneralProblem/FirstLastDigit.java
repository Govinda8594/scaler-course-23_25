package com.scaler.Scaler.MathDSA.GeneralProblem;

public class FirstLastDigit {
    public static void main(String[] args) {

        int N = 4534;
        int lastdigit = 0;
        int firstdigit = 0;
        int numberOfDigit = (int) Math.log10(N);
        firstdigit = (N / (int) (Math.pow(10, numberOfDigit)));
        lastdigit = N % 10;
        System.out.println(firstdigit + " " + lastdigit);
    }

}
