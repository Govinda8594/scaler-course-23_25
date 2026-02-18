package com.scaler.Scaler.Sorting;

public class RandomizQuickSort {

    public int[] solve(int[] A) {
        quickSort(A, 0, A.length-1);
        return A;
    }
        public int rearrange(int[] A, int start, int end){
            // selecting random index from the array
            int rnd = (int)(Math.random()*(end-start+1)+start);
            // swap A[start] and A[rnd]
            swap(A, start, rnd);
            int p1 = start+1, p2 = end;
            // sending A[start] to its right position
            while(p1 <= p2){
                if(A[p1] <= A[start]) // p1 is happy
                    p1++;
                else if(A[p2] > A[start]) // p2 is happy
                    p2--;
                else{ // both p1 and p2 are unhappy
                    swap(A, p1, p2);
                    p1++; p2--;
                }
            }
            // swap A[start] and A[p2]
            swap(A, start, p2);
            return p2;
        }
        public void quickSort(int[] A, int start, int end){
            if(start >= end) return;
            int pivotElement = rearrange(A, start, end);
            quickSort(A, start, pivotElement-1);
            quickSort(A, pivotElement+1, end);
        }

    public static void swap(int[] arr, int a, int b) {
        if (a==b) return;
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
