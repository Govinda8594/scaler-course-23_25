package com.scaler.Scaler.Recursion;

class SumOfDigitOfNumber{
    public static void main(String[] args) {

    }

    public int solve(int A) {
        if(A==0) return 0;
        return A%10 + solve(A/10);
    }
}