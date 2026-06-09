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


    public int solve(long A) {
        return isPrime(A) ? 1 : 0;
    }

    boolean isPrime(long N) {
        if(N <= 1)
            return false;
        int sqrt = (int) Math.sqrt(N);

        for (int i = 2; (long) i <= sqrt; i++) {
            if(N % i == 0)
                return false;
        }

        return true;
    }
}
