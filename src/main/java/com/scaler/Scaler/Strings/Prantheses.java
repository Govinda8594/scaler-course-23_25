package com.scaler.Scaler.Strings;

import java.util.Scanner;

public class Prantheses {
    public static void main(String[] args) {
        String expression;
        int i, length, j = 0, count = 0;
        char ch, c;
        char[] stk = new char[20];
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the Expression: ");
        expression = s.next();
        length = expression.length();
        for (i = 0; i < length; i++) {
            ch = expression.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stk[j] = ch;
                j++;
                count = 1;
            } else if (ch == ')') {
                if (count == 1)
                    j--;
                c = stk[j];
                if (stk.length == 0 || c != '(') {
                    System.out.println("\nUnbalanced Parentheses!");
                    return;
                }
            } else if (ch == '}') {
                if (count == 1)
                    j--;
                c = stk[j];
                if (stk.length == 0 || c != '{') {
                    System.out.println("\nUnbalanced Parentheses!");
                    return;
                }
            } else if (ch == ']') {
                if (count == 1)
                    j--;
                c = stk[j];
                if (stk.length == 0 || c != '[') {
                    System.out.println("\nUnbalanced Parentheses!");
                    return;
                }
            }
        }
        System.out.println("\nBalanced Parentheses.");
    }

    public static boolean areBracketsBalanced(String s)
    {
        int i = -1;
        char[] stack = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack[++i] = ch;
            else {
                if (i >= 0
                        && ((stack[i] == '(' && ch == ')')
                        || (stack[i] == '{' && ch == '}')
                        || (stack[i] == '[' && ch == ']')))
                    i--;
                else
                    return false;
            }
        }
        return i == -1;
    }


}
