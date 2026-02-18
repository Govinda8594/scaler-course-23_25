package com.scaler.Scaler.Queues;

import java.util.*;

//Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array,
//        leaving the other elements in the same relative order.
//
//        NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.
public class ReverseBElementInQueue {
    public int[] solve(int[] A, int B) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < B; i++) {
            q.add(A[i]);
        }
        for (int i = B - 1; i >= 0; i--) {
            A[i] = q.remove();
        }
        return A;
    }

    ///////////////////////////////////////////////////////////////////
    public int[] solve2(int[] A, int B) {
        Stack<Integer> q = new Stack<Integer>();
        int iCount = 0;
// Add the first B elements on the queue
        for (int i = 0; i < B; i++) {
//System.out.println("Element is " + A[i]);
            q.add(A[i]);
        }
        while (!q.isEmpty()) {
//System.out.println("top of queue "+ q.peek());
            A[iCount++] = q.peek();
            q.pop();
        }
        return A;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    public int[] solve3(int[] A, int B) {
        Deque<Integer> q = new ArrayDeque<Integer>(A.length);
        int i = 0;
        // Insert first B elements in queue
        for (i = 0; i < B; i++) {
            q.addLast(A[i]);
        }
        // Reverse the first B elements in the array A
        while (!q.isEmpty()) {
            i--;
            A[i] = q.getFirst();
            q.removeFirst();
        }
        return A;
    }
}
