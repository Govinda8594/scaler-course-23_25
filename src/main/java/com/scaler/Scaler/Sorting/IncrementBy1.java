package com.scaler.Scaler.Sorting;

import java.util.Arrays;
//You are given an array A of N elements. You have to make all elements unique. To do so, in one step you can increase any number by one.
//        Find the minimum number of steps.
public class IncrementBy1 {
    public static void main(String[] args) {
        int values[] = {2, 5, 6, 6, 7, 8, 9, 10, 10, 13, 14, 14, 14, 14, 15, 16, 17, 18, 18, 18, 20, 21, 22, 22, 23, 23, 23, 24, 25, 26, 30};
        Arrays.sort(values);
        System.out.println(Arrays.toString(values));


    }
        public static int solve(int[] A) {
            Arrays.sort(A);
            int len = A.length;
            int count = 0;
            for (int i = 0; i < len - 1; i++) {
                if (A[i] == A[i + 1]) {
                    count = count + (A[i] - A[i + 1]) + 1;
                    A[i + 1] = A[i] + 1;
                }
            }
            return count;
        }
}
