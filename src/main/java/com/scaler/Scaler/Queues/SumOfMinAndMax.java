package com.scaler.Scaler.Queues;

import java.util.ArrayDeque;
import java.util.Deque;

//Given an array A of both positive and negative integers.
//        Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
//        NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
public class SumOfMinAndMax {

    public int solve2(int[] A, int B) {
        int n = A.length;
        long sum = 0;
        long mod = 1000000007;
        Deque<Integer> maxDeque = new ArrayDeque<>(); // maxDeque is to get the max in each subarray.
        Deque<Integer> minDeque = new ArrayDeque<>(); // minDeque is to get the min in each subarray.
        for (int i = 0; i < B; i++) {
            while (!maxDeque.isEmpty() && maxDeque.getLast() < A[i]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(A[i]);
            while (!minDeque.isEmpty() && minDeque.getLast() > A[i]) {
                minDeque.removeLast();
            }
            minDeque.addLast(A[i]);
        }
        sum += maxDeque.getFirst() + minDeque.getFirst();
        int s = 1;
        int e = B;
        while (e < n) {
            if (A[s - 1] == maxDeque.getFirst()) {
                maxDeque.removeFirst();
            }
            if (A[s - 1] == minDeque.getFirst()) {
                minDeque.removeFirst();
            }
            while (!maxDeque.isEmpty() && maxDeque.getLast() < A[e]) {
                maxDeque.removeLast();
            }
            maxDeque.addLast(A[e]);
            while (!minDeque.isEmpty() && minDeque.getLast() > A[e]) {
                minDeque.removeLast();
            }
            minDeque.addLast(A[e]);
            sum += maxDeque.getFirst() + minDeque.getFirst();
            s++;
            e++;
        }
// The elements in the array can be negative and the final sum could be negative too.
// Since we need to the modulo operation, the remainder cannot be negative. So, we do the below step.
        long ans = ((sum % mod) + mod) % mod;
        return (int) ans;
    }
}
