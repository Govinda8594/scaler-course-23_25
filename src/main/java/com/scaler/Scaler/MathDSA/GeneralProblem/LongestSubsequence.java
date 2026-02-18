package com.scaler.Scaler.MathDSA.GeneralProblem;

import java.util.Arrays;

public class LongestSubsequence {

    public static void main(String[] args) {
        int[] A = new int[]{5, 4, 6, 3, 2, 2, 1, 9, 5, 7, 83};
        int ans = longestIncreasingSubsequenceOptimize(A);
    }

    public static int longestIncreasingSubsequenceOptimize(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int num : nums) {
            int index = Arrays.binarySearch(dp, 0, len, num);
            if (index < 0) {
                index = -(index + 1);
            }
            dp[index] = num;
            if (index == len) {
                len++;
            }
        }
        return len;
    }

    static int longestSubsequence(int[] A, int N) {
        int ans = 0;
        int[] dp = new int[N];
        Arrays.fill(dp, -1);
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    count = Math.max(count, dp[j]);
                }
            }
            dp[i] = count + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


}


