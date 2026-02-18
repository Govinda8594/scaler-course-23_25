package com.scaler.Scaler.Sorting;

//selection sort
public class KthSmallestElement {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int kthsmallest(final int[] A, int B) {
            int len = A.length;
            for(int i= 0 ;i<len;i++){
                int minVal = A[i],minidx = i;
                for(int j = i;j<len;j++){
                    if(A[j] < minVal){
                        minVal = A[j];
                        minidx = j;
                    }
                }
                int temp = A[i];
                A[i] = A[minidx];
                A[minidx] = temp;
            }
            return A[B-1];
        }

}
