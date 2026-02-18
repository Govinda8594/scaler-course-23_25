package com.scaler.Scaler.Stacks;

import java.util.ArrayList;
import java.util.Stack;

//Given a stack of integers A, sort it using another stack.
//        Return the array of integers after sorting the stack using another stack.
public class SortStackUsingAnotherStack {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(5);
        a.add(11);
        a.add(17);
        a.add(100);
        solve(a);

    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        for (int num : A) {
            pushIntoPlace(num);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.empty()) {
            res.add(stack.pop());
        }
        return res;
    }

    public static void pushIntoPlace(Integer num) {
        if (stack.empty()) {
            stack.push(num);
            return;
        }
        if (stack.peek() > num) {
            stack.push(num);
            return;
        }
        int topElement = stack.pop();
        pushIntoPlace(num);
        stack.push(topElement);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public int[] solve(int[] A) {
        int N = A.length;
        Stack<Integer> mainStack = new Stack<>();
        Stack<Integer> tempStack = new Stack<>();
        for (int j : A) {
            mainStack.push(j);
        }
        int ele = mainStack.pop();
        tempStack.push(ele);
        while (!mainStack.isEmpty()) {
            int temp = mainStack.pop();
            while (!tempStack.isEmpty()) {
                if (temp < tempStack.peek()) { // check to pop all element greater in tempstack
                    // and push again in main
                    mainStack.push(tempStack.pop());
                } else { // if less break and push in tempstack to sort
                    break;
                }
            }
            tempStack.push(temp);
        }
        // reverse pop
        for (int i = N - 1; i >= 0; i--) {
            A[i] = tempStack.pop();
        }
        return A;
    }
}
