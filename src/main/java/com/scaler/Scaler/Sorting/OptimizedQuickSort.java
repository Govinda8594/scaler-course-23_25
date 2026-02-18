package com.scaler.Scaler.Sorting;

public class OptimizedQuickSort {
    public static void threeWayQuickSort(int[] arr) {
        threeWayQuickSort(arr, 0, arr.length - 1);
    }

    private static void threeWayQuickSort(int[] arr, int low, int high) {
        if (high <= low) return;

        int lt = low, gt = high;
        int pivot = arr[low];
        int i = low;

        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }

        threeWayQuickSort(arr, low, lt - 1);
        threeWayQuickSort(arr, gt + 1, high);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}