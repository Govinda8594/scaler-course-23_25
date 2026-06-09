package com.scaler.Scaler.Arrays;

public class NextPermutation {
    static void main(String[] args) {
        nextPermutation(new int[]{3, 2, 5, 4, 1});
    }

    static int[] nextPermutation(int[] A) {
        int n = A.length;
        // Initialize a variable i to the second last index of the array
        int i = n - 2;
        // Find the index i such that A[i] < A[i + 1] => first samllest elment from right
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }
        // If such an i doesn't exist, reverse the array and return it=> all elemnt are in descending order
        if (i == -1) {
            reverse(A, 0, n - 1);
            return A;
        }
        // Find the largest i such that A[i] < A[j] => otherwise find largest element to right of index i
        int j = n - 1;
        while (A[i] >= A[j]) {
            j--;
        }
        // Swap A[i] and A[j]
        swap(A, i, j);
        // Reverse the subarray A[i+1...n-1]
        reverse(A, i + 1, n - 1);
        // Return the updated array
        return A;
    }

    // Define a helper method to reverse the subarray arr[i...j]
    private static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            // Swap arr[i] and arr[j]
            swap(arr, i++, j--);
        }
    }

    // Define a helper method to swap arr[i] and arr[j]
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
