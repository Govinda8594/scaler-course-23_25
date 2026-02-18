package com.scaler.Scaler.Arrays;

import java.util.Arrays;

public class ProductArrayPuzzle {
    public static void main(String[] args) {
        int A[] = {10, 3, 5, 6, 2};
        System.out.println(Arrays.toString(ProductArrayPuzzle(A)));
    }

        public static int[] ProductArrayPuzzle(int[] A) {
            int len = A.length;
            int prefixMul[] = new int[len];
            int suffixMul[] = new int[len];
            int ans[] = new int[len];
            prefixMul[0] = A[0];
            suffixMul[len-1] = A[len-1];
            for(int i = 1;i<len;i++){
                prefixMul[i] = prefixMul[i-1] * A[i];
            }

            for(int i = len-2;i>=0;i--){
                suffixMul[i] = suffixMul[i+1] * A[i];
            }

            for(int i = 0;i<len;i++){
                if(i == 0)
                    ans[i] = suffixMul[i+1];
                else if(i == len-1){
                    ans[i] = prefixMul[i - 1];
                }else
                    ans[i] = prefixMul[i-1] * suffixMul[i+1];
            }
            return ans;

        }

}
