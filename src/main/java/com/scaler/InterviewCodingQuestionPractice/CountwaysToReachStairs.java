package com.scaler.InterviewCodingQuestionPractice;

public class CountwaysToReachStairs {

        public static int countDistinctWayToClimbStairOptimize(long nStairs) {
            // Write your code here.
            int N = (int)nStairs;
            int prev2 = 1;
            int prev = 1;
            int mod = 1000000007;
            for(int i = 2;i<=N;i++){
                int curr = (prev + prev2)%mod;
                prev2 = prev;
                prev = curr;
            }
            return prev;
        }
//        Using DP and recusrion
        public int climbStairs(int A) {
            int[] dp = new int[A + 1];
            int mod = 1000000007;
            return stairs(A, dp, mod);
        }

        public int stairs(int A, int[] dp, int mod) {
            if (A == 1 || A == 2) {
                return A;
            }

            int ans = 0;
            if (dp[A] != 0) {
                ans = dp[A];
            } else {
                ans = ((stairs(A - 1, dp, mod) % mod) + (stairs(A - 2, dp, mod) % mod)) % mod;
            }

            dp[A] = ans;

            return ans;
        }
}
