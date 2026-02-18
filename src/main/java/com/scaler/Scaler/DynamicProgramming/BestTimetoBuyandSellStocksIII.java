package com.scaler.Scaler.DynamicProgramming;

import java.util.Arrays;

//Say you have an array, A, for which the ith element is the price of a given stock on day i.
//        Design an algorithm to find the maximum profit. You may complete at most 2 transactions.
//        Return the maximum possible profit.
//        Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//        Input Format:
//        The first and the only argument is an integer array, A.
//        Output Format:
//        Return an integer, representing the maximum possible profit.
//        Constraints:
//        1 <= length(A) <= 7e5
//        1 <= A[i] <= 1e7
//        Examples:

public class BestTimetoBuyandSellStocksIII {
    public int maxProfit2(final int[] A) {
        int firstBuy = Integer.MAX_VALUE;
        int secondBuy = Integer.MAX_VALUE;
        int firstSell = 0;
        int secondSell = 0;
        int ans = 0;
        for (int stock : A) {
            firstBuy = Math.min(stock, firstBuy);
            firstSell = Math.max(firstSell, stock - firstBuy);
            secondBuy = Math.min(secondBuy, stock - firstSell);
            secondSell = Math.max(secondSell, stock - secondBuy);
            ans = Math.max(firstSell, secondSell);
        }
        return ans;
    }
    /////////////////Simple Divide & Conquer ///////////////////////////////////////////////////////////

    public int maxProfit1(final int[] A) {
        int n = A.length;
        if (n <= 1) {
            return 0;
        } else if (n == 2 && A[1] > A[0]) {
            return A[1] - A[0];
        }
        int min = A[0];
        int max = A[n - 1];
        int ans = 0;
        int[] leftProfit = new int[n];
        leftProfit[0] = 0;
        for (int i = 1; i < n; i++) {
            min = Math.min(A[i], min);
            leftProfit[i] = Math.max(leftProfit[i - 1], A[i] - min);
        }
        int[] rightProfit = new int[n];
        rightProfit[n - 1] = 0;
        for (int j = n - 2; j >= 0; j--) {
            max = Math.max(max, A[j]);
            rightProfit[j] = Math.max(rightProfit[j + 1], max - A[j]);
            ans = Math.max(ans, leftProfit[j] + rightProfit[j + 1]);
        }
        return ans;
    }

    //    1. Recursive Solution
    int solveRec(int[] A, int index, int buy_flag, int trax_limt) {
        // Base Case_1 :: When reach at end of Array, you can't genrate any profit from here
        if (index == A.length) {
            return 0;
        }
        // Base Case_2 :: When Transaction reduces to "0", i.e no more Transaction left to do,you can't generate profit anymore
        if (trax_limt == 0) {
            return 0;
        }
        int profit = 0;
        // If you are allowed to buy, i.e buy_flag = 1
        if (buy_flag == 1) {
            // You have now 2 choices : Buy karo OR ignore/Skip karo
            // 1st choice :: Buy it
            int buy = solveRec(A, index + 1, 0, trax_limt) - A[index];
            // 2nd choice :: skip karo
            int skipBuy = solveRec(A, index + 1, 1, trax_limt);
            // To Maximize profit take max of both choices
            profit = Math.max(buy, skipBuy);
        }
        // else If your are not allowed to buy, i.e buy_flag = 0
        else {
            // You have now 2 choices : Sell karo OR ignore/Skip karo
            // 1st choice :: Sell karo
            int sell = solveRec(A, index + 1, 1, trax_limt - 1) + A[index];
            // 2nd choice :: skip karo
            int skipSell = solveRec(A, index + 1, 0, trax_limt);
            // To Maximize profit take max of both choices
            profit = Math.max(sell, skipSell);
        }
        // return maximized Profit
        return profit;
    }

    int maxProfit(int[] A) {
        return solveRec(A, 0, 1, 2);
    }
/*
TC = O(2^N), Every day, We have two choices: Buy/Sell this stock OR ignore it and move to the next one [We just added one more param to all recursive calls "trax_limt"] 
Result:
> TestCase - Easy Failed
Time Limit Exceeded
SC = O(N), Max Depth of recursion tree
*/

