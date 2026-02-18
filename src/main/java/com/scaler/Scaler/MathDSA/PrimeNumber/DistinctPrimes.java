package com.scaler.Scaler.MathDSA.PrimeNumber;

import java.util.HashSet;
import java.util.Set;

//You have given an array A having N integers. Let say G is the product of all elements of A.
//
//        You have to find the number of distinct prime divisors of G.
public class DistinctPrimes {
    public static void main(String[] args) {
        CountDistinctPrimeDivior(new int[]{50, 25, 2, 97, 89, 13, 47, 63, 40, 9, 82, 90, 51, 96, 43, 53, 5, 13, 15, 31, 52, 59, 65, 43, 62, 74, 46, 78, 7, 61});
    }

    ///////////////////Method 1////////////////////////
    public static int CountDistinctPrimeDivior(int[] A) {
        int n = A.length;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int k : A) {
            int temp = k;
            for (int j = 2; j * j <= temp; j++) {
                if (temp % j == 0) {
                    set.add(j);
                    while (temp % j == 0)
                        temp /= j;
                }
            }
            if (temp > 1)
                set.add(temp);
        }

        return set.size();
    }
}
