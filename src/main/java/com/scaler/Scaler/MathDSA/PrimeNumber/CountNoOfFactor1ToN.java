package com.scaler.Scaler.MathDSA.PrimeNumber;
//Given an array of integers A, find and return the count of divisors of each element of the array.
//        NOTE: The order of the resultant array should be the same as the input array.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountNoOfFactor1ToN {
    // S[x] = smallest prime factor of x
    static int[] S;
    static int NP = 1001001;

    public static void main(String[] args) {
        CountNoOfFactor1ToN(new int[]{20, 39, 29, 51, 96, 32, 35, 50, 57, 7, 59, 51, 85, 55, 8, 26, 15, 4, 4, 18, 32, 49, 40, 46, 83, 77, 100, 92});
    }

    // O(N Log log N + N(log N + Log N)) => O(N Log N)
/////////////////////////////Method 2////////////////////////////
    static int[] CountNoOfFactor1ToN(int[] arr) {
        int N = Arrays.stream(arr).max().getAsInt();
        int[] smallestfactors = smallestPrimeFactor(arr, N);
        int[] factors = new int[smallestfactors.length];
        int[] ans = new int[arr.length];
        for (int i = 1; i <= N; i++) {
            int countfactor = getCountfactor(i, smallestfactors);
            factors[i] = countfactor;
        }
        for (int i = 0; i < arr.length; i++) {
            ans[i] = factors[arr[i]];
        }
        return ans;
    }

    private static int getCountfactor(int i, int[] smallestfactors) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int x = i;
        while (x > 1) {
//                map.put(smallestfactors[x],map.getOrDefault(smallestfactors[x],1) + 1);
            if (map.containsKey(smallestfactors[x])) {
                map.put(smallestfactors[x], map.get(smallestfactors[x]) + 1);
            } else map.put(smallestfactors[x], 1);
            x = x / smallestfactors[x];
        }
        int countfactor = 1;
        for (Map.Entry<Integer, Integer> divisorFreq : map.entrySet()) {
            countfactor *= (divisorFreq.getValue() + 1);
        }
        return countfactor;
    }

    static int[] smallestPrimeFactor(int[] arr, int N) {
        int[] smallestPrimeFactors = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            smallestPrimeFactors[i] = i;
        }
        smallestPrimeFactors[0] = smallestPrimeFactors[1] = 1;
        int sqrt = (int) Math.sqrt(N);
        for (int i = 2; i <= sqrt; i++) {
            if (smallestPrimeFactors[i] == i) {
                for (int j = i * i; j <= N; j += i) {
                    if (smallestPrimeFactors[j] == j) smallestPrimeFactors[j] = i;
                }
            }
        }
        return smallestPrimeFactors;
    }
    //////////////////////////////Method 3//////////////////

    //////////////////////////////Method 1///////////////////////////
    public static int[] countFactors(int[] A) {
        int len = A.length;
        int ans[] = new int[len];

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

    public static int[] solve(int[] a) {
        sieve();
        int n = a.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = countDivisors(a[i]);
        return ans;
    }

    static void sieve() {
        int n = NP;
        S = new int[n];
        for (int i = 1; i < n; i++)
            S[i] = i;
        for (int i = 2; i * i <= n; i++) {
            if (S[i] != i)
                continue;
            for (int j = i * i; j < n; j += i) {
                if (S[j] == j)
                    S[j] = i;
            }
        }
    }

    static int countDivisors(int x) {
        // Using prime factorization to get the number of divisors for every integer
        int ans = 1;
        while (S[x] > 1) {
            int cnt = 1, u = S[x];
            while (S[x] == u) {
                cnt++;
                x /= u;
            }
            ans *= cnt;
        }
        return ans;
    }
}
