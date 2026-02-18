package com.scaler.Scaler.BinarySearch;

import java.util.Arrays;

public class SearchSum {
    static boolean binarySearch(int[] A, int low, int high,
                                int searchKey) {
        while (low <= high) {
            int m = low + (high - low) / 2;
            // Check if searchKey is present at mid
            if (A[m] == searchKey) {
                return true;
            }
            // If searchKey greater, ignore left half
            if (A[m] < searchKey) {
                low = m + 1;
            }
            // If searchKey is smaller, ignore right half
            else {
                high = m - 1;
            }
        }
        // if we reach here, then element was
        // not present
        return false;
    }

    public int solve(int[] A, int sum) {
        int l, r, count = 0;

        /* Sort the elements */
        Arrays.sort(A);
        // Traversing all element in an array search for
        // searchKey
        for (int i = 0; i < A.length - 1; i++) {
            int searchKey = sum - A[i];
            if (binarySearch(A, i + 1, A.length - 1,
                    searchKey)) {
                count++;
            }
        }
        return count;
    }
}
