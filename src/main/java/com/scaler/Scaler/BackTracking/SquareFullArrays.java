package com.scaler.Scaler.BackTracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
//
//        Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
public class SquareFullArrays {
    int count = 0;
    Set<String> set = new HashSet<>();

    public static void main(String[] args) {
        SquareFullArrays square = new SquareFullArrays();
        square.solve(new int[]{1, 17, 8});
    }

    public int solve(int[] A) {
        if (A.length == 1) {
            return isSquare(A[0]) ? 1 : 0;
        }
        countAllWays(0, A);
        return count;
    }

    private void countAllWays(int i, int[] A) {
        if (i == A.length) {
            if (set.add(Arrays.toString(A))) {
                count++;
            }
            return;
        }
        for (int j = i; j < A.length; j++) {
            swap(A, i, j);
            if (i == 0 || isSquare(A[i - 1] + A[i])) {
                countAllWays(i + 1, A);
            }
            swap(A, i, j);
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private boolean isSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return (sqrt * sqrt) == n;
    }
}
