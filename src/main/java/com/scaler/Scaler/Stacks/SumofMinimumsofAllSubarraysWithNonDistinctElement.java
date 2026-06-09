package com.scaler.Scaler.Stacks;

import java.util.Stack;

public class SumofMinimumsofAllSubarraysWithNonDistinctElement {
    public static int sumOfSubarrayMinimums(int[] A) {
        int n = A.length;
        int[] ple = new int[n]; // Previous Less Element
        int[] nle = new int[n]; // Next Less Element
        Stack<Integer> stack = new Stack<>();

        // PLE
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // NLE
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            sum += (long) A[i] * left * right;
        }

        return (int) sum;
    }
}
