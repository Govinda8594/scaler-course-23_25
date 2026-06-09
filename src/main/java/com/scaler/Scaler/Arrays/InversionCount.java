package com.scaler.Scaler.Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class InversionCount {
    // Driver code
    public static void main(String[] args) {
//        int[] arr = {1, 20, 6, 4, 5};
        int[] arr = {3, 4, 1, 2};
        System.out.println(
                mergeSortAndCount(arr, 0, arr.length - 1));
        solve(new int[]{1, 20, 6, 4, 5});
    }

    // Function to count the number of inversions
    // during the merge process
    private static int mergeAndCount(int[] arr, int l,
                                     int m, int r) {
        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);
        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0, j = 0, k = l, swaps = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }

    // Merge sort function
    private static int mergeSortAndCount(int[] arr, int l,
                                         int r) {
        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;
        if (l < r) {
            int m = (l + r) / 2;
            // Total inversion count = left subarray count
            // + right subarray count + merge count
            // Left subarray count
            count += mergeSortAndCount(arr, l, m);
            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);
            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    public static int solve1(int[] A) {
        int len = A.length, i = 0, j = len - 1, count = 0;
        int mod = 1000000007;
        while (j >= 0) {
            if (i < j) {
                if (A[i] > A[j]) {
                    count++;
                }
            }
            j--;
            if (j == i) {
                i++;
                j = len - 1;
            }
        }
        return count % mod;
    }

    public static int solve(int[] A) {
        int len = A.length, i = 0, j = 1, count = 0;
        int mod = 1000000007;
        Integer[] ele = Arrays.stream(A).boxed().toArray(Integer[]::new);
        Arrays.sort(ele, Comparator.reverseOrder());
        while (j < len) {
            if (i < j) {
                if (ele[i] > ele[j]) {
                    count++;
                }
            }
            j++;
            if (j == len) {
                i++;
                j = i + 1;
            }
        }
        return count % mod;
    }
}
