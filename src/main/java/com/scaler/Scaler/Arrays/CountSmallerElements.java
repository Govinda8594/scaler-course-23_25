package com.scaler.Scaler.Arrays;

import java.util.Arrays;

//Given an array Arr of size N containing positive integers.
// Count number of smaller elements on right side of each array element.
public class CountSmallerElements {

    public static void merge(int[] arr, int[] countSmaller, int[] indices, int low, int mid, int high) {
        int[] tempIndices = new int[high - low + 1];
        int i = low, j = mid + 1, k = 0;
        int rightCount = 0;

        while (i <= mid && j <= high) {
            if (arr[indices[j]] < arr[indices[i]]) {
                tempIndices[k++] = indices[j];
                rightCount++;
                j++;
            } else {
                countSmaller[indices[i]] += rightCount;
                tempIndices[k++] = indices[i];
                i++;
            }
        }

        while (i <= mid) {
            countSmaller[indices[i]] += rightCount;
            tempIndices[k++] = indices[i];
            i++;
        }

        while (j <= high) {
            tempIndices[k++] = indices[j];
            j++;
        }

        System.arraycopy(tempIndices, 0, indices, low, high - low + 1);
    }

    public static void mergeSort(int[] arr, int[] countSmaller, int[] indices, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(arr, countSmaller, indices, low, mid);
            mergeSort(arr, countSmaller, indices, mid + 1, high);
            merge(arr, countSmaller, indices, low, mid, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 1, 2, 3, 0, 11, 4};
        int n = arr.length;
        int[] countSmaller = new int[n];
        int[] indices = new int[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        mergeSort(arr, countSmaller, indices, 0, n - 1);
        System.out.println(Arrays.toString(countSmaller));
    }
}
