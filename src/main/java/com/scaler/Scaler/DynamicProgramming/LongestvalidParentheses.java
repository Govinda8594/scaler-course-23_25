package com.scaler.Scaler.DynamicProgramming;

import java.util.Stack;

//Given a string A containing just the characters '(' and ')'.
//        Find the length of the longest valid (well-formed) parentheses substring.
public class LongestvalidParentheses {

    public int longestValidParentheses(String A) {
        int max = 0;
        int last = -1;
        Stack<Integer> left = new Stack<>();
        char c;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            c = A.charAt(i);
            if (c == '(') {
                left.push(i);
            } else {
                if (left.isEmpty()) {
                    last = i;
                } else {
                    left.pop();
                    if (left.isEmpty()) {
                        max = Math.max(max, i - last);
                    } else {
                        max = Math.max(max, i - left.peek());
                    }
                }
            }
        }
        return max;
    }

    ////////////////////////////////////////////////////////////////////////
/*
Check if the character is a closing parenthesis ')':
If the character at position i is ):
If the previous character (A.charAt(i - 1)) is (, then count[i] is 2 plus the value at count[i - 2] if it exists, otherwise just 2.
If the previous character is not (, check if there is a valid substring before the current closing parenthesis that can be extended:
Check if there is a matching opening parenthesis at the correct position (i - count[i - 1] - 1).
If there is a match, count[i] is updated to 2 plus the length of the valid substring ending at i - 1.
Also add the length of any valid substring that ends just before this new valid substring.
Update the answer:
For each index, update ans to be the maximum of its current value and count[i].
 */
    public int longestValidParentheses3(String A) {
        int n = A.length();
        int[] count = new int[n];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            char ch = A.charAt(i);
            if (ch == ')') {
                if (A.charAt(i - 1) == '(') {
                    count[i] = i - 2 >= 0 ? count[i - 2] + 2 : 2;
                } else if (i - count[i - 1] - 1 >= 0 && A.charAt(i - count[i - 1] - 1) == '(') {
                    count[i] = 2 + count[i - 1];
                    count[i] = i - count[i] >= 0 ? count[i - count[i]] + count[i] : count[i];
                }
            }
            ans = Math.max(ans, count[i]);
        }
        return ans;
    }
}
