package com.scaler.Scaler.Sorting;

public class SelectionSort {
    // Driver code
    public static void main(String[] args) {
        int[] arr = {23, 78, 45, 8, 32, 56, 1};
        int n = arr.length;
        minMaxOROptimizedSelectionSort(arr, n);
        System.out.printf("Sorted array:\n");
        for (int j : arr) System.out.print(j + " ");
        System.out.println("");
    }

    static void minMaxOROptimizedSelectionSort(int[] arr, int n) {
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            int min = arr[i], max = arr[i];
            int min_i = i, max_i = i;
            for (int k = i; k <= j; k++) {
                if (arr[k] > max) {
                    max = arr[k];
                    max_i = k;
                } else if (arr[k] < min) {
                    min = arr[k];
                    min_i = k;
                }
            }

            // shifting the min.
            swap(arr, i, min_i);

            // Shifting the max. The equal condition
            // happens if we shifted the max to arr[min_i]
            // in the previous swap.
            if (arr[min_i] == max)
                swap(arr, j, min_i);
            else
                swap(arr, j, max_i);
        }
    }

    //////////////////////////////////////////////////////////////////////
    static int[] selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int minVal = arr[i], minIdx = i;
            for (int j = 0; j < len; j++) {
                if (arr[j] < minVal) {
                    minIdx = j;
                    minVal = arr[j];
                }
            }
            swap(arr, i, minIdx);
        }
        return arr;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void optimizedSelectionSort(int[] arr) {
        int n = arr.length;
        for (int left = 0, right = n - 1; left < right; left++, right--) {
            int minIdx = left, maxIdx = left;

            // Find min and max in unsorted segment
            for (int j = left + 1; j <= right; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
                if (arr[j] > arr[maxIdx]) maxIdx = j;
            }

            // Place min at left
            swap(arr, left, minIdx);

            // Adjust maxIdx if swapped during min placement
            if (maxIdx == left) maxIdx = minIdx;

            // Place max at right
            swap(arr, right, maxIdx);
        }
    }

}
