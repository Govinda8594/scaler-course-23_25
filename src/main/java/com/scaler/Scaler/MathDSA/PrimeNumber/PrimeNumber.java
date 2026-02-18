package com.scaler.Scaler.MathDSA.PrimeNumber;

public class PrimeNumber {

    static boolean CountFactor_for_Prime(int N) {
        int count = 0, sqrt = (int) Math.sqrt(N);
        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                count += 2;
                if (i == N / i)
                    count -= 1;
            }
        }
        return count == 2;
    }

    static boolean isPrime(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) {
                count++;
            }
        }
        return count == 2;
    }


    public int solve(Long A) {
        if (A == 1 || A == 0) {
            return 0;
        } else {
            int sqrt = (int) Math.sqrt(A);
            for (int i = 2; i <= sqrt; ++i) {
                if (A % i == 0) {
                    return 0;
                }
            }
            return 1;
        }
    }
}
