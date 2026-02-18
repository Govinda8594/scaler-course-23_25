package com.scaler.Scaler.Stacks;

import java.util.Stack;

//Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
//Refer to the examples for more clarity.
public class BalancePranthese {
    public static int isBalanced(String expression) {
        char ch;
        Stack<Character> stack = new Stack<Character>();
        int length = expression.length();
        for (int i = 0; i < length; i++) {
            ch = expression.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
//                    System.out.println("\nUnbalanced Parentheses!");
                    return 0;
                }
            } else if (ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
//                    System.out.println("\nUnbalanced Parentheses!");
                    return 0;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
//                    System.out.println("\nUnbalanced Parentheses!");
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
//        if (stack.isEmpty()) {
//            return 1;
////            System.out.println("\nBalanced Parentheses.");
//        }
//        return 0;
    }

    ////////////////////////////////////////////////////////////////////////////////
    static boolean isPaired(Character ch1, Character ch2) {
        return (ch1.equals('(') && ch2.equals(')')) || (ch1.equals('{') && ch2.equals('}'))
                || (ch1.equals('[') && ch2.equals(']'));
    }

    public int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for (char ch : A.toCharArray()) {
            if (!stack.isEmpty() && isPaired(stack.peek(), ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
