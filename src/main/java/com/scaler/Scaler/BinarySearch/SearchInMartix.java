package com.scaler.Scaler.BinarySearch;
//Given a matrix of integers A of size N x M and an integer B. Write an efficient algorithm that searches for integer B in matrix A.
//        This matrix A has the following properties:
//        Integers in each row are sorted from left to right.
//        The first integer of each row is greater than or equal to the last integer of the previous row.
//        Return 1 if B is present in A, else return 0.
//        NOTE: Rows are numbered from top to bottom, and columns are from left to right.
public class SearchInMartix {
    public int searchMatrix(int[][] A, int B) {
        int row = A.length;
        int col = A[0].length;
        int left = 0, right = row * col - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int i = mid / col;
            int j = mid % col;
            if (A[i][j] == B) {
                return 1;
            } else if (A[i][j] < B) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

}
