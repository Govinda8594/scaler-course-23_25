package com.scaler.Scaler.Arrays;

public class SudokoSolver {

    static private boolean solve(int[][] matrix, int i, int j) {
        int n = matrix.length;
        if (i == n - 1 && j == n) {
            return isValid(matrix);
        }
        if (j == n) {
            i++;
            j = 0;
        }
        if (matrix[i][j] != 0) {
            return solve(matrix, i, j + 1);
        }
        for (int digit = 1; digit <= n; digit++) {
            matrix[i][j] = digit;
            if (solve(matrix, i, j + 1)) {
                return true;
            }
            matrix[i][j] = 0;
        }
        return false;
    }

    public static boolean isItSudoku1(int[][] matrix) {
        return solve(matrix, 0, 0);
    }

    static private boolean isValid(int[][] matrix) {
        int n = matrix.length;
        int[][] row = new int[n][n + 1];
        int[][] column = new int[n][n + 1];
        int[][][] subMatrix = new int[3][3][n + 1];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    continue;
                }
                row[r][matrix[r][c]] += 1;
                column[c][matrix[r][c]] += 1;
                subMatrix[r / 3][c / 3][matrix[r][c]] += 1;
                if (subMatrix[r / 3][c / 3][matrix[r][c]] > 1 || column[c][matrix[r][c]] > 1 ||
                        row[r][matrix[r][c]] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid2(char[][] board) {
        // Use three boolean arrays to check rows, columns, and 3x3 grids.
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] gridCheck = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char key = board[i][j];
                if (key != '.') {
                    int num = key - '1'; // Convert character to integer (0-8)
                    int gridIndex = (i / 3) * 3 + (j / 3); // Calculate 3x3 grid index
                    // Check if the same number is already in the current row, column, or grid.
                    if (rowCheck[i][num] || colCheck[j][num] || gridCheck[gridIndex][num]) {
                        return false;
                    }
                    // Mark the number as seen in the current row, column, and grid.
                    rowCheck[i][num] = true;
                    colCheck[j][num] = true;
                    gridCheck[gridIndex][num] = true;
                }
            }
        }
        return true;
    }
}
