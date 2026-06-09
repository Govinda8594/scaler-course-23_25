package com.scaler.Scaler.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterElementIndexFromRight {
    public static void main(String[] args) {
        int[] ans = NGEIR(new int[]{2, 3, 1, 4});
    }

    public static int[] NGEIR(int[] A) {
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
