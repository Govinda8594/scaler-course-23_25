package com.scaler.Scaler.Sorting;

public class SecondLargestElement {
    public int solve(int[] A) {
        int len = A.length;
        int second = Integer.MIN_VALUE, first = Integer.MIN_VALUE;
        for (int j : A) {
            if (first < j) {
                second = first;
                first = j;
            } else if (second < j && first != j) {
                second = j;
            }
        }
        if (second != Integer.MIN_VALUE) return second;
        return 0;
    }

}
