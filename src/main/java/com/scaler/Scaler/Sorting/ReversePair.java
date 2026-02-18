package com.scaler.Scaler.Sorting;
//Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
//        Return the number of important reverse pairs in the given array A.
public class ReversePair {

    public int reversePair(int[] A) {
        return mergeSort(A, 0, A.length - 1);
    }

    public int mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int left = mergeSort(A, start, mid); // sorted first half
        int right = mergeSort(A, mid + 1, end); // sorted second half

        // do reverse check b4 merging two already sorted halves
        int count = 0;
        int i = start; // left part head ptr
        int j = mid + 1; // right part head ptr
        while (i <= mid && j <= end) {
            if ((long) A[i] > (long) 2 * A[j]) {
                // since left part sorted , remain element also satisfy above condition
                count += (mid - i + 1); // remaining element of left part
                j++;
            } else {
                i++;
            }
        }
        // then merge
        merge(A, start, mid, end);
        return (left + right + count);
    }

    public void merge(int[] A, int start, int mid, int end) {
        int[] C = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        // 1. merge two sorted arrays using 2 ptr
        while (i <= mid && j <= end) {
            if (A[i] > A[j]) {
                C[k++] = A[j++];
            } else {
                C[k++] = A[i++];
            }
        }
        // 2. fill remaining elements
        while (i <= mid) {
            C[k++] = A[i++];
        }
        while (j <= end) {
            C[k++] = A[j++];
        }

        // 3. copy merged sorted array from start to end on A[]
        i = start;
        j = 0;
        while (i <= end) {
            A[i++] = C[j++];
        }
    }
}
