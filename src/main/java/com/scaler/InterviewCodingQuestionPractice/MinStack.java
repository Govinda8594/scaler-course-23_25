package com.scaler.InterviewCodingQuestionPractice;

import java.util.Stack;

public class MinStack {
            // Constructor
            Stack<Integer> stack,minStack;
            MinStack() {
                // Write your code here.
                stack = new Stack<>();
                minStack = new Stack<>();
            }

            // Function to add another element equal to num at the top of stack.
            void push(int num) {
                // Write your code here.
                stack.push(num);
                if (minStack.empty() || minStack.peek() >= num) {
                    minStack.push(num);
                }
            }

            // Function to remove the top element of the stack.
            int pop() {
                // Write your code here.
                if (stack.empty())
                    return -1;
                if(!minStack.isEmpty() && minStack.peek() == stack.peek())
                    minStack.pop();
                return stack.pop();
            }

            // Function to return the top element of stack if it is present. Otherwise
            // return -1.
            int top() {
                // Write your code here.
                if (stack.empty())
                    return -1;
                return stack.peek();
            }

            // Function to return minimum element of stack if it is present. Otherwise
            // return -1.
            int getMin() {
                // Write your code here.
                if (minStack.empty())
                    return -1;
                return minStack.peek();
            }
        }
