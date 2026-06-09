package com.scaler.Scaler.MathDSA.Modulo;

//Given an array of integers A, find and return the count of divisors of each element of the array.
//        NOTE: The order of the resultant array should be the same as the input array.
public class CountOfDivisor {

    public int[] solve(int[] A) {
        int len = A.length;
        int[] arr = new int[len];
        int[] spf = new int[1000005];
        for (int i = 1; i <= 1000000; i++) {
            spf[i] = i;
        }
        for (int i = 2; i * i <= 1000000; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= 1000000; j += i) {
                    if (spf[j] == j) { // updating smallest prime Number
                        spf[j] = i;
                    }
                }
            }
        }
        for (int i = 0; i < len; i++) {
            int temp = A[i];
            int ans = 1;
            while (temp != 1) {
                int count = 1;
                int divisior = spf[temp];
                while (temp != 1 && temp % divisior == 0) {
                    count++;
                    temp /= divisior;
                }
                ans *= count;
            }
            arr[i] = ans;
        }
        return arr;
    }

    public int[] solve1(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = countFactor(A[i]);
        }
        return ans;
    }

    private static int countFactor(int N) {
        int count = 0;
        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                if (i != N / i) {
                    count += 2;
                } else {
                    count += 1;
                }
            }
        }
        return count;
    }

    public int[] solve2(int[] A) {
        //find the largest element in A
        int max = 0;
        for (int j : A) {
            if (j > max) {
                max = j;
            }
        }
        //find the spf of all the elements upto the  largest element
        int[] spf = smallprimefactor(max);
        //find the count of divisors for each element
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int total = 1;
            int n = A[i];
            while (n != 1) {
                int count = 0;
                int p = spf[n]; //spf of nth element
                while (n % p == 0) {
                    count++;
                    n = n / p;
                }
                total = total * (count + 1);
            }
            res[i] = total;
        }
        return res;
    }

    //finding spf using the sieve of Eratosthenes
    int[] smallprimefactor(int max) {
        //setting all spfs to their index
        int[] spf = new int[max + 1];
        //replacing values that are multiples with spfs
        for (int i = 0; i < spf.length; i++) {
            spf[i] = i;
        }
        for (int i = 2; i < spf.length; i++) {
            if (spf[i] == i) {
                for (int j = 2 * i; j < spf.length; j = j + i) {
                    spf[j] = Math.min(spf[j], i);
                }
            }
        }
        return spf;
    }
}
