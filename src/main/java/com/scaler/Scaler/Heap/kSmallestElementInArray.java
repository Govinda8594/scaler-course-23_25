package com.scaler.Scaler.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class kSmallestElementInArray {
    public static void printKSmallest(int[] arr, int k) {
        // Max-heap to store k smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
            } else if (num < maxHeap.peek()) {
                maxHeap.poll();       // Remove largest in heap
                maxHeap.offer(num);   // Insert smaller element
            }
        }

        // Print the k smallest elements (unsorted)
        for (int num : maxHeap) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {20, 5, 1, 17, 10, 3, 8};
        int k = 4;
        printKSmallest(arr, k); // Output: 1 3 5 8 (order may vary)
    }
}
