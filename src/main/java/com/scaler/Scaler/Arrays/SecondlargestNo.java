package com.scaler.Scaler.Arrays;

import java.util.Arrays;

public class SecondlargestNo {
    public static void main(String[] args) {
    }

    public int solve(int[] A) {
        int len = A.length;
        int max, secondMax;
        max = secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (A[i] > max) {
                secondMax = max;
                max = A[i];
            } else if (A[i] > secondMax && A[i] != max) {
                secondMax = A[i];
            }
        }
        if (secondMax == Integer.MIN_VALUE) {
            return -1;
        }
        return secondMax;
    }

    // Function to print the second largest elements
    static void print2largest(int arr[], int arr_size) {
        int i, first, second;
        // There should be atleast two elements
        if (arr_size < 2) {
            System.out.printf(" Invalid Input ");
            return;
        }
        int largest = second = Integer.MIN_VALUE;
        // Find the largest element
        for (i = 0; i < arr_size; i++) {
            largest = Math.max(largest, arr[i]);
        }
        // Find the second largest element
        for (i = 0; i < arr_size; i++) {
            if (arr[i] != largest) {
                second = Math.max(second, arr[i]);
            }
        }
        if (second == Integer.MIN_VALUE) {
            System.out.printf("There is no second " +
                    "largest element\n");
        } else {
            System.out.printf("The second largest " +
                    "element is %d\n", second);
        }
    }

    public static int SecondLargestElement(int[] A) {
        Arrays.sort(A);
        int i = 0, j = A.length - 1;
        if (A.length > 1) {
            for (int k = A.length - 1; k - 1 >= 0; k--) {
                if (A[k - 1] < A[k]) {
                    return A[k - 1];
                }
            }
        }
        return -1;
    }
}
