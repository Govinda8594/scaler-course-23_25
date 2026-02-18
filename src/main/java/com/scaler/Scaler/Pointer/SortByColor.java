package com.scaler.Scaler.Pointer;

import java.util.ArrayList;
import java.util.Arrays;
//Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//        We will represent the colors as,
//
//        red -> 0
//        white -> 1
//        blue -> 2
//
//        Note: Using the library sort function is not allowed.
public class SortByColor {
    public int[] sortColors(int[] A) {
        int[] arr = new int[3];
        int[] output = new int[A.length];
        Arrays.fill(arr, 0);
        for (int i = 0; i < A.length; i++) {
            arr[A[i]] += 1;
        }
        int k = 0;
        for (int i = 0; i < 3; i++) {
            while (arr[i] > 0) {
                output[k] = i;
                arr[i] -= 1;
                k++;
            }
        }
        return output;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<Integer> sortColors2(ArrayList<Integer> A) {
        int zero = 0;
        int two = A.size() - 1;
        for (int i = 0; i <= two; ) {
            if (A.get(i) == 0) {
                int temp = A.get(zero);
                A.set(zero, 0);
                A.set(i, temp);
                zero++;
                i++;
            } else if (A.get(i) == 2) {
                int temp = A.get(two);
                A.set(two, 2);
                A.set(i, temp);
                two--;
            } else {
                i++;
            }
        }
        return A;
    }
}
