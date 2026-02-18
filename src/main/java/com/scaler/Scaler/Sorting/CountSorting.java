package com.scaler.Scaler.Sorting;

import java.util.Arrays;

public class CountSorting {
    public static void main(String[] args) {
        countsorting(new int[]{1, 1, 3});
    }

    static int[] countsorting(int[] A) {
        int len = A.length, maxrange = 0, i;
        // count sort algorithm depend on max range(elements) of array
        // and count the frequencies of elements and sort at the index in count array
        // and then iterate over the count array for each frequency
        for (i = 0; i < len; i++) {
            maxrange = Math.max(maxrange, A[i]);
        }
        int[] result = new int[maxrange];

        for (i = 0; i < len; i++) {
            result[A[i] - 1]++;
        }
        int k = 0;
        i = 0;
        while (k < len) {
            if (result[i] > 0) {
                A[k] = i + 1;
                result[i]--;
                k++;
            } else i++;
        }
        return A;
    }

    void countingSort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range], output = new int[arr.length];
        for (int num : arr) count[num - min]++;
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
