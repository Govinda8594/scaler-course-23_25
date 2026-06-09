package com.scaler.Scaler.Stacks;

import java.util.Arrays;
import java.util.Stack;

//Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
//        The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
//        NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.
public class CheckTwoExpressionSimilar {
    public static void main(String[] args) {
        solve3("-(a+b+c)", "-a-b-c");
    }

    public static char[] calculateSigns(String str) {
        Stack<Character> globalOperators = new Stack<Character>();
        char[] outArr = new char[26];
        Arrays.fill(outArr, '+');
        int n = str.length();
        char localOperator = '+';      //This is to keep track of the sign comes immediately before the number
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (ch == '-' || ch == '+') {
                if (globalOperators.isEmpty()) {
                    localOperator = ch;
                } else {
                    localOperator = giveProperSign(globalOperators.peek(), ch);
                }
                continue;
            }
            if (ch == '(') {
                globalOperators.push(localOperator);
                continue;
            }
            if (ch == ')') {
                globalOperators.pop();
                continue;
            }
            outArr[ch - 'a'] = localOperator;
        }
        return outArr;
    }

    public static char giveProperSign(char operator1, char operator2) {
        if ((operator1 == '-' && operator2 == '+') || (operator1 == '+' && operator2 == '-')) {
            return '-';
        }
        return '+';
    }
    
    public static int solve3(String A, String B) {
        char[] strA = calculateSigns(A);
        char[] strB = calculateSigns(B);
        for (int i = 0; i < strA.length; i++) {
            if (strA[i] != strB[i]) {
                return 0;
            }
        }
        return 1;
    }
}
