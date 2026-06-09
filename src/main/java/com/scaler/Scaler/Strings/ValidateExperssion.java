package com.scaler.Scaler.Strings;

import java.util.Stack;

public class ValidateExperssion {
    public static void main(String[] args) {
        braces("(a+(a+b))");
    }
    public static int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for(char ch:A.toCharArray()){
            if(!stack.isEmpty() && isPaired(stack.peek(),Character.valueOf(ch))){
                return 1;
            }else stack.push(Character.valueOf(ch));
        }
        return 0;
    }

    static boolean isPaired(Character ch1, Character ch2) {
        if (ch1.equals(ch2)) {
            return true;
        }
        return false;
    }
}
