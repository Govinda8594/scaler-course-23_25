package com.scaler.Scaler.Arrays;

import java.util.Arrays;

public class WinnerStone {
        public int solve(int[] A) {
            Arrays.sort(A);
            int len = A.length,j = len - 1,i = j - 1;
            int[] temp = new int[(len+1)/2];
            int k = temp.length - 1;
            while(i >= 0 && j > i){
                temp[k] = A[i] ^ A[j];
                k--;
                j -= 2;
                i = j - 1;
            }
            int ans = 0;
            for(int m = temp.length-1;m >= 0;m--){
                ans ^= temp[m];
            }
            return ans;
        }

}
