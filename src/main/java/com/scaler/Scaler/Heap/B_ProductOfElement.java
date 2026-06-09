package com.scaler.Scaler.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

//Given an integer array A of size N.
//        You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
//        Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
public class B_ProductOfElement {

    public int[] solve(int[] A) {
        int[] ans = new int[A.length];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            // Add the current element to the maxHeap
            maxHeap.add(A[i]);
            if (maxHeap.size() > 2) {
                // Extract the three largest elements from the maxHeap
                int p1 = maxHeap.poll();
                int p2 = maxHeap.poll();
                int p3 = maxHeap.poll();
                // Calculate the product of the three largest elements
                ans[i] = p1 * p2 * p3;
                // Add the extracted elements back to the maxHeap
                maxHeap.add(p1);
                maxHeap.add(p2);
                maxHeap.add(p3);
            } else {
                // If the size of maxHeap is less than or equal to 2, set the result to -1
                ans[i] = -1;
            }
        }
        return ans;
    }
}
