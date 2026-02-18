package com.scaler.Scaler.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Given a string A made up of multiple brackets of type "[]" , "()" and "{}" find the length of the longest substring which forms a balanced string .
//        Conditions for a string to be balanced :
//        Blank string is balanced ( However blank string will not be provided as a test case ).
//        If B is balanced : (B) , [B] and {B} are also balanced.
//        If B1 and B2 are balanced then B1B2 i.e the string formed by concatenating B1 and B2 is also balanced.
public class LongestBalancedSubstring {
    public int LBSlength1(final String A) {
        // Map to store the corresponding opening brackets for each closing bracket
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

// Get the length of the input string
        int n = A.length();

// Initialize a dynamic programming array to store the length of the longest valid substring ending at each index
        int[] dp = new int[n];

// Iterate through the string
        for (int i = 0; i < n; i++) {
            char curr = A.charAt(i);

            // If the current character is not a closing bracket, set dp[i] to 0 ,for open dp mark 0
            if (!map.containsKey(curr)) dp[i] = 0;
            else {
                // If the previous character is the corresponding opening bracket,for current close
                if (i - 1 >= 0 && A.charAt(i - 1) == map.get(curr)) {
                    dp[i] = (i - 2 >= 0) ? dp[i - 2] + 2 : 2;
                }
//                If the previous character is not (, check if there is a valid substring before the current closing parenthesis that can be extended:
//                Check if there is a matching opening parenthesis at the correct position (i - dp[i - 1] - 1).
//                If there is a match, dp[i] is updated to 2 plus the length of the valid substring ending at i - 1.
//                Also add the length of any valid substring that ends just before this new valid substring.
                else if (i - 1 >= 0 && i - dp[i - 1] - 1 >= 0 && A.charAt(i - dp[i - 1] - 1) == map.get(curr)) {
                    dp[i] = dp[i - 1] + 2;
                    dp[i] = (i - dp[i] >= 0) ? dp[i] + dp[i - dp[i]] : dp[i];
                }
                // If neither condition is met, set dp[i] to 0
                else dp[i] = 0;
            }
        }

// Initialize max to keep track of the maximum length of the valid parentheses substring
        int max = 0;

// Iterate through the dp array to find the maximum value
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }

// Return the maximum length of the valid parentheses substring
        return max;

    }

    //////////////////////////////////////////////////////////////////////////////////////////
    public int LBSlength3(final String A) {
        int[] dp = new int[A.length()];
        Stack<Pair> stack = new Stack<>();
        int maxLength = 0;
        for (int i = 0; i < A.length(); i++) {
            char chr = A.charAt(i);
            if (chr == '(') {
                stack.push(new Pair(i, ')'));
            } else if (chr == '{') {
                stack.push(new Pair(i, '}'));
            } else if (chr == '[') {
                stack.push(new Pair(i, ']'));
            } else {
                if (!stack.isEmpty() && stack.peek().c == chr) {
                    Pair temp = stack.pop();
                    int len = i - temp.index + 1;
                    if (temp.index > 0) {
                        dp[i] = len + dp[temp.index - 1];
                    } else {
                        dp[i] = len;
                    }
                    maxLength = Math.max(dp[i], maxLength);
                } else {
                    stack.push(new Pair(i, '/'));//breaking substring
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return maxLength;
    }
    //////////////////////////////////////////////////////////////////////////////////////////

    public int solve(String A) {
        int n = A.length();
        if (n == 0) return 0;
        int[] dp = new int[n];
        int max = 0;
//        For each closing bracket at position i, we calculate j = i - 1 - dp[i-1].
//        This j is the position of the potential matching opening bracket for the current closing bracket.
//        If j is within bounds and the character at j matches the current closing bracket,
//        we set dp[i] to 2 + dp[i-1] (accounting for the current pair and any balanced substring ending just before i).
//        If there exists a balanced substring ending before j (i.e., j-1 >= 0),
//        we add its length (dp[j-1]) to dp[i] to handle concatenated balanced substrings.
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (i >= 1 && (c == ')' || c == ']' || c == '}')) {
                int j = i - 1 - dp[i - 1];
                if (j >= 0) {
                    char openChar = A.charAt(j);
                    if ((openChar == '(' && c == ')') ||
                            (openChar == '[' && c == ']') ||
                            (openChar == '{' && c == '}')) {
                        dp[i] = 2 + dp[i - 1];
                        if (j - 1 >= 0) {
                            dp[i] += dp[j - 1];
                        }
                    } else {
                        dp[i] = 0;
                    }
                } else {
                    dp[i] = 0;
                }
            } else {
                dp[i] = 0;
            }
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

    static class Pair {
        int index;
        char c;

        public Pair(int index, char c) {
            this.index = index;
            this.c = c;
        }
    }
}
