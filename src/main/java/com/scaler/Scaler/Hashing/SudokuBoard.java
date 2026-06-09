package com.scaler.Scaler.Hashing;

import java.util.HashSet;
import java.util.Set;

public class SudokuBoard {
    //    TC : 9*9 +  9* 9 + 9 * 9
    public static boolean isValidSudoku(String[] A) {
        int len = A.length;
        // check row
        for (String s : A) {   // 9 row
            HashSet<String> set = new HashSet<String>();
            for (int j = 0; j < len; j++) { // 9 col
                char num = s.charAt(j);
                if (num != '.') {
                    if (!set.add(String.valueOf(num))) {
                        return false;
                    } else set.add(String.valueOf(num));
                }
            }
        }
        // check colum
        for (int i = 0; i < len; i++) {
            HashSet<String> set = new HashSet<String>();
            for (String s : A) {
                char num = s.charAt(i);
                if (num != '.') {
                    if (!set.add(String.valueOf(num))) {
                        return false;
                    } else set.add(String.valueOf(num));
                }
            }
        }
        // check box
        for (int x = 0; x < len; x += 3) {
            for (int y = 0; y < len; y += 3) {
                HashSet<String> set = new HashSet<String>();
                for (int i = x; i < x + 3; i++) {
                    for (int j = y; j < y + 3; j++) {
                        char num = A[i].charAt(j);
                        if (num != '.') {
                            if (!set.add(String.valueOf(num))) {
                                return false;
                            } else set.add(String.valueOf(num));
                        }
                    }
                }
            }
        }
        return true;
    }


    // check for validity of given sudoku board
//    TC : 9*9
    public int isValidSudoku2(final String[] A) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char currentChar = A[i].charAt(j);
                if (currentChar != '.') {
                    if (!(seen.add(currentChar + "in the row " + i)) ||
                            !(seen.add(currentChar + "in the column " + j)) ||
                            !(seen.add(currentChar + "in the box " + i / 3 + "-" + j / 3))) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    //    TC : 9*9
    public boolean isValidSudoku3(char[][] board) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> rows = new HashSet<Character>();
            HashSet<Character> columns = new HashSet<Character>();
            HashSet<Character> cube = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j]))
                    return false;
                if (board[j][i] != '.' && !columns.add(board[j][i]))
                    return false;
                int RowIndex = 3 * (i / 3);
                int ColIndex = 3 * (i % 3);
                if (board[RowIndex + j / 3][ColIndex + j % 3] != '.' && !cube.add(board[RowIndex + j / 3][ColIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }
}
