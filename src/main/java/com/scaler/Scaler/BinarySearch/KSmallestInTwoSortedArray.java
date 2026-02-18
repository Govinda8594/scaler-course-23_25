package com.scaler.Scaler.BinarySearch;

public class KSmallestInTwoSortedArray {


    static long maxN = (long) 1e10; // the maximum value in the array possible.

    static int upperBound(int[] a, int low,
                          int high, long element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (a[middle] > element)
                high = middle;
            else
                low = middle + 1;
        }
        return low;
    }

    static long kthElement(int[] arr1, int[] arr2, int n,
                           int m, int k) {
        long left = 1, right = maxN; // The range of where ans can lie.
        long ans = (long) 1e15; // We have to find min of all
        // the ans so take .
        // using binary search to check all possible values of
        // kth element
        while (left <= right) {
            long mid = (left + right) / 2;
            long up_cnt = upperBound(arr1, 0, n, mid);
            up_cnt += upperBound(arr2, 0, m, mid);
            if (up_cnt >= k) {
                ans = Math.min(ans,
                        mid); // find the min of all answers.
                right
                        = mid - 1; // Try to find a smaller answer.
            } else
                left = mid + 1; // Current mid is too small so
            // shift right.
        }
        return ans;
    }
}
