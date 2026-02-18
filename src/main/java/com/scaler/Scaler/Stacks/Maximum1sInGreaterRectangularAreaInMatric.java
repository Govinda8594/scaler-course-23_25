package com.scaler.Scaler.Stacks;

import java.util.Stack;

//Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
//        Find the largest rectangle containing only 1's and return its area.
//        Note: Rows are numbered from top to bottom and columns are numbered from left to right.
public class Maximum1sInGreaterRectangularAreaInMatric {
    public int solve(int[][] A) {
        int n = A.length, m = A[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                A[i][j] = A[i][j] == 0 ? 0 : A[i][j] + A[i - 1][j];
            }
        }
        int ans = 0;
        for (int[] arr : A) {
            ans = Math.max(ans, largestRectangleArea(arr));
        }
        return ans;
    }

    public int largestRectangleArea(int[] A) {
        Stack<Integer> stack = new Stack<Integer>();
        int ans = -1, n = A.length;
        for (int i = 0; i <= A.length; i++) {
            while (!stack.empty() && (i == n || A[i] <= A[stack.peek()])) {
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
