package com.scaler.Scaler.Stacks;

import java.util.Stack;
//Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
//        push(x) -- Push element x onto stack.
//        pop() -- Removes the element on top of the stack.
//        top() -- Get the top element.
//        getMin() -- Retrieve the minimum element in the stack.
//        NOTE:
//        All the operations have to be constant time operations.
//        getMin() should return -1 if the stack is empty.
//        pop() should return nothing if the stack is empty.
//        top() should return -1 if the stack is empty.
public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int num = stack.pop();
        if (num == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek();
    }
}
