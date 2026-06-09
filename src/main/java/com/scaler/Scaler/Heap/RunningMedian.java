package com.scaler.Scaler.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

//Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
//        Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.
//        Find and return the array C.
//        NOTE:
//        If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
//        If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
public class RunningMedian {
    public int[] solve(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        maxHeap.add(A[0]);
        ans[0] = A[0];
        for (int i = 1; i < N; i++) {
            // Insert A[i] to minHeap or maxHeap
            if (A[i] <= maxHeap.peek()) {
                maxHeap.add(A[i]);
            } else {
                minHeap.add(A[i]);
            }
            // Balance the heaps
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            } else if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.add(maxHeap.poll());
            }
            ans[i] = maxHeap.peek();
        }
        return ans;
    }
}
