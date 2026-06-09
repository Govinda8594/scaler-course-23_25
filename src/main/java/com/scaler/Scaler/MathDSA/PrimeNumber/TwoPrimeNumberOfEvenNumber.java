package com.scaler.Scaler.MathDSA.PrimeNumber;
//Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.
//        If there is more than one solution possible, return the lexicographically smaller solution.
//        If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
//        [a, b] < [c, d], If a < c OR a==c AND b < d.
//        NOTE: A solution will always exist. Read Goldbach's conjecture.

import java.util.Arrays;

public class TwoPrimeNumberOfEvenNumber {
    public static void main(String[] args) {
        getprimeNo(12);
    }

    static int[] getprimeNo2(int A) {
        // Seave of eratothenes
        boolean[] primeNumer = new boolean[A + 1];
        Arrays.fill(primeNumer, true);
        primeNumer[0] = primeNumer[1] = false;
        int sqrt = (int) Math.sqrt(A);
        for (int i = 2; i <= sqrt; i++) {
            if (primeNumer[i]) {
                for (int j = i * i; j <= A; j += i) {
                    primeNumer[j] = false;
                }
            }
        }
        for (int i = 2; i < primeNumer.length; i++) {
            if (primeNumer[i] && primeNumer[A - i]) {
                return new int[]{i, A - i};
            }
        }
        return new int[]{};
    }

    /////////////////////////////////////////////////////////////////////////////////////
    static int[] getprimeNo(int A) {
        int[] primeNumber = CountPrimeNumberTillN.primeNumbers2(A);
        for (int i = 0; i < primeNumber.length; i++) {
            for (int j = i; j < primeNumber.length; j++) {
                if (primeNumber[i] + primeNumber[j] == A) {
                    return new int[]{primeNumber[i], primeNumber[j]};
                }
            }
        }
        return new int[]{};
    }
}
