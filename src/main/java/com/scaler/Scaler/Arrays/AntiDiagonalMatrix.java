package com.scaler.Scaler.Arrays;

import java.util.ArrayList;

public class AntiDiagonalMatrix {
//    1 2 3
//    4 5 6
//    7 8 9

//    1 0 0
//    2 4 0
//    3 5 7
//    6 8 0
//    9 0 0
    public static void main(String[] args) {
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] ans = AntiDiagonalMatrixBruteForce(A);
    }

    public static int[][] AntiDiagonalMatrixBruteForce(int[][] A) {
        int n = A.length,border = n;
        int col = A[0].length;
        int row = 2 * n - 1;
        int[][] res = new int[row][col];
        for (int resCol = 0; resCol < col; resCol++) {
            int resRow = resCol;
                int matRow = resCol,matCol = 0;
                for (int j = 0; j < border; j++) {
                    res[resRow++][resCol]=A[matRow][matCol];
                    matCol++;
                }
                matRow++;
                matCol--;
                System.out.println(resRow);
                for (int j = 0; j < border-1; j++) {
                    System.out.println(resRow);
                    res[resRow++][resCol]=A[matRow][matCol];
                    System.out.println(resRow);
                    matRow++;
                }
                border-=1;
        }
        return res;
    }
        public int[][] AntiDiagonalMatrixBruteForceOptimize(int[][] A) {
            int n = A.length;
            int col = A[0].length;
            int row = 2*n-1;
            int[][] res = new int[row][col];
            int resRow = 0;
            int resCol = 0;
            // for 0th row
            for(int j = 0; j<col; j++){
                int r = 0,c = j;
                resCol = 0;
                while(r < n && c >=0){
                    res[resRow][resCol++] = A[r][c];
                    r++;c--;
                }
                resRow++;
            }
            // from last col =>(col-1) row
            for(int i = 1; i<row; i++){
                int r = i,c = col-1;
                resCol = 0;
                while(r < n && c >=0){
                    res[resRow][resCol++] = A[r][c];
                    r++;c--;
                }
                resRow++;
            }
            return res;
        }
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        int l = A.size();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 2 * l - 1; ++i) {
            int offset = i < l ? 0 : i - l + 1;
            ArrayList<Integer> row = new ArrayList<Integer>();
            int k=0;
            for (int j = offset; j <= i - offset; ++j) {
                row.add(A.get(j).get(i - j));
                k++;
            }
            for(int j = k; j< l ;j++){
                row.add(0);
            }
            res.add(row);
        }
        return res;
    }
}
