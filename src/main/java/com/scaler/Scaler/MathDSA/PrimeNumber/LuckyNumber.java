package com.scaler.Scaler.MathDSA.PrimeNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


//A lucky number is a number that has exactly 2 distinct prime divisors.
//        You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).
public class LuckyNumber {

    ///////////////////method 2///////////////////////////
    private static boolean[] isprime = new boolean[50001];

    public static void main(String[] args) {
        lucknumberOptimize(8);
//        uluckno(8);
    }

    public static int lucknumberOptimize(int A) {
        sieve();
        int[] cnt = new int[50001];
        for (int i = 0; i < 50001; i++)
            cnt[i] = 0;
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j * j <= i; j++) {
                // Check to increment count of distinct primes
                if (i % j == 0) {
                    if (isprime[j]) {
                        cnt[i]++;
                    }
                    if ((i / j) != j && isprime[i / j]) {
                        cnt[i]++;
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= A; i++) {
            // Increment count for every lucky num
            if (cnt[i] == 2) {
                ans++;
            }
        }
        return ans;
    }

    public static void sieve() {
        //Sieve of Eratosthenes
        for (int i = 0; i < 50001; i++)
            isprime[i] = true;
        isprime[1] = false;
        for (long i = 2; i <= 50000; i++) {
            if (isprime[(int) i]) {
                for (long j = i * i; j <= 50000; j += i) {
                    isprime[(int) j] = false;
                }
            }
        }
    }

    ///////////////////Method 3///////////////////////////
    public static int uluckno(int A) {
        //Modification of Sieve of Erastothenes Algorithm
        int[] isPrimeSieve = new int[A + 1];
        for (int p = 2; p <= A; p++) {
            //Only Prime
            if (isPrimeSieve[p] == 0) {
                //This will give an array consisting of number of prime divisors for each number
                for (int i = p; i <= A; i += p) {
                    isPrimeSieve[i] += 1;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= A; i++) {
            if (isPrimeSieve[i] == 2) {
                count++;
            }
        }
        return count;
    }

    ///////////////////method 1///////////////////////
    static int getluckyNo(int A) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int N = 0; N <= A; N++) {
            ArrayList<Integer> factors = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (N % i == 0) {
                    factors.add(i);
                }
            }
            map.put(N, factors);
        }
        int ans = 0, val = 0;
        for (Map.Entry<Integer, ArrayList<Integer>> factor : map.entrySet()) {
            int count = 0;
            for (Integer num : factor.getValue()) {
                if (PrimeNumber.CountFactor_for_Prime(num)) {
                    count++;
                }
            }
            if (count == 2) {
                ans = factor.getKey();
                val++;
            }
        }
        return val;
    }
}
