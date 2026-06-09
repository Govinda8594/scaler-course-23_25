package com.scaler.Scaler.BinarySearch;

import java.util.Arrays;

//Given a matrix of integers A of size N x M in which each row is sorted.
//        Find and return the overall median of matrix A.
//        NOTE: No extra memory is allowed.
//        NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
public class MedianOfSortedMatrix {
    static void main(String[] args) {
        int[][] matrix2 = {{1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}};
        double median2 = findMedian(matrix2);
        System.out.println("Median of matrix2: " + median2);
    }

    public static double findMedian(int[][] matrix) {
        // Flatten the matrix into a 1D list
        int row = matrix.length, k = 0;
        int col = matrix[0].length;
        int[] list = new int[row * col + 1];
        for (int[] ints : matrix) {
            for (int j = 0; j < col; j++) {
                list[k++] = ints[j];
            }
        }

        // Sort the list
        Arrays.sort(list);

        // Find the median element
        int mid = list.length / 2;
        double median;
        if (list.length % 2 == 0) {
            median = (list[mid - 1] + list[mid]) / 2.0;
        } else {
            median = list[mid];
        }

        return median;
    }

    public static int findMedian(int[][] A, int row, int col) {
        int low = 1;
        int high = 1000000000;
        int n = row;
        int m = col;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += countSmallerThanMid(A[i], mid, col);
            }
            if (cnt <= (n * m) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int countSmallerThanMid(int[] A, int mid, int n) {
        int l = 0, h = n - 1;
        while (l <= h) {
            int md = (l + h) >> 1;
            if (A[md] <= mid) {
                l = md + 1;
            } else {
                h = md - 1;
            }
        }
        return l;
    }

    public int findMedian2(int[][] A) {
        int rowCount = A.length;
        int colCount = A[0].length;
        int reqMedian = ((rowCount * colCount) + 1) / 2;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int[] ints : A) {
            min = Math.min(min, ints[0]);
            max = Math.max(max, ints[colCount - 1]);
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
        for (int[] ints : A) {
            int low = 0;
            int high = ints.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (ints[mid] <= count) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            out += low;
        }
        return out;
    }

    int Findmedian(int[][] arr, int row, int col) {
        int[] median = new int[row * col];
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                median[index] = arr[i][j];
                index++;
            }
        }

        return median[(row * col) / 2];
    }

}
