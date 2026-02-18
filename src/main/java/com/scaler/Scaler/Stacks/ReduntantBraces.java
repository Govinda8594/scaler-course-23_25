package com.scaler.Scaler.Stacks;

import java.util.Stack;

//Problem Description
//        Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
//        Check whether A has redundant braces or not.
//        NOTE: A will be always a valid expression and will not contain any white spaces.
public class ReduntantBraces {
    public static void main(String[] args) {
        braces("(A + (B))");
    }

    public static int braces(String A) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            if (!stk.isEmpty() && A.charAt(i) == ')') {
                int count = 0;
                while (!stk.peek().equals('(')) {
                    stk.pop();
                    count++;
                }
                if (count <= 1) {
                    return 1;
                }
                stk.pop(); //pop the open bracket

            } else stk.push(A.charAt(i));
        }
        return 0;
    }
}
