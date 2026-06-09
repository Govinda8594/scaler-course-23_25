package com.scaler.Scaler.Stacks;

import java.util.Stack;

//Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
//        String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
//        Find and return the postfix expression of A.
//        NOTE:
//        ^ has the highest precedence.
//        / and * have equal precedence but greater than + and -.
//        + and - have equal precedence and lowest precedence among given operators.
public class InfixToPostfix {
    public static void main(String[] args) {
        System.out.println(new InfixToPostfix().solve2("(a+b)*(c+d)"));
    }

    public String solve2(String A) {
        // Create a StringBuilder to store the postfix expression
        StringBuilder postfix = new StringBuilder();
        // Initialize a stack to hold operators
        Stack<Character> operatorStack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            // If c is a letter (operand), append it to the postfix expression
            if (Character.isLetter(c) || Character.isDigit(c)) {
                postfix.append(c);
            }
            // If c is '(', push it onto the operator stack
            else if (c == '(') {
                operatorStack.push(c);
            }
            // If c is ')', pop operators from the stack until '(' is encountered
            else if (c == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfix.append(operatorStack.pop());
                }
                // After '(' is encountered, remove it from the stack
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                }
            }
            // If c is an operator, pop operators from the stack with higher or equal precedence
            // and append them to the postfix expression, then push c onto the stack
            else {
                while (!operatorStack.isEmpty() && getPrecedence(c) <= getPrecedence(operatorStack.peek())) {
                    postfix.append(operatorStack.pop());
                }
                operatorStack.push(c);
            }
        }
        // Append any remaining operators from the stack to the postfix expression
        while (!operatorStack.isEmpty()) {
            postfix.append(operatorStack.pop());
        }
        return postfix.toString();
    }

    private int getPrecedence(char operator) {
        return switch (operator) {
            case '^' -> 3;
            case '*', '/' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };

    }
}
