package com.scaler.Scaler.Sorting;

import java.util.Arrays;

public class SortByfactor {
    public static void main(String[] args) {
        solve(new int[]{8, 6, 9, 3, 6, 5, 1, 6, 23});
    }

    public static int getFactors(int a) {
        int factorCounter = 0;
        for (int i = 1; i * i <= a; i++) {
            if (a % i == 0) {
                if (i == a / i)
                    factorCounter++;
                else {
                    factorCounter += 2;
                }
            }
        }
        return factorCounter;
    }

    public static int[] solve(int[] A) {
        Integer[] arr = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];
        }

        Arrays.sort(arr, (a, b) -> {
            int factor_a = getFactors(a);
            int factor_b = getFactors(b);
            // a > b==> this >(greater than) expression is used to sort in descending -1
            // a<b ==> this <(less than) expression is used to sort in ascending 1
            // a == b ==> same number 0
            if (factor_a < factor_b) { // factor_a < factor_b means a should come first before b in array
                return -1;
            } else if (factor_a > factor_b) { // factor_a > factor_b means b should come first before a in array
                return 1;
            } else { // factor_a == factor_b then
                // else b should come first before a in array
                return a.compareTo(b); // element a is less then element b so a should come first before b.
            }
        });


        Arrays.sort(arr, (a, b) -> {
            int factor_a = getFactors(a);
            int factor_b = getFactors(b);
            if (factor_a == factor_b)
                return a - b;
            return factor_a - factor_b;
        });


        for (int i = 0; i < A.length; i++) {
            A[i] = arr[i];
        }

        return A;
    }
}
