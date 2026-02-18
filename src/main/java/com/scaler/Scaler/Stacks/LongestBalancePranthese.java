package com.scaler.Scaler.Stacks;

import java.util.Stack;

public class LongestBalancePranthese {

    public int LBSlength(final String A) {
        int[] dp = new int[A.length()];
        Stack<Pair> stack = new Stack<>();
        int maxLength = 0;
        for (int i = 0; i < A.length(); i++) {
            char chr = A.charAt(i);
            if (chr == '(')
                stack.push(new Pair(i, ')'));
            else if (chr == '{')
                stack.push(new Pair(i, '}'));
            else if (chr == '[')
                stack.push(new Pair(i, ']'));
            else {
                if (!stack.isEmpty() && stack.peek().c == chr) {
                    Pair temp = stack.pop();
                    int len = i - temp.index + 1;
                    if (temp.index > 0)
                        dp[i] = len + dp[temp.index - 1];
                    else
                        dp[i] = len;
                    maxLength = Math.max(dp[i], maxLength);
                } else
                    stack.push(new Pair(i, '/'));//breaking substring
            }
        }
        // System.out.println(Arrays.toString(dp));
        return maxLength;
    }
}

class Pair {
    int index;
    char c;

    public Pair(int index, char c) {
        this.index = index;
        this.c = c;
    }
}
