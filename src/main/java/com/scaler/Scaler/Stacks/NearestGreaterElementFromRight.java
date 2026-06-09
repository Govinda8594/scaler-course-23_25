package com.scaler.Scaler.Stacks;

import java.util.Arrays;
import java.util.Stack;
//Given an array A, find the next greater element G[i] for every element A[i] in the array.
//        The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
//
//        More formally:
//
//        G[i] for an element A[i] = an element A[j] such that
//        j is minimum possible AND
//        j > i AND
//        A[j] > A[i]
//        Elements for which no greater element exists, consider the next greater element as -1.


public class NearestGreaterElementFromRight {
    public int[] NGER(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() <= A[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            stk.push(A[i]);
        }
        return ans;
    }


}
