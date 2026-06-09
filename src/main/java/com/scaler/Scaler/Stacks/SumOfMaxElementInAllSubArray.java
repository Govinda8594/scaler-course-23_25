package com.scaler.Scaler.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class SumOfMaxElementInAllSubArray {

    int maxSumElement(int[] A) {
        int[] left = NGEIL(A);
        int[] right = NGEIR(A);
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int p1 = left[i];
            int p2 = right[i];
            int s = i - p1;
            int e = i - p2;
            int contri = s * e;
            ans += A[i] * contri;
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
}
