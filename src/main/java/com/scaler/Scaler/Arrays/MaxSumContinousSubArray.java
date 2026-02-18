package com.scaler.Scaler.Arrays;

public class MaxSumContinousSubArray {
    public static void main(String[] args) {
        maxSubArray(new int[]{-1, -3, -4, -6});
    }

    public static int maxSubArraykadane(final int[] A) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int j : A) {
            sum += j;
            ans = Math.max(ans, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }

    public static int maxSubArray(final int[] A) {
        int len = A.length;
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += A[j];
                maxsum = Math.max(maxsum, sum);
            }
        }
        return maxsum;
    }
}
