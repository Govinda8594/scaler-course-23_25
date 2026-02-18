package com.scaler.Scaler.BinarySearch;

public class KthSmallestElementInMatrix {
    public static void main(String[] args) {
        KthSmallestElementInMatrix kthSmallestElementInMatrix = new KthSmallestElementInMatrix();
        int x = kthSmallestElementInMatrix.solveSortedMatrix(new int[][]{{9, 11, 15},
                {10, 15, 17}}, 2);
    }

    public int solveSortedMatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = (low + high) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int countLessEqual(int[][] matrix, int target) {
        int count = 0;
        int n = matrix.length, i = n - 1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > target) {
                i--;
            } else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }
}
