package com.scaler.Scaler.Strings;

public class CountSort {

    public int[] solve(int[] A) {
        int size = A.length;
        int[] output = new int[size + 1];

        // Find the largest element of the array
        int max = A[0];
        for (int i = 1; i < size; i++) {
            if (A[i] > max)
                max = A[i];
        }
        int[] count = new int[max + 1];

        // Initialize count array with all zeros.
        for (int i = 0; i < max; ++i) {
            count[i] = 0;
        }

        // Store the count of each element
        for (int i = 0; i < size; i++) {
            count[A[i]]++;
        }

        // Store the cummulative count of each array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in count array, and
        // place the elements in output array
        for (int i = size - 1; i >= 0; i--) {
            output[count[A[i]] - 1] = A[i];
            count[A[i]]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < size; i++) {
            A[i] = output[i];
        }
        return A;
    }
    public int[] solve1(int[] A) {
    int len = A.length,maxrange = 0, i;
        for(i = 0; i < len; i++){
            maxrange = Math.max(maxrange,A[i]);
        }
        int[] result = new int[maxrange];

        for(i = 0; i < len; i++){
            result[A[i]-1]++;
        }
        int k = 0;
        i =0;
        while(k < len) {
            if (result[i] > 0) {
                A[k] = i + 1;
                result[i]--;
                k++;
            } else {
                i++;
            }
        }
        return A;
}
}