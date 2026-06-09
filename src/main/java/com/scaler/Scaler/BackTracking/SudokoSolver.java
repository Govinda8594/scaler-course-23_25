package com.scaler.Scaler.BackTracking;
//
//Write a program to solve a Sudoku puzzle by filling the empty cells.
// Empty cells are indicated by the Integer 0 You may assume that there will be only one unique solution.

public class SudokoSolver {
    boolean flag = false;

    //  TC : Backing O(9!)pow9
    public static boolean solveSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') { // empty cell
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)) {
                            board[row][col] = c;
                            if (solveSudoku(board)) {
                                return true; // solved
                            }
                            board[row][col] = '.'; // backtrack
                        }
                    }
                    return false; // no valid number fits here
                }
            }
        }
        return true; // all cells filled
    }

    private static boolean isValid(char[][] board, int row, int col, char ch) {
        // Check row and column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == ch) return false;
            if (board[i][col] == ch) return false;
        }

        // Check 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[startRow + r][startCol + c] == ch) return false;
            }
        }

        return true;
    }

    static void main(String[] args) {
        SudokoSolver solver = new SudokoSolver();
        int[][] mat = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
//        solver.sudoku(mat, 0);
    }

    void sudoku(char[][] mat, int i) {
        if (i == 81) {
            // for (char[] arr : mat) {
            //     System.out.println(Arrays.toString(arr));
            // }
            flag = true;
            return;
        }

        int r = i / 9, c = i % 9;
        if (mat[r][c] != '.') {
            sudoku(mat, i + 1);

        } else {
            for (int num = 1; num <= 9; num++) {
                if (check(mat, r, c, num)) {
                    mat[r][c] = (char) num;
                    sudoku(mat, i + 1);
                    if (!flag)
                        mat[r][c] = '.'; // backtrack
                }
            }
        }
    }

    public boolean check(char[][] board, int r, int c, int num) {
        char ch = (char) num;
        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[r][j] == ch) return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == ch) return false;
        }

        // Check 3x3 subgrid
        int startRow = (r / 3) * 3; // box startRow = 0,3,6
        int startCol = (c / 3) * 3; // box Startcol = 0,3,6
        /// loop in box 3 x 3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // startRow + i,startCol + j => r
                int n = startRow + i, m = startCol + j;
                if (board[n][m] == ch) return false;
            }
        }

        return true;
    }
}
