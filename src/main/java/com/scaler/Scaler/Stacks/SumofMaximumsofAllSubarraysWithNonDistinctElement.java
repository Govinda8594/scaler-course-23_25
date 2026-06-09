package com.scaler.Scaler.Stacks;
//Core Idea
//        For each element A[i], we calculate:
//        - How many subarrays it is the minimum of → contributes to SumOfMinOfEverySubArray
//        - How many subarrays it is the maximum of → contributes to SumOfMaxOfEverySubArray
//        We use monotonic stacks to find:
//        - Previous Less Element (PLE) and Next Less Element (NLE) for minimums
//        - Previous Greater Element (PGE) and Next Greater Element (NGE) for maximums

import java.util.Stack;

public class SumofMaximumsofAllSubarraysWithNonDistinctElement {

    public static int sumOfSubarrayMaximums(int[] A) {
        int n = A.length;
        int[] pge = new int[n]; // Previous Greater Element on left
        int[] nge = new int[n]; // Next Greater Element right
        Stack<Integer> stack = new Stack<>();

        // PGE
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // NGE
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - pge[i];
            long right = nge[i] - i;
            sum += (long) A[i] * left * right;
        }

        return (int) sum;
    }
}
