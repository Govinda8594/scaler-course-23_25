package com.scaler.Scaler.DynamicProgramming.FindSumPattern;

import java.util.Arrays;
//Given an array A of positive elements, you have to flip the sign of some of its elements such that the resultant sum of the elements of array should be minimum non-negative(as close to zero as possible).
//        Return the minimum number of elements whose sign needs to be flipped such that the resultant sum is minimum non-negative.
//        Problem Constraints
//        1 <= length of(A) <= 100
//        Sum of all the elements will not exceed 10,000.

public class MinimumElementSignNeedToflip_closetoZero {

    //  Top down => Recursion
    public long flipArray(final int[] arr, int n, int sum, long[][] dp) {
        //FlipArray(i,j) denotes minimum elements required from 0 -> 1 to make sum exactly j.
        //Base Case
        if (sum == 0) {
            return 0;
        }
        if (n == -1) {
            return arr.length + 1; //Flips cannot be more than arr.length
        }
        if (dp[n][sum] != -1) {
            return dp[n][sum];
        }
        long ans = flipArray(arr, n - 1, sum, dp); // skip
        if (sum - arr[n] >= 0) {
            ans = Math.min(flipArray(arr, n - 1, sum - arr[n], dp) + 1, ans); // flip and increase 1
        }
        dp[n][sum] = ans;
        return dp[n][sum];
    }

    public int solve1(final int[] A) {
        /*
         * Let consider an example to understand the problem
         * A:[15,10,6] totalSum = 31
         * If we flip sign of 15 to -15 we will get totalSum as -15+10+6->1 and it is closest to zero so 1
         * is the answer as only single flip is required to make it closest to zero
         * If we calculate half Sum that is 31/2 -> 15 so we have other half left as 16
         * So, we have to make our negative sum as close to 15 as possible because in that case
         * we can get negative contribution close to halfSum(negativeContribution <= halfSum) and
         * positive contribution will be left half which will be greaterThan equal to halfSum

          In the above case we have halfSum as 15 and we have to find minimum number of elements that can make
         * the sum <= halfSum i.e sum <= 15.
         * In first go it might look like a knapsack problem in which we have a capacity of bag as 15 and we have
         * to get the items with maxValue where weight is <= 15.(But the problem is knapsack talks about the maximum
         * value we can obtain and not the weight much close to 15 is a better ans)
         * Here, the question talks about minimum elements required to make sum <= halfSum which means the closer we
         * get to half Sum the answer is better.
         * For eg. if half Sum is 15 and we get possible set of answer possible as 14 or 13 or 12 in that case 14 is
         * a better ans and minimum steps required to make 14 will be the final answer
        */
        int sum = Arrays.stream(A).sum();
        int halfSum = sum / 2; //We have to take min number of elements making total sum <= halfSum
        int n = A.length;
        long[][] dp = new long[n][halfSum + 1];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = halfSum; i >= 1; --i) {
            int ans = (int) flipArray(A, n - 1, i, dp);
            if (ans <= n) {
                return ans;
            }
            //Break if we have an answer close to halfSum
        }
        return -1;
    }
    //////////////////////////////////////////////////////////////////////////////

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve3(final int[] A) {
        int sum = Arrays.stream(A).sum();
        sum = sum / 2;
        int n = A.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }
        /**
         *   Intention is to find the Minimum element to form the sum as (Total sum / 2)
         *
         *   Meaning Each cell of DP Array: For the current sum [col] and till current elements [row] what is the Minimum elements needed.
         *   Simple Knap Sack Logic
         */
//        for (int i = 1; i < dp.length; i++) {
//            int currentVal = A[i - 1];
//            for (int j = 1; j < dp[i].length; j++) {
//                if (j < currentVal) {
//                    dp[i][j] = dp[i - 1][j];
//                } else {
//                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i - 1][j - currentVal]);
//                }
//            }
//        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                int val = A[i - 1];
                if (j >= val && dp[i - 1][j - val] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j - val]);
                }
            }
        }
        // for(int[] arr : dp){
        //     System.out.println(Arrays.toString(arr));
        // }
        // If the total sum can't be make into half equal sum then look for the sum which can be made using all the values
        // by moving twards the left from the bottom right corner
        while (dp[n][sum] == Integer.MAX_VALUE) {
            sum--;
        }
        return dp[n][sum];
    }
}
