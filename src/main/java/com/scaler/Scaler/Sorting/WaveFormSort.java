package com.scaler.Scaler.Sorting;

import java.util.Arrays;

public class WaveFormSort {
    public static void main(String[] args) {
//        waveSortOrder(new int[]{6,8,2,9,10});
        waveSortOrder2(new int[]{8,2,4,10,9,3,6,14,7});
    }

    static int[] waveSortOrder2(int[] A){
        for(int i=0; i<A.length - 1; i++){
            if(i % 2 == 0){
                if(A[i + 1] > A[i]){
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
            } else {
                if(A[i + 1] < A[i]){
                    int temp = A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
            }
        }
        return A;
    }


    ///////////lexographyciallly smaller sort/////
    static int[] waveSortOrder(int[] A){
        int n = A.length;
        Arrays.sort(A);
        for(int i=0;i<n-1;i+=2){
            int temp = A[i];
            A[i] = A[i+1];
            A[i+1] = temp;
        }
        return A;
    }
}
