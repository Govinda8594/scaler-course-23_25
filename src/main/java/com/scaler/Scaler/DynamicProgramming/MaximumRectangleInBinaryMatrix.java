package com.scaler.Scaler.DynamicProgramming;

import java.util.Stack;

//Given a 2-D binary matrix A of length N x M filled with 0's and 1's,
// find the largest rectangle containing only ones and return its area.
public class MaximumRectangleInBinaryMatrix {

    /// ///////////////Memoization////////////////

    public int maximalRectangle(int[][] A) {
        int n = A.length, m = A[0].length, ans = Integer.MIN_VALUE;
        int[][] dp = new int[n][m];
        //transferring all the element to another matrice dp matrix
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, dp[i], 0, m);
        }
        //calculating the column wise prefix sum
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] != 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        //now from that prefix col sum we will calculate the max row sum going at each and
        //every element and including more and more rows at particular height
        for (int i = 0; i < n; i++) { //tc: n*m*n
            for (int j = 0; j < m; j++) {
                int area = 0, height = 1, width = Integer.MAX_VALUE;
                for (int row = i; row >= 0; row--) { //going up the height taking more and more element up
                    width = Math.min(width, dp[row][j]);
                    area = Math.max(area, width * height);
                    height++;
                }
                ans = Math.max(ans, area);
            }
        }
        return ans;
    }

    /// /////Recusrion////////////////////////////////
    public int maximalRectangle2(int[][] A) {
        int n = A.length, m = A[0].length, ans = 0;
        int curAns = getMaxRect(A[0]);
        ans = Math.max(ans, curAns);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = A[i - 1][j] + 1;
                }
            }
            curAns = getMaxRect(A[i]);
            ans = Math.max(ans, curAns);
        }
        return ans;
    }

    public int getMaxRect(int[] A) {
        Stack<Integer> stack = new Stack<Integer>();
        int ans = -1, n = A.length;
        for (int i = 0; i <= A.length; i++) {
            while (!stack.empty() && (i == n || A[stack.peek()] >= A[i])) {
                int height = A[stack.peek()];
                stack.pop();
                // (stack.peek()+1) is the left and (i-1) is the right boundary of the rectangle with height A[ind]
                int width;
                if (stack.empty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;

                }
                ans = Math.max(ans, height * width);
            }
            stack.push(i);
        }
        return ans;
    }
}
