package com.scaler.Scaler.MathDSA.PrimeNumber;

public class CountFactorsOfEachElement {

    public static void main(String[] args) {
        countFactors(new int[]{12, 11, 8, 6, 4, 2, 10, 9});
    }

    public static int[] countFactors(int[] A) {
        int len = A.length;
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            ans[i] = countdivisor(A[i]);
        }
        return ans;
    }

    static int countdivisor(int N) {
        int sqrt = (int) Math.sqrt(N), count = 0;
        for (int i = 1; i <= sqrt; i++) {
            if (N % i == 0) {
                count += 2;
                if (i == N / i) count -= 1;
            }

        }
        return count;
    }
}
