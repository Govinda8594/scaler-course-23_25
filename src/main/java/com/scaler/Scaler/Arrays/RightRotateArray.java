package com.scaler.Scaler.Arrays;

public class RightRotateArray {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7};
        int[] B = {2, 3, 4};
        int[][] arr = RightotateArrayInMatrixOptimize(A, B);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] RightotateArrayInMatrixOptimize(int[] A, int[] B) {
        int len = A.length;
        int[][] arr = new int[B.length][len];
        for (int i = 0; i < B.length; i++) {
            int[] temp = new int[len];
            for (int j = 0; j < len; j++) {
                temp[(j + B[i]) % len] = A[j]; //adding A to ith row of arr
            }
            arr[i] = temp;
        }
        return arr;
    }

    public static int[][] RightRotateArrayInMatrix(int[] A, int[] B) {
        int len = A.length;
        int[][] arr = new int[B.length][len];
        for (int i = 0; i < B.length; i++) {
            int k = B[i] % len;
            for (int j = 0; j < len; j++) {
                arr[i][j] = A[j]; //adding A to ith row of arr
            }
            // reverse whole arrray
            reverse(arr[i], 0, len - 1); //O(N)
            // reverse first K element
            reverse(arr[i], 0, k - 1);  // O(K)
            // reverse remaining k element arrray
            reverse(arr[i], k, len - 1);  // O(N - K)
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

    public int[] solve(int[] A, int B) {
        int len = A.length;
        int[] ans = new int[len];
        B = B % len; // handle cases where B > len

        for (int j = 0; j < len; j++) {
            ans[(j + B) % len] = A[j];
        }
        return ans;
    }

    public static int[] RightRotateArray(int[] arr, int B) {
        int len = arr.length;
        int k = B % len;
            // reverse whole arrray
            reverse(arr, 0, len - 1); //O(N)
            // reverse first K element
            reverse(arr, 0, k - 1);  // O(K)
            // reverse remaining k element arrray
            reverse(arr, k, len - 1);  // O(N - K)
        return arr;
    }
}
