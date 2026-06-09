package com.scaler.Scaler.Arrays;

public class SumDifferenceOnIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 5, 6, -2};

        int[] prefixSum = new int[arr.length];
        int[] suffixSum = new int[arr.length];

        prefixSum[0] = arr[0];
        suffixSum[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            if (prefixSum[i] == suffixSum[i]) {
                System.out.println(i);
            }
        }

    }

    public static int arrayEquilibriumIndexOptimize(int[] arr) {
        //Your code goes here
        int totalsum = 0;
        int leftsum = 0;

        for (int j : arr) {
            totalsum += j;
        }

        for (int i = 0; i < arr.length; i++) {
            int rightsum = totalsum - leftsum - arr[i];
            if (leftsum == rightsum)
                return i;
            leftsum += arr[i];
        }
        return -1;
    }
}
