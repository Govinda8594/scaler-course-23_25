package com.scaler.Scaler.Arrays;

import java.util.ArrayList;

public class RowToColumnZeroMatrix {


    public static void main(String[] args) {
        int[][] A = {{97, 18, 55, 1, 50, 17, 16, 0, 22, 14},
                {58, 14, 75, 54, 11, 23, 54, 95, 33, 23},
                {73, 11, 2, 80, 6, 43, 67, 82, 73, 4},
                {61, 22, 23, 68, 23, 73, 85, 91, 25, 7},
                {6, 83, 22, 81, 89, 85, 56, 43, 32, 89},
                {0, 6, 1, 69, 86, 7, 64, 5, 90, 37},
                {10, 3, 11, 33, 71, 86, 6, 56, 78, 31},
                {16, 36, 66, 90, 17, 55, 27, 26, 99, 59},
                {67, 18, 65, 68, 87, 3, 28, 52, 9, 70},
                {41, 19, 73, 5, 52, 96, 91, 10, 52, 21}};
//        int[][] A= {{1,2,3,4},
//                {5,6,7,0},
//                {9,2,0,4}};
        A = rowToColumnZeroOptimize(A);

    }

    static int[][] rowToColumnZero3(int[][] A) {
        int n = A.length, m = A[0].length;
        // row-wise iteration => make all rows values zero
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            changed = false;
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) {
                    changed = true;
                    break;
                }
            }
            if (changed) {
                for (int k = 0; k < m; k++) {
                    if (A[i][k] != 0) {
                        A[i][k] = -1;
                    }
                }
            }
        }
        // col-wise iteration make all columns values zero
        for (int i = 0; i < m; i++) {
            changed = false;
            for (int[] ints : A) {
                if (ints[i] == 0) {
                    changed = true;
                    break;
                }

            }
            if (changed) {
                for (int k = 0; k < n; k++) {
                    if (A[k][i] != 0) {
                        A[k][i] = -1;
                    }
                }
            }
        }
        // iteration over the elements of the matrix and update the values of the A[i][j] = 0 if element is -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == -1) {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }

    public static int[][] rowToColumnZeroOptimize(int[][] A) {
        int n = A.length, m = A[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 0) {
                    // marking row and column index with -1
                    row[i] = -1;
                    col[j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // so at the index of row i,j if found -1 ,set 0 to all cell
                if (row[i] == -1 || col[j] == -1) {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }

    static int[][] rowToColumnZero1(int[][] A) {
        int row = A.length, col = A[0].length;
        int[][] ans = new int[row][col];

        for (int i = 0; i < A.length; i++) {
            System.arraycopy(A[i], 0, ans[i], 0, A[0].length);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 0) {
                    for (int k = 0; k < col; k++) {
                        ans[i][k] = 0;
                    }
                    for (int k = 0; k < row; k++) {
                        ans[k][j] = 0;
                    }
                }
            }
        }
        return ans;
    }

    static int[][] rowToColumnZero2(int[][] A) {
        int row = A.length, col = A[0].length;
        ArrayList<Integer> ZeroRowIndex = new ArrayList<>();
        ArrayList<Integer> ZeroColumnIndex = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 0) {
                    ZeroRowIndex.add(i);
                    ZeroColumnIndex.add(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (ZeroRowIndex.contains(i) || ZeroColumnIndex.contains(j) && A[i][j] != 0) {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }
}
