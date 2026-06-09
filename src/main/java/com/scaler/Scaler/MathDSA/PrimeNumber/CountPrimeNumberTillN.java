package com.scaler.Scaler.MathDSA.PrimeNumber;

import java.util.ArrayList;
import java.util.Arrays;

import static com.scaler.Scaler.MathDSA.PrimeNumber.PrimeNumber.isPrime;

public class CountPrimeNumberTillN {
    public static void main(String[] args) {

    }

    static int[] primeNumbers2(int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Seave of eratothenes
        boolean[] primeNumer = new boolean[N + 1];
        Arrays.fill(primeNumer, true);
        primeNumer[0] = primeNumer[1] = false;
        int sqrt = (int) Math.sqrt(N);
//        N log(logN)
        for (int i = 2; i <= sqrt; i++) {
            if (primeNumer[i]) {
                for (int j = i * i; j <= N; j += i) {
                    primeNumer[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (primeNumer[i]) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    static int[] primeNumbers1(int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        // Seave of eratothenes
        boolean[] primeNumer = new boolean[N + 1];
        Arrays.fill(primeNumer, true);
        primeNumer[0] = primeNumer[1] = false;
        for (int i = 2; i <= N; i++) {
            if (primeNumer[i]) {
                for (int j = 2 * i; j <= N; j += i) {
                    primeNumer[j] = false;
                }
            }
        }

        for (int i = 2; i <= N; i++) {
            if (primeNumer[i]) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    //    O(N Square root of N)
    static int[] primeNumbers(int N) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (isPrime(i)) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
