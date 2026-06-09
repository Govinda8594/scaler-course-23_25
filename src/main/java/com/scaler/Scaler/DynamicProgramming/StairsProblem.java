package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//You are climbing a staircase and it takes A steps to reach the top.
//        Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//        Return the number of distinct ways modulo 1000000007
public class StairsProblem {
    public int mod = 1000 * 1000 * 1000 + 7;

    /*
    Imagine filling the n stairs with 1 and 2 step climbs. In the worst case, you can only use 2 step climbs (y) - which would be n/2 (assuming n is even) - leaving you with 1 step climb (x) at the end. This gives a minimum of n/2 + 1 combinations (since you can have more 1 step climbs than the minimum).

However, this is just an intuitive explanation. The formula (n/2 + 1) considers all possible combinations of 1 and 2 step climbs, providing the exact number of ways to reach the top stair.
     */
    Long countWays(int n) {
        // your code here
        return (long) (n / 2 + 1);
    }

    // Approach 4: Iterative bottom - up approach => DP Tabulation + space optimization
    public int climbStairs2(int A) {
        int a = 1, b = 1, res = 1;
        for (int i = 1; i < A; i++) {
            res = (a + b) % 1000000007;
            a = b;
            b = res;
        }
        return res;
    }

    // Approach 3: Iterative + Memory tabulation Approach
    public int climbStairs3(int A) {
        int ways[] = new int[A + 1]; // ways[i] denotes the number of ways to reach the i'th step.
        if (A == 1) {
            return 1;
        }
        ways[1] = 1;
        ways[2] = 2;
        for (int i = 3; i <= A; i++) {
            ways[i] = (ways[i - 1] + ways[i - 2]) % mod;
        }
        return ways[A];
    }

    public int climbStairsWithMemoize(int A) {
        // Approach 2:Dp +  Recursive with Memory(Memoize) Top Down Approach
        int[] arr = new int[A + 1];
        Arrays.fill(arr, -1);
        return climbStairsWithMemoize(A, arr);
    }

    public int climbStairsWithMemoize(int n, int[] arr) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (arr[n] == -1) {
            arr[n] = (climbStairsWithMemoize(n - 1, arr) % mod + climbStairsWithMemoize(n - 2, arr) % mod) % mod;
            // return arr[n];
        }
        return arr[n];
    }

    public int climbStairs(int A) {
// Approach 1: Recursive Approach
        if (A == 1) {
            return 1;
        }
        if (A == 2) {
            return 2;
        }
        if (A == 0) {
            return 0;
        }
        return (climbStairs(A - 1) % 1000000007 + climbStairs(A - 2) % 1000000007) % 1000000007;
    }
}
