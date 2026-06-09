package com.scaler.Scaler.DynamicProgramming;


//Given an integer array A of size N. Find the contiguous subarray within the given array (containing at least one number) which has the largest product.
//        Return an integer corresponding to the maximum product possible.
//        NOTE: Answer will fit in 32-bit integer value.
public class MaximumProductSubArray {


    public int maxProduct1(final int[] A) {
        int ans = Integer.MIN_VALUE, curr = 0;
        // left max for left
        for (int j : A) {
            if (curr == 0) {
                curr = 1;
            }
            curr = curr * j;
            ans = Math.max(ans, curr);
        }
        // right max for right
        int ans2 = Integer.MIN_VALUE;
        curr = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (curr == 0) {
                curr = 1;
            }
            curr = curr * A[i];
            ans2 = Math.max(ans2, curr);
        }
        return Math.max(ans2, ans);
    }

    public int maxProduct(final int[] A) {
//We need to keep track of minimum and maximum products for every iteration since we can have negative values in the given array
//We can't use Kadane's Algorithm, because it is meant for Max SubArray Sum
        int n = A.length;
        int leftmax = A[0];
        int leftmin = A[0];
        int maxans = A[0];
        for (int i = 1; i < n; i++) {
            int temp = Math.max(A[i], Math.max(leftmax * A[i], leftmin * A[i]));
            leftmin = Math.min(A[i], Math.min(leftmax * A[i], leftmin * A[i]));
            leftmax = temp;
            maxans = Math.max(maxans, temp);
        }
        return maxans;
    }

    long maxProduct2(int[] arr) {
        // code here
        long prefix = 1;
        long suffix = 1;
        int n = arr.length;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            prefix *= arr[i];
            suffix *= arr[n - i - 1];

            max = Math.max(max, Math.max(prefix, suffix));

            // Reset to 1 only if the current element is 0
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
        }
        return (int) max;
    }
}
