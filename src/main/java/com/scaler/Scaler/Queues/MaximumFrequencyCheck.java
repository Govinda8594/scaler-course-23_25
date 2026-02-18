package com.scaler.Scaler.Queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

//You are given a matrix A of size N x 2 which represents different operations.
//        Assume initially you have a stack-like data structure you have to perform operations on it.
//        Operations are of two types:
//        1 x: push an integer x onto the stack and return -1.
//        2 0: remove and return the most frequent element in the stack. This basically means the element which has the highest count among all the elements currently in the stack.
//        If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
//        A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.
public class MaximumFrequencyCheck {
    public int[] solve(int[][] A) {
        int n = A.length;
        int[] ans = new int[n];
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Deque<Integer>> group = new HashMap<>();
        int maxFreq = 0;

        for (int i = 0; i < n; i++) {
            if (A[i][0] == 1) { // Insert operation
                int x = A[i][1];
                int newFreq = freq.getOrDefault(x, 0) + 1;
                freq.put(x, newFreq);
                group.computeIfAbsent(newFreq, k -> new ArrayDeque<>()).push(x);
                maxFreq = Math.max(maxFreq, newFreq);
                ans[i] = -1;
            } else { // Pop operation
                if (maxFreq == 0) {
                    ans[i] = -1;
                } else {
                    Deque<Integer> stack = group.get(maxFreq);
                    int x = stack.pop();
                    freq.put(x, freq.get(x) - 1);
                    if (stack.isEmpty()) {
                        group.remove(maxFreq);
                        maxFreq--;
                    }
                    ans[i] = x;
                }
            }
        }
        return ans;
    }
}
