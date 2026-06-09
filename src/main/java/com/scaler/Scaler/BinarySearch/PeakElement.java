package com.scaler.Scaler.BinarySearch;

//Given an array of integers A, find and return the peak element in it.
//        An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.
//
//        NOTE:
//
//        It is guaranteed that the array contains only a single peak element.
//        Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
public class PeakElement {
    public int solve(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        if (A[0] >= A[1]) {
            return A[0];
        }
        if (A[A.length - 1] >= A[A.length - 2]) {
            return A[A.length - 1];
        }
        int len = A.length;
        int left = 0, right = len - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] >= A[mid + 1] && A[mid] >= A[mid - 1]) {
                ans = A[mid];
            }
            if (A[mid] > A[mid - 1]) {
                left = mid + 1;
            }
            if (A[mid] < A[mid - 1]) {
                right = mid - 1;
            }
        }
        return ans;
    }
}
