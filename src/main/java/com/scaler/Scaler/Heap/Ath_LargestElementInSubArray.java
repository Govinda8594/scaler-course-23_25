package com.scaler.Scaler.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

//Given an integer array B of size N.
//        You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].
//        NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.
public class Ath_LargestElementInSubArray {

    public int[] solve2(int A, int[] B) {
        // Initialize an array to store the Ath largest elements
        int N = B.length;
        int[] ans = new int[N];
        // Using a minHeap to get the Ath largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Fill the initial elements with -1
        for (int i = 0; i < A - 1; i++) {
            ans[i] = -1;
        }
        // Add the first A elements to the minHeap
        for (int i = 0; i < A; i++) {
            minHeap.add(B[i]);
        }
        // Store the Ath largest element in the array
        ans[A - 1] = minHeap.peek();
        // Process the remaining elements
        for (int i = A; i < N; i++) {
            minHeap.add(B[i]);
            // If the minHeap size greater than A then remove the smallest element
            if (minHeap.size() > A) {
                minHeap.poll();
            }
            // Store the Ath largest element in the array
            ans[i] = minHeap.peek();
        }
        return ans;
    }
    ///////////////////////////////////////////////////////////////////////

    public ArrayList<Integer> solve(int A, int[] B) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (Integer integer : B) {
            minHeap.add(integer);
            if (minHeap.size() < A) {
                res.add(-1);
            } else {
                while (minHeap.size() > A) {
                    minHeap.remove();
                }
                res.add(minHeap.peek());
            }
        }
        return res;
    }
}
