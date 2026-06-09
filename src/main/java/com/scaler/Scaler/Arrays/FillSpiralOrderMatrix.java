package com.scaler.Scaler.Arrays;

public class FillSpiralOrderMatrix {
    public static void main(String[] args) {
        FillSpiralOrderMatrix(1);
    }
        public static int[][] FillSpiralOrderMatrix(int A) {
            if(A == 1) {
                int[][] ans = new int[A][A];
                ans[0][0] = 1;
                return ans;
            }
            int[][] res = new int[A][A];
            int len = res.length;
            int rowStart = 0,colStart = 0;
            int num = 1;
            int total = A * A;
            while(num <= total){
                for(int k = 1;k < len;k++){
                    res[rowStart][colStart] = num++;
                    colStart++;
                }

                for(int k = 1;k <len;k++){
                    res[rowStart][colStart] = num++;
                    rowStart++;
                }
                for(int k = 1;k < len;k++){
                    res[rowStart][colStart] = num++;
                    colStart--;
                }

                for(int k = 1;k<len;k++){
                    res[rowStart][colStart] = num++;
                    rowStart--;
                }
                colStart++;rowStart++;
                len-=2;
            }
            return res;
        }

}
