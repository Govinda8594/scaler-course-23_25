package com.scaler.Scaler.Arrays;

public class WavePattern {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        int[][] mat = new int[][]{{2, 8, 12}, {9, 19, 4}, {15, 15, 2}};
        for (int c = 0; c < mat[0].length; c++) {
            if (c % 2 == 0) {
                for (int r = 0; r < mat.length; r++) {
                    System.out.print(mat[r][c] + " ");
                }
            } else {
                for (int r = mat.length - 1; r >= 0; r--) {
                    System.out.print(mat[r][c] + " ");
                }
            }

        }
    }
}