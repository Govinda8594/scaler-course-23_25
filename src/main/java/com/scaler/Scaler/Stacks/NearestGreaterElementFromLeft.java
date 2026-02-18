package com.scaler.Scaler.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterElementFromLeft {
    public int[] NGEIL(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() <= A[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                ans[i] = stack.peek();
            }
            stack.push(A[i]);
        }
        return ans;
    }
}
