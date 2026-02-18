package com.scaler.Scaler.BinarySearch;

public class Find3rdOccurenceOfElement {

    public int searchInsert(int[] A, int B) {
        int left = 0, right = A.length - 1, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == B) {
                ans = mid;
                right = mid - 1;
            } else if (A[mid] < B) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (ans + 2 < A.length) {
            return ans + 1;
        }
        return -1;
    }
}
