package com.scaler.Scaler.Stacks;

import java.util.Arrays;
import java.util.Stack;

//Given an integer array A of size N. You have to generate it's all subarrays having a size greater than 1.
//        Then for each subarray, find Bitwise XOR of its maximum and second maximum element.
//        Find and return the maximum value of XOR among all subarrays.
public class BitWiseXORofMaximumAndMinimumInAllSubArray {
    public static void main(String[] args) {
        solve(new int[]{2, 3, 1, 4});
    }

    //    max element ^ sec max element
    public static int solve(int[] A) {
        int ans = 0;
        int n = A.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty()) {
                ans = Math.max(ans, (A[stack.peek()] ^ A[i]));
                // greater element at top dont remove for maximum xor(max element ^ sec max element)
                if (A[stack.peek()] > A[i]) {
                    break;
                }
                // smaller element pop
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }

    //////////////////////////////////////////////////////////////
    public int solve2(int[] A) {
        int N = A.length;
        int[] prevGreater = NGEIL(A);
        int[] nextGreater = NGEIR(A);
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (prevGreater[i] != -1 && nextGreater[i] != N) {
                int prev = (A[i] ^ A[prevGreater[i]]);
                int next = (A[i] ^ A[nextGreater[i]]);
                int max = Math.max(prev, next);
                ans = Math.max(max, ans);
            } else if (prevGreater[i] != -1 && (nextGreater[i] == N)) {
                int max = (A[i] ^ A[prevGreater[i]]);
                ans = Math.max(max, ans);
            } else if (prevGreater[i] == -1 && nextGreater[i] != N) {
                int max = (A[i] ^ A[nextGreater[i]]);
                ans = Math.max(max, ans);
            }
        }
        return ans;
    }

    public int[] NGEIL(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        Arrays.fill(ans, -1);
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stk.isEmpty() && A[stk.peek()] <= A[i]) {
                stk.pop();
            }

            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            stk.push(i);
        }
        return ans;
    }

    public int[] NGEIR(int[] A) {
        int len = A.length;
        int[] ans = new int[len];
        Arrays.fill(ans, len);
        Stack<Integer> stk = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stk.isEmpty() && A[stk.peek()] <= A[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                ans[i] = stk.peek();
            }
            stk.push(i);
        }
        return ans;
    }


}
