package com.scaler.Scaler.MathDSA.GeneralProblem;

public class CountPrimeNo {


    public static void main(String[] args) {
        int A = 23;
        System.out.println(OptimizePrimeCheckCount(A));
    }

    public static int OptimizePrimeCheckCount(int num) {
        int count = 0;
        for (int A = 2; A <= num; A++) {
            boolean isPrime = true;
            for (int i = 2; i <= A / 2; i++) {
                if (A % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }
        }
        return count;
    }

    int solve(int A) {
        int countFactor = 0, sqrt = 0, primNoCount = 0;
        for (int i = 2; i <= A; i++) {
            sqrt = (int) Math.sqrt(i);
            countFactor = 0;
            for (int j = 1; j <= sqrt; j++) {
                if (i % j == 0 && j * j != i) {
                    countFactor += 2;
                } else if (j * j == i)
                    countFactor++;
            }
            if (countFactor == 2)
                primNoCount++;
        }
        return primNoCount;
    }
}
