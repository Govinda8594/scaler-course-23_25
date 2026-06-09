package com.scaler.Scaler.DynamicProgramming;

import java.util.*;

//You are given an array A. You need to find the length of the Longest Increasing Subsequence in the array.
//        In other words, you need to find a subsequence of array A in which the elements are in sorted order, (strictly increasing) and as long as possible.
public class LengthofLongestIncreasingSubsequence {
    public static int LIS(int[] A) {
        // code here
        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Each element is a subsequence of length 1
        int maxLength = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    public static int LIS2(int[] H) {
        // List to store the Longest Increasing Subsequence
        List<Integer> lis = new ArrayList<>();

        for (int height : H) {
            int pos = Collections.binarySearch(lis, height);
            if (pos < 0) {
                pos = -pos - 1; // Convert to insertion point
            }
            if (pos < lis.size()) {
                lis.set(pos, height); // Replace element at position 'pos'
            } else {
                lis.add(height); // Add new element to LIS
            }
        }
        //Length of LIS
        return lis.size();
    }


    /////////////////////////////////////////////////////////////////////////////////////////////
    /*
    Now, if we choose not to pick an element, then we increase j.
Otherwise, we will have two cases.
Case I--> if the last picked element is greater than the current element, we need not have to go forward.
Case II --> if the last picked element is smaller than the current element, we can include it in
the subsequence and the length increases by one.

If at any point j equals n, then we know that we have no more elements to include or exclude, so length
does not get incremented and so we return 0.

     */
    public int lis(final int[] arr) {
        int n = arr.length;
        if (n == 1 || (n == 2 && arr[0] > arr[1]))
            return 1;
        if (n == 2 && arr[0] < arr[1])
            return 2;
        // int[] maxlen = Integer.MIN_VALUE;
        int[][] dp = new int[n][n + 1];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return getLength(n - 1, n, n, arr, dp);

    }

    int getLength(int i, int j, int n, int[] arr, int[][] dp) {
        if (i < 0) {
            return 0;
        }
        if (dp[i][j] == -1)
            return dp[i][j];
        int take = Integer.MIN_VALUE;
        int leave = getLength(i - 1, j, n, arr, dp);
        if (j == n || arr[i] < arr[j])
            take = 1 + getLength(i - 1, i, n, arr, dp);
        return dp[i][j] = Math.max(take, leave);
    }

    //////////////////////////////////////////////////////////////////////////////////

    public int findLIS3(int[] A) {
        TreeSet<Integer> ts = new TreeSet<>();
        int last = A[0];
        ts.add(A[0]);

        for (int i = 1; i < A.length; i++) {
            if (A[i] > last) {
                ts.add(A[i]);
                last = A[i];
            } else if (A[i] < last) {
                int key = ts.ceiling(A[i]);
                ts.remove(key);
                ts.add(A[i]);
                if (last == key) last = A[i];
            }
        }

        return ts.size();
    }

    //////////////////////nlogn////////////////////////////////////////////////
    int lis5(int[] A) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int j : A) {
            int low = 0, high = arr.size() - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (j > arr.get(mid))
                    low = mid + 1;
                else high = mid - 1;
            }
            if (low == arr.size())
                arr.add(j);
            else arr.set(low, j);
        }
        return arr.size();
    }
}
