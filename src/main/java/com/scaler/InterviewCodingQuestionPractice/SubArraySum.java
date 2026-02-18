package com.scaler.InterviewCodingQuestionPractice;

public class SubArraySum {
    public static void main(String[] args) {
        int[] A = new int[]{1, -1, 2, -2};
        int ans1 = LongestSubsetWithZeroSum(A);
        int ans2 = LongestSubsetWithZeroSumOptimize(A);
        int ans = minlenSubarray(17);

    }

    public static int LongestSubsetWithZeroSum(int[] arr) {

        // Write your code here.
        int i, j, ans = 0;
        for (i = 0; i < arr.length; i++) {
            int sum = 0;
            for (j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == 0) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public static int LongestSubsetWithZeroSumOptimize(int[] arr) {

        // Write your code here.
        int i = 0, j = i, ans = 0, sum = 0;
        while (i < arr.length && j < arr.length) {
            sum += arr[j];
            if (sum == 0) {
                ans = Math.max(ans, j - i + 1);
            }
            j++;
            if (j == arr.length) {
                i++;
                j = i;
                sum = 0;
            }
        }
        return ans;
    }

    public static int minlenSubarray(int target) {
        int[] arr = {2, 3, 1, 2, 4, 3};
        // write the solution here..
        int i = 0, j = i, minlen = Integer.MAX_VALUE, sum = 0;
        while (i < arr.length && j < arr.length) {
            sum += arr[j];
            if (sum >= target)
                minlen = Math.min(minlen, j - i + 1);
            j++;
            if (j >= arr.length) {
                sum = 0;
                i++;
                j = i;
            }
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }

}
