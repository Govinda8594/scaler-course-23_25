package com.scaler.Scaler.Sorting;

public class MergeSort {


    static void mergesort(int[] a, int start, int end) {
        if (end < start) {
            int mid = (start + end) / 2;
            mergesort(a, start, mid);
            mergesort(a, mid + 1, end);
            if (a[mid] > a[mid + 1])
                merge(a, start, mid, end);
//        merge(a,start,mid,end);
        }
    }

    static void merge2(int[] a, int start, int mid, int end) {
        int p1 = start, p2 = mid + 1, p3 = 0;
        int[] temp = new int[end - start + 1];
        while (p1 <= mid && p2 <= end) {
            if (a[p1] <= a[p2]) {
                temp[p3++] = a[p1++];
            } else {
                temp[p3++] = a[p2++];
            }
        }

        while (p1 <= mid) {
            temp[p3++] = a[p1++];
        }
        while (p2 <= end) {
            temp[p3++] = a[p2++];
        }

        if (end + 1 - start >= 0) System.arraycopy(temp, 0, a, start, end + 1 - start);

    }

    static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= m) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];
        System.arraycopy(temp, 0, arr, l, temp.length);
    }

    void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            if (arr[m] > arr[m + 1]) merge(arr, l, m, r);
        }
    }
}
