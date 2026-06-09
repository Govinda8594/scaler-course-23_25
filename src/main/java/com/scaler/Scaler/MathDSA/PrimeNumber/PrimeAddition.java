package com.scaler.Scaler.MathDSA.PrimeNumber;

public class PrimeAddition {
    //    Goldbach's conjecture states that every even integer greater than 2 can be expressed as the sum of two primes.
//
//    Bonus : This conjecture is not proven yet but verified uptil 4*10^18 integers.
//
//            And 2 is already a prime number.
    public int solve(int A) {
        //Any even number is made up of exactly addition two prime number.
//So return 2.
//Ex.24=21+3,58=53+5.

        if (A == 2) return 1;
        return 2;
    }
}
