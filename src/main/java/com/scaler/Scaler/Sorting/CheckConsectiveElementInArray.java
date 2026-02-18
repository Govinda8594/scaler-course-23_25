package com.scaler.Scaler.Sorting;

import java.util.Arrays;

public class CheckConsectiveElementInArray {
        public int solve(int[] A) {
            int len = A.length;
            Arrays.sort(A);
            for(int i = 1;i<len;i++){
                if(A[i] - A[i-1] != 1) return 0;
            }
            return 1;
        }

}
