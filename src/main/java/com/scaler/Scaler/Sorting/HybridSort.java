package com.scaler.Scaler.Sorting;

public class HybridSort {
    private static final int THRESHOLD = 32;

    public static void hybridSort(int[] arr) {
        hybridSort(arr, 0, arr.length - 1);
    }

    private static void hybridSort(int[] arr, int left, int right) {
        // Use insertion sort for small arrays
        if (right - left <= THRESHOLD) {
            insertionSort(arr, left, right);
            return;
        }

        // Use quicksort for larger arrays
        if (left < right) {
            int pivot = partition(arr, left, right);
            hybridSort(arr, left, pivot - 1);
            hybridSort(arr, pivot + 1, right);
        }
    }

    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}