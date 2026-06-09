package com.scaler.Scaler.DynamicProgramming.FindSumPattern;

public class CheckIfExistSubsetSumIfElementPicked0TimeOrOneTime {

    static void main(String[] args) {
        int[] A = {1, 3, 5, 7, 9};
        int targetSum = 12;
        boolean[][] dp = new boolean[A.length + 1][targetSum + 1];
        boolean exists = isSubsetSum(A, A.length - 1, targetSum, dp);
        System.out.println("Subset sum of " + targetSum + " exists: " + exists);


        boolean existsDp = isSubsetSumDP(A, targetSum);
        System.out.println("Subset sum of " + targetSum + " exists: " + existsDp);
    }

    static boolean isSubsetSumDP(int[] A, int targetSum) {
        int N = A.length;
        boolean[][] dp = new boolean[N + 1][targetSum + 1];

        // Base case: sum 0 is always possible with empty subset
        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        // Fill DP table
        for (int i = 1; i <= N; i++) {
            for (int sum = 0; sum <= targetSum; sum++) {
                // Option 1: exclude current element
                dp[i][sum] = dp[i - 1][sum];

                // Option 2: include current element if it doesn't exceed sum
                if (sum >= A[i - 1]) {
                    dp[i][sum] |= dp[i - 1][sum - A[i - 1]];
                }
            }
        }

        return dp[N][targetSum];
    }

    static boolean isSubsetSum(int[] set, int index, int sum, boolean[][] memo) {
        if (index < 0) return sum == 0;

        if (memo[index][sum]) {
            return memo[index][sum];
        }

        // Option 1: Don't pick the current element
        boolean exclude = isSubsetSum(set, index - 1, sum, memo);

        // Option 2: Pick the current element (only once)
        boolean include = false;
        if (sum >= set[index]) {
            include = isSubsetSum(set, index - 1, sum - set[index], memo);
        }

        boolean result = exclude || include;
        memo[index][sum] = result;
        return result;
    }

    //CheckIfExistSubsetSumIfElementPicked0TimeOrAnNumberOfTime
    static boolean isSubsetSum2(int[] set, int index, int sum, boolean[][] memo) {
        if (index < 0) return sum == 0;

        if (memo[index][sum]) {
            return memo[index][sum];
        }

        // Option 1: Don't pick the current element
        boolean exclude = isSubsetSum(set, index - 1, sum, memo);

        // Option 2: Pick the current element (only once)
        boolean include = false;
        if (sum >= set[index]) {
            include = isSubsetSum(set, index, sum - set[index], memo);
        }

        boolean result = exclude || include;
        memo[index][sum] = result;
        return result;
    }
}
