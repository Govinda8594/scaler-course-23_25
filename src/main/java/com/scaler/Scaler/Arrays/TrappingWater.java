package com.scaler.Scaler.Arrays;
//Imagine a histogram where the bars' heights are given by the array A. Each bar is of uniform width, which is 1 unit. When it rains, water will accumulate in the valleys between the bars.
//
//Your task is to calculate the total amount of water that can be trapped in these valleys.
public class TrappingWater {
    public static void main(String[] args) {
//        int ans = totaltrappwater(new int[]{3,5,7,9,1,6,2});
//        int ans = totaltrappwater(new int[]{3,1,2,4,0,1,3,2});
        long ans = trappingWater(new int[]{3,0,0,2,0,4},6);
    }

    static int totaltrappwater(int[] A) {
        int len = A.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = A[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], A[i]);
        }
        right[len - 1] = A[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], A[i]);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += Math.min(left[i], right[i]) - A[i];
        }
        return ans;
    }

    static long trappingWater(int arr[], int n) {
        // Your code here
        int left = 0;
        int right = n - 1;
        int leftmax = 0;
        int rightmax = 0;
        long waterstore = 0;
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= leftmax) {
                    leftmax = arr[left];
                } else {
                    waterstore += Math.max(0, leftmax - arr[left]);
                }
                left++;
            } else {
                if (arr[right] >= rightmax) {
                    rightmax = arr[right];
                } else {
                    waterstore += Math.max(0, rightmax - arr[right]);
                }
                right--;
            }
        }
        return waterstore;
    }
}
