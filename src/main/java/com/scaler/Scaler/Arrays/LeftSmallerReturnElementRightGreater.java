package com.scaler.Scaler.Arrays;

public class LeftSmallerReturnElementRightGreater {
    public int findElement(int arr[], int n) {
        int leftMax[] = new int[n];
        int rightMin[] = new int[n];
        int result = -1;
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i - 1]);
        }
        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] >= leftMax[i] && arr[i] <= rightMin[i]) {
                result = arr[i];
                break;
            }
        }
        return result;
    }
    public int findElement2(int arr[], int n) {
        int[] rArray = new int[n];
        rArray[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rArray[i] = Math.min(rArray[i + 1], arr[i]);
        }
        int maxSum = arr[0];
        for (int i = 1; i < n - 1; i++) {
            if (maxSum <= arr[i] && arr[i] <= rArray[i + 1]) {
                return arr[i];
            }
            maxSum = Math.max(arr[i], maxSum);
        }
        return -1;
    }
}