    //2. DP solution using Recursion + Memoization
    int solveMem(int[] prices, int idx, int buy_flag, int buffer, int[][][] DP_mem) {
        // Base Case_1 :: When reach at end of Array, you can't genrate any profit from here
        if (idx == prices.length) {
            return 0;
        }
        // Base case_2 :: when limit reaches to "0" from here we can't make any transaction from here
        if (buffer == 0) {
            return 0;
        }
        int profit = 0;
        if (DP_mem[idx][buy_flag][buffer] == -1) {
            // If you are allowed to buy, i.e buy_flag = 1;
            if (buy_flag == 1) {
                // You have now 2 choices : Buy karo OR ignore/Skip karo
                // 1st choice :: Buy it
                int buy = solveMem(prices, idx + 1, 0, buffer, DP_mem) - prices[idx];
                // 2nd choice :: skip karo
                int skipBuy = solveMem(prices, idx + 1, 1, buffer, DP_mem);
                // To Maximize profit take max of both choices
                profit = Math.max(buy, skipBuy);
            }
            // else If your are not allowed to buy, i.e buy_flag = 0;
            else {
                // You have now 2 choices : Sell karo OR ignore/Skip karo
                // 1st choice :: Sell karo
                int sell = prices[idx] + solveMem(prices, idx + 1, 1, buffer - 1, DP_mem);
                // 2nd choice :: skip karo
                int skipSell = solveMem(prices, idx + 1, 0, buffer, DP_mem);
                // To Maximize profit take max of both choices
                profit = Math.max(sell, skipSell);
            }
            DP_mem[idx][buy_flag][buffer] = profit;
        }
        // return maximized Profit
        return DP_mem[idx][buy_flag][buffer];
    }

    int maxProfit5(int[] A) {
        int N = A.length;
        // Create DP array/Matrix :: 3D DP
        int[][][] DP_mem = new int[N][2][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(DP_mem[i][j], -1);
            }
        }
        // Memoization function call
        return solveMem(A, 0, 1, 2, DP_mem);
    }
/*
Recursion + Memoization
TC = O((N*2*3)){No of Dp states(size of DP array) i.e Unique subproblems} * O(1){Time taken to process each DP state}
   = O(N)
SC = O(N*2*3){Space occupied by DP array} + O(N){recursive stack space}
   = O(N) = O(N)
Result:
    > TestCase - Hard Failed
      Memory Limit Exceeded
*/

    //3. DP Solution Using Tabulation
    int solveTab(int[] A) {
        int N = A.length;
        // Create DP array/Matrix :: 3D DP
        int[][][] DP_tab = new int[N + 1][2][3];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(DP_tab[i][j], 0);
            }
        }
        for (int idx = N - 1; idx >= 0; idx--) {
            for (int buy_flag = 0; buy_flag <= 1; buy_flag++) {
                // we already handled case when "trax_limt == 0" hence starting from "1" here
                for (int trax_limt = 1; trax_limt <= 2; trax_limt++) {
                    int profit = 0;
                    // If you are allowed to buy, i.e buy_flag = 1
                    if (buy_flag == 1) {
                        int buy = DP_tab[idx + 1][0][trax_limt] - A[idx];
                        int skipBuy = DP_tab[idx + 1][1][trax_limt];
                        profit = Math.max(buy, skipBuy);
                    }
                    // else If your are not allowed to buy, i.e buy_flag = 0
                    else {
                        int sell = A[idx] + DP_tab[idx + 1][1][trax_limt - 1];
                        int skipSell = DP_tab[idx + 1][0][trax_limt];
                        profit = Math.max(sell, skipSell);
                    }
                    DP_tab[idx][buy_flag][trax_limt] = profit;
                }
            }
        }
        return DP_tab[0][1][2];
    }

    int maxProfit7(int[] A) {
        // Tabulation function call
        return solveTab(A);
    }
/*
TC = O((N*2*3)), As we use 3 nested for loops
   = O(N)
SC = O(N*2*3) = O(N) Space occupied by 3D DP matrix
Result:
    > TestCase - Hard Failed
      Memory Limit Exceeded
*/

    //4. Space Optimized Solution[Without DP but derived from DP solution #3]
    int solveSpace_optimized(int[] A) {
        int N = A.length;
        int[][] curr_row = new int[2][3];
        int[][] next_row = new int[2][3];
        Arrays.fill(curr_row, 0);
        Arrays.fill(next_row, 0);
        for (int idx = N - 1; idx >= 0; idx--) {
            for (int buy_flag = 0; buy_flag <= 1; buy_flag++) {
                // we already handled case when "trax_limt == 0" hence starting from "1" here
                for (int trax_limt = 1; trax_limt <= 2; trax_limt++) {
                    int profit = 0;
                    // If you are allowed to buy, i.e buy_flag = 1
                    if (buy_flag == 1) {
                        int buy = next_row[0][trax_limt] - A[idx];
                        int skipBuy = next_row[1][trax_limt];
                        profit = Math.max(buy, skipBuy);
                    }
                    // else If your are not allowed to buy, i.e buy_flag = 0
                    else {
                        int sell = A[idx] + next_row[1][trax_limt - 1];
                        int skipSell = next_row[0][trax_limt];
                        profit = Math.max(sell, skipSell);
                    }
                    curr_row[buy_flag][trax_limt] = profit;
                }
            }
            // After Each Iteration Update next_row with curr_row, i.e Copy curr_row to next_row
            next_row = curr_row;
        }
        return next_row[1][2];
    }

    int maxProfit6(int[] A) {
        // Space Optimized function call
        return solveSpace_optimized(A);
    }
/*
TC = O((N*2*3)), As we use 3 nested for loops
   = O(N)
SC = O(2*3){curr_row matrix} + O(2*3){next_row matrix} = O(6+6) = O(6)
    = O(1)
*/
}
