package com.scaler.Scaler.Arrays;

public class KthSmallestElementINTwoSortedArray {

    // Driver Code
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;
        System.out.print(kth(arr1, arr2, 5, 4, k));
    }

    // if array is sorted
    static int kth(int[] arr1, int[] arr2, int m, int n, int k) {
        int[] sorted1 = new int[m + n];
        int i = 0, j = 0, d = 0;
        while (i < m && j < n) {
            if (arr1[i] < arr2[j])
                sorted1[d++] = arr1[i++];
            else
                sorted1[d++] = arr2[j++];
        }
        while (i < m)
            sorted1[d++] = arr1[i++];
        while (j < n)
            sorted1[d++] = arr2[j++];
        return sorted1[k - 1];
    }


    public static int find(int[] A, int[] B, int m, int n,
                           int k_req) {
        if (k_req < 1 || k_req > (m + n)) return -1;
        int k = 0, i = 0, j = 0;
        // Keep taking smaller of the current
        // elements of two sorted arrays and
        // keep incrementing k
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                k++;
                if (k == k_req)
                    return A[i];
                i++;
            } else {
                k++;
                if (k == k_req)
                    return B[j];
                j++;
            }
        }
        // If array B[] is completely traversed
        while (i < m) {
            k++;
            if (k == k_req)
                return A[i];
            i++;
        }
        // If array A[] is completely traversed
        while (j < n) {
            k++;
            if (k == k_req)
                return B[j];
            j++;
        }
        return -1;
    }

    public static int getKthElementMerge(int[] a, int[] b, int k) {
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (i + j == k - 1) {
                return Math.min(a[i], b[j]);
            }

            if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }

        // If one array is exhausted
        if (i < a.length) {
            return a[k - j - 1];
        } else {
            return b[k - i - 1];
        }
    }
}
