package com.scaler.Scaler.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] A = {{1,2},{3,4}};
        RotateMatrixBruteforce(A);
    }

        public static int[][] RotateMatrixBruteforce(int[][] A) {
            int N = A.length;
            int temp = 0;
            // Take Transpose of matrix
            for(int row = 0;row<N-1;row++){
                for(int col = 1;col<N;col++){
                    temp = A[row][col];
                    A[row][col] = A[col][row];
                    A[col][row] = temp;
                }
            }
            // Reverse each row of the matrix.
            for(int row = 0;row<N;row++){
                int start = 0;
                int end = N -1;
                while(start<end){
                    temp = A[row][start];
                    A[row][start] = A[row][end];
                    A[row][end] = temp;
                    start++;
                    end--;

                }
            }
            return A;
        }

}
