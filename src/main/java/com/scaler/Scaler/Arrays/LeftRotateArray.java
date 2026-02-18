package com.scaler.Scaler.Arrays;

public class LeftRotateArray {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        int[] B = {2, 3, 4};
        int[][] arr = LeftRotateArrayInMatrix(A, B);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        solve(A, 9);
    }
//    Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.
//
//    Find the rotated array for each value and return the result in the from of a matrix where ith row represents the rotated array for the ith value in B.

    public static int[][] LeftRotateArrayOptimize(int[] A, int[] B) {
        int len = A.length;
        int[][] arr = new int[B.length][len];
        for (int i = 0; i < B.length; i++) {
            int[] temp = new int[len];
            for (int j = 0; j < len; j++) {
                temp[j] = A[(B[i] + j) % len];
            }
            arr[i] = temp;
        }
        return arr;
    }

    public static int[] solve(int[] A, int B) {
        int len = A.length;
        int[] ans = new int[len];
        B = B % len;
        for (int j = 0; j < len; j++) {
            ans[j] = A[(B + j) % len];
        }
        return ans;
    }

    public static int[][] LeftRotateArrayInMatrix(int[] A, int[] B) {
        int len = A.length;
        int[][] arr = new int[B.length][len];
        for (int i = 0; i < B.length; i++) {
            int k = B[i] % len;
            //adding A to ith row of arr
            System.arraycopy(A, 0, arr[i], 0, len);

            // reverse first K element
            reverse(arr[i], 0, k - 1);
            // reverse remaining k element arrray
            reverse(arr[i], k, len - 1);
            // reverse whole arrray
            reverse(arr[i], 0, len - 1);
        }
        return arr;
    }

    public static void reverse(int[] A, int i, int j) {
        while (i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            i++;
            j--;
        }
    }
}
