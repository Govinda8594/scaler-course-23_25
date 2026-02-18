package com.scaler.Scaler.Arrays;

public class CountElements {
    public static void main(String[] args) {
//        Given an array A of N integers.
//        Count the number of elements that have at least 1 elements greater than itself.
//        A = [3, 1, 2] = 2
//        A = [5, 5, 3] =1
//        A = [6,4,6,7,2,9,3,4] = 7
    }

    public int solve(int[] A) {

        int count = 0,i = 0,max = 0,j = 0;
        while(i < A.length){
            max = Math.max(A[i],max);
            i++;
        }
        while(j < A.length){
            if(A[j] == max)
                count++;
            j++;
        }
        return A.length - count;
    }
}
