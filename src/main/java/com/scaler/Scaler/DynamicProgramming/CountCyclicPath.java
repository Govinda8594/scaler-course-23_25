package com.scaler.Scaler.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountCyclicPath {

//    The goal is to count the number of
//    valid paths of length N on a circular track with 4 positions (0 to 3), such that:
//            - You start at position 0
//            - After N steps, you end up back at position 0
//            - At each step, you can move:
//            - +1 (clockwise)
//            - +2 (opposite)
//            - +3 (counter-clockwise)
//            - All moves are modulo 4 (i.e., wrap around the circle)

    public static int countPaths(int N) {
        int mod = 1000000007;
        Map<String, Integer> memo = new HashMap<>();
        return totalPath(0, N, 0, mod, memo);
    }

    //- exponential (3^N)
    static int totalPath(int pos, int n, int step, int mod, Map<String, Integer> memo) {
//        - Stores result for (pos, step) to avoid recomputation
//                - Key format: "position,step"

        String key = pos + "," + step;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
//        - If we've taken n steps:
//                - If we're back at position 0, count this as a valid path → return 1
//                - Else → return 0

        if (step == n) {
            return pos == 0 ? 1 : 0;
        }
//        - Try all 3 possible moves from current position:
//        - Move +1 → (pos + 1) % 4
//                - Move +2 → (pos + 2) % 4
//                - Move +3 → (pos + 3) % 4
//                - Accumulate valid paths recursively

        int ans = 0;
        ans = (ans + totalPath((pos + 1) % 4, n, step + 1, mod, memo)) % mod;
        ans = (ans + totalPath((pos + 2) % 4, n, step + 1, mod, memo)) % mod;
        ans = (ans + totalPath((pos + 3) % 4, n, step + 1, mod, memo)) % mod;

        memo.put(key, ans);
        return ans;
    }

    //-  O(4 × N) → very efficient!
    public static int countPaths2(int N) {
        //code here
        int mod = 1000000007;
        int[][] dp = new int[4][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 3; j++) {
                dp[j][i] = (dp[j][i] + (dp[(j + 1) % 4][i - 1]) % mod) % mod;
                dp[j][i] = (dp[j][i] + (dp[(j + 2) % 4][i - 1]) % mod) % mod;
                dp[j][i] = (dp[j][i] + (dp[(j + 3) % 4][i - 1]) % mod) % mod;

            }
        }
        return dp[0][N];
    }
}

