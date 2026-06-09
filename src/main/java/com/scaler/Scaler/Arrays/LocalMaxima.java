package com.scaler.Scaler.Arrays;

public class LocalMaxima {
    public static void main(String[] args) {

    }

    static int localmaimax(int[] A){
        int len = A.length;
        if(len == 1) return A[0];
        if(A[0] > A[len-1]) return A[0];
        if(A[len-1] > A[len-2]) return A[len-1];
        int low = 1,high = len - 2;
        while (low <= high){
            int mid = (low + high) / 2;
            if(A[mid] > A[mid] - 1 && A[mid] > A[mid+1]) return A[mid];
            else if(A[mid - 1]>A[mid]){ //if element is greater on left side then go to greater side
                high = mid - 1;
            }else low = mid + 1; //if element is greater on right side then go to greater side
        }
        return -1;
    }
}
