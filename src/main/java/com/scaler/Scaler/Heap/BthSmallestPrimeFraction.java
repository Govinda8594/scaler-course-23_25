package com.scaler.Scaler.Heap;

//Given a sorted array of integers A which contains 1 and some number of primes.
//        Then, for every p < q in the list, we consider the fraction p / q.
//        What is the B-th smallest fraction considered?
//        Return your answer as an array of integers, where answer[0] = p and answer[1] = q.


import java.util.ArrayList;
import java.util.Collections;

public class BthSmallestPrimeFraction {


    public int[] solve(int[] A, int B) {
        ArrayList<Pair> fractions = new ArrayList<>();

        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] < A[j]) {
                    float value = (float) A[i] / (float) A[j]; //type cast to get the float decimal value
                    Pair p = new Pair(A[i], A[j], value);
                    fractions.add(p);
                }
            }
        }

        Collections.sort(fractions, (p1, p2) -> {
            if (p1.value > p2.value)
                return 1;
            else if (p1.value < p2.value)
                return -1;
            return 0;
        });

        int[] result = new int[2];
        Pair output = fractions.get(B - 1);
        result[0] = output.numerator;
        result[1] = output.denominator;

        return result;
    }

    static class Pair {
        int numerator;
        int denominator;
        float value;

        Pair(int a, int b, float c) {
            numerator = a;
            denominator = b;
            value = c;
        }
    }

}
