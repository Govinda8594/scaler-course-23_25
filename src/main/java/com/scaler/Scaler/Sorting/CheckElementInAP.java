package com.scaler.Scaler.Sorting;

import java.util.Arrays;

public class CheckElementInAP {
    public static void main(String[] args) {
        getArrange(new int[]{2, 4, 1});
    }

    static int getArrange(int[] A){
        int len = A.length;
        Arrays.sort(A);
        for(int i = 1; i+1 < len; i++){
            if(A[i]-A[i-1] != A[i+1] - A[i])
                return 0;
        }
        return 1;
    }
}
