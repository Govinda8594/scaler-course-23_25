package com.scaler.Scaler.Stacks;

import java.util.Stack;

//Given an array of integers A.
//        A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
//        Find the area of the largest rectangle formed by the histogram.
public class LargestRectangularAreaFromHistogram {
    public int largestRectangleArea2(int[] A) {
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
