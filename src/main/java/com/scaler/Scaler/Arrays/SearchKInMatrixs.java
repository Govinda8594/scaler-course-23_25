package com.scaler.Scaler.Arrays;

public class SearchKInMatrixs {
    public static void main(String[] args) {

    }

    static boolean findKElementt(int[][] matrix,int k){
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col - 1;
        while(i < row && j >= 0){
            if(matrix[i][j] < k)
                i++;
            else if(matrix[i][j] > k)
                j--;
            else return true;
        }
        return false;
    }
}
