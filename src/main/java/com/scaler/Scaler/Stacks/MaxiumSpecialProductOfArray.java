package com.scaler.Scaler.Stacks;

import java.util.Stack;

public class MaxiumSpecialProductOfArray {
//    Given arr of  N Integer array for i-th integer ,
//    leftvalue - maximum value of j such that j < i && A[j] > A[i]
//    rightvalue - maximum value of j such that j > i && A[j] > A[i]
//    find maxium special product of integer in array .return value % 10 power 9  + 7
//
//    write a java code solution for above problem statement

    //    To solve this problem, we can use the following approach:
//
//    Create two arrays left and right of size N to store the left and right values respectively.
//    Traverse the array from left to right and fill the left array with the maximum value of j such that j < i and `A[j] > A[i].
//    Traverse the array from right to left and fill the right array with the maximum value of j such that j > i and `A[j] > A[i].
//    Traverse the array and calculate the special product of each element by multiplying its left and right values.
//    Return the maximum special product modulo 10^9 + 7.
//    Here is the Java code that implements the above approach:
    public int maxSpecialProduct(int[] A) {
        int N = A.length;
        int[] left = new int[N];
        int[] right = new int[N];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = N - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(i);
        }
        long ans = 0;
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, 1L * left[i] * right[i]);
        }
        return (int) (ans % 1000000007);
    }
}
