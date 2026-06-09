package com.scaler.Scaler.MathDSA.PrimeNumber;

public class Countdigit1 {

    public static void main(String[] args) {

    }

    static int countdigit(int N) {
        int base = 1;
        int sum = 0;
        while (base <= N) {
            int left = (N / base) / 10;
            int curr = (N / base) % 10;
            int right = N % base;
            if (curr < 1) {
                sum = sum + left * base;
            } else if (curr == 1) {
                sum = sum + left * base + right + 1;
            } else {
                sum = sum + (left + 1) * base;
            }
            base = base * 10;
        }
        return sum;
    }
}
