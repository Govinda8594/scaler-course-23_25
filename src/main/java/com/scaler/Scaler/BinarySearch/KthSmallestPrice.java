package com.scaler.Scaler.BinarySearch;
//Given the price list at which tickets for a flight were purchased, figure out the kth smallest price for the flight. kth smallest price is the minimum possible n such that there are at least k price elements in the price list with value <= n. In other words, if the price list was sorted, then A[k-1] ( k is 1 based, while the array is 0 based ).
//        NOTE You are not allowed to modify the price list ( The price list is read only ). Try to do it using constant extra space.
public class KthSmallestPrice {

    public int solve(final int[] A, int B) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i: A) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        int low = min, high = max;
        while (low <= high) {
            int mid = (low + ((high - low) >> 1));
            int count = findCount(A, mid);
            if (count < B) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    int findCount(int[] A, int val) {
        int count = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] <= val) {
                count++;
            }
        }
        return count;
    }
}
