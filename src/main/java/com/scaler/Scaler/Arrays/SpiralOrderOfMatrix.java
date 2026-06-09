package com.scaler.Scaler.Arrays;

public class SpiralOrderOfMatrix {
    public int[][] generateMatrix(int A) {
        int rowStart = 0,rowEnd = A - 1;
        int colStart = 0,colEnd = A - 1;
        int num = 1;
        int total = A * A;
        int[][] res = new int[A][A];
        while(num <= total){
            for(int col = colStart;col <= colEnd;col++){
                res[rowStart][col] = num++;
            }

            for(int row = rowStart + 1;row <= rowEnd;row++){
                res[row][colEnd] = num++;
            }
            for(int col = colEnd - 1;col >= colStart;col--){
                if(rowStart == rowEnd)
                    break;
                res[rowEnd][col] = num++;
            }

            for(int row = rowEnd - 1;row >= rowStart + 1;row--){
                if(colStart == colEnd)
                    break;
                res[row][colStart] = num++;
            }
            colStart++;rowStart++;
            colEnd--;rowEnd--;
        }
        return res;
    }
}
