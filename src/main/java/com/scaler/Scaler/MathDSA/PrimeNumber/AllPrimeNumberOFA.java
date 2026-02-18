package com.scaler.Scaler.MathDSA.PrimeNumber;

import java.util.ArrayList;

public class AllPrimeNumberOFA {

    public static void main(String[] args) {
        primesum(4);
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

    public static int[] primesum(int A) {
        int[] primeNo = new int[A];
        int[] ans = new int[2];
        int len = primeNo.length, j = 0;
        for (int i = 1; i <= A; i++) {
            if (isPrime(i)) {
                primeNo[j++] = i;
            }
        }
        for (int i = 0; i + 1 < len; i++) {
            if (primeNo[i] + primeNo[i + 1] == A) {
                ans[0] = primeNo[i];
                ans[1] = primeNo[i + 1];
                return ans;
            }
        }
        return ans;
    }

    Integer[] allPrimeNumber(int A) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 2; i * i <= A; i++) {
            if (A % i == 0) {
                ans.add(i);
                while (A % i == 0)
                    A = A / i;
            }
        }
        if (A != 1)
            ans.add(A);
        return (Integer[]) ans.toArray();

    }
}
