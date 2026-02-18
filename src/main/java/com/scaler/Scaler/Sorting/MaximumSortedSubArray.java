package com.scaler.Scaler.Sorting;

//Given an array A of non-negative integers of size N. Find the minimum sub-array Al, Al+1 ,..., Ar such that if we sort(in ascending order) that sub-array, then the whole array should get sorted. If A is already sorted, output -1.
//
//        Note :
//        Follow 0-based indexing, while returning the sub-array's starting and ending indexes.
public class MaximumSortedSubArray {
    public int[] subUnsort(int[] A) {
        int len = A.length;
        int i = 0, j = len - 1, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, l = 0, r = len - 1;
        while (i < len - 1 && A[i] <= A[i + 1]) {
            i++;
        }
        if (i == len - 1) {
            return new int[]{-1};
        }
        while (j > 0 && A[j - 1] <= A[j]) {
            j--;
        }
        for (int k = i; k <= j; k++) {
            min = Math.min(min, A[k]);
            max = Math.max(max, A[k]);
        }
        while (l < len && A[l] <= min) {
            l++;
        }
        while (r >= 0 && A[r] >= max) {
            r--;
        }
        return new int[]{l, r};
    }
    ////////////////////////////////////////////////////////////////////////////////////////////

    public int[] subUnsort2(int[] A) {
        //there are two case here
        //1-> if input array is already sorted.
        //2-> if input array is partially sorted means there is a subarray which is not sorted
        //    and rest of the arrays is sorted.
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = A.length - 1;
        int n = A.length - 1;
        int[] result = new int[0];
        // 0 -> handle edge cases
        if (A.length == 1) {
            result = new int[1];
            result[0] = -1;
            return result;
        }
        if (A.length == 2) {
            if (A[1] >= A[0]) {
                result = new int[1];
                result[0] = -1;
                return result;
            }
        }
        // 1 -> first we have to find the index of i and j while traversing from front or back
        while (i < A.length - 1 && A[i + 1] >= A[i]) {
            i++;
        }
        while (j > 0 && A[j - 1] <= A[j]) {
            j--;
        }
        // return the result if input array is sorted
        if (i == n) {
            result = new int[1];
            result[0] = -1;
            return result;
        }
        // 2 -> now find the max and min element in the sub array A[firstIndex...., lastIndex]
        for (int k = i; k <= j; k++) {
            max = Math.max(max, A[k]);
            min = Math.min(min, A[k]);
        }
        // 3 -> a) now first traverse from front and check whether every element is smaller and equals to min element
        //      and break where your condition fails
        //      b) then traverse from back and check the condition where element is greater than max element found and
        //          break if your condition fails
        int k = 0;
        while (k < A.length && A[k] <= min) {
            k++;
        }
        // store the value of k as first index
        i = k;
        k = n;
        while (k >= 0 && A[k] >= max) {
            k--;
        }
        // store the value of k as last index
        j = k;
        // return the result
        if (i != 0 || j != 0) {
            result = new int[2];
            result[0] = i;
            result[1] = j;
        }
        return result;
    }
}
