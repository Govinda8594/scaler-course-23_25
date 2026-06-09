package com.scaler.Scaler.BinarySearch;


//Given a matrix of integers A of size N x M in which each row is sorted.
//        Find and return the overall median of matrix A.
//        NOTE: No extra memory is allowed.
//        NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

public class MatrixMedian {

    public int findMedian(int[][] A) {
        int rowCount = A.length;
        int colCount = A[0].length;
        int reqMedian = ((rowCount * colCount) + 1) / 2;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < rowCount; i++) {
            min = Math.min(min, A[i][0]);
            max = Math.max(max, A[i][colCount - 1]);
        }

        int low = min, high = max;
        while (low <= high) {
            int mid = (low + ((high - low) >> 1));
            int count = findCount(A, mid);
            if (count < reqMedian)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    int findCount(int[][] A, int count) {
        int out = 0;
        int r = A.length;
        int c = A[0].length;
        for (int i = 0; i < r; i++) {
            int low = 0;
            int high = A[i].length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (A[i][mid] <= count) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            out += low;
        }
        return out;
    }
}
