package com.scaler.Scaler.Arrays;

public class MinimumKSizeAverage {
    public static void main(String[] args) {
        System.out.println(minmumKAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3));
    }

    static int minmumKAverage(int[] A, int B) {
        //If average is minimum then sum should also be minimum
        //Hence, we find the index with minimum sum.
        int n = A.length;
        int sum = 0;
        int index = 0;

        for (int i = 0; i < B; i++) {
            sum += A[i];
        }

        int min = sum;
        int i = 1, j = B;
        while (j < n) {
            sum = sum - A[i - 1] + A[j];
            if (sum < min) {
                min = sum;
                index = i;
            }
            i++;
            j++;
        }
        return index;
    }

}
