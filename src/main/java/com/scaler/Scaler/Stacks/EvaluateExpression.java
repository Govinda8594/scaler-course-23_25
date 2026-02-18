package com.scaler.Scaler.Stacks;

import java.util.Stack;

//An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
//        Valid operators are +, -, *, /. Each string may be an integer or an operator.
//        Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
public class EvaluateExpression {
    public int evalRPN(String[] A) {
        Stack<Integer> stk = new Stack<>();
        for (String token : A) {
            if (isOperator(token)) {
                int op2 = stk.pop();
                int op1 = stk.pop();
                int result = performOperation(op1, op2, token);
                stk.push(result);
            } else {
                int operand = Integer.parseInt(token);
                stk.push(operand);
            }
        }
        return stk.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int performOperation(int op1, int op2, String operator) {
        return switch (operator) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "*" -> op1 * op2;
            case "/" -> op1 / op2;
            default -> 0;
        };
    }
}
