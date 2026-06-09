package com.scaler.Scaler.MathDSA.PrimeNumber;

import java.util.Arrays;

public class SmallestPrimeNumberOfN {
    public static void main(String[] args) {
        // N is a range of element in array[i]

        smallestPrimeFactorFrom1ToN(new int[]{20, 39, 29});
    }

    //        SPF Array
    static int[] smallestPrimeFactorFrom1ToN(int[] arr) {
        int N = Arrays.stream(arr).max().getAsInt();
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
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = smallestPrimeFactors[arr[i]];
        }
        return ans;
    }

}
