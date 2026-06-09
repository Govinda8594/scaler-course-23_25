package com.scaler.Scaler.BinarySearch;

public class FindUniqueElement {

    public int searchInsert(int[] A, int B) {
        int n = A.length;
        if (n == 1) {
            return A[0];
        }
        if (A[0] != A[1]) {
            return A[0];
        }
        if (A[n - 1] != A[n - 2]) {
            return A[n - 1];
        }
        int left = 1, right = n - 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] != A[mid - 1] && A[mid] != A[mid + 1]) {
                return A[mid];
            }
            if (A[mid] == A[mid - 1]) {
                mid = mid - 1;
            }
            if (mid % 2 == 0) {
                left = mid + 2;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
