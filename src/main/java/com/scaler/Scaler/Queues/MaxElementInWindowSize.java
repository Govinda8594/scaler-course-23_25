package com.scaler.Scaler.Queues;

import java.util.Deque;
import java.util.LinkedList;

public class MaxElementInWindowSize {

    public static void main(String[] args) {
//        maxInWindow3(new int[]{3,15,6,12,4,2,10,9,13,7,2,5,3},4);
//        maxInWindow3(new int[]{10,6,10,3,9,11},4);
        maxInWindow3(new int[]{10, 2, 9, 3, 7, 6, 5, 11, 8}, 4);
    }

    public static int[] maxInWindow3(int[] A, int k) {
        // 'n' is the length of the input array
        int n = A.length;
        // 'result' will store the maximum values for each window of size 'k'
        int[] result = new int[n - k + 1];
        // A deque to store the elements in the current window
        Deque<Integer> deque = new LinkedList<>();

        // Initialize the deque with the first 'k' elements
        for (int i = 0; i < k; i++) {
            // Remove elements that are smaller than the current element from the end of the deque
            while (!deque.isEmpty() && A[i] > deque.peekLast()) {
                deque.removeLast();
            }
            // Add the current element to the end of the deque
            deque.addLast(A[i]);
        }
        // The first element in the deque is the maximum of the first window
        result[0] = deque.peekFirst();

        // Iterate over the rest of the elements
        for (int i = k; i < n; i++) {
            // Remove elements that are smaller than the current element from the end of the deque
            while (!deque.isEmpty() && A[i] > deque.peekLast()) {
                deque.removeLast();
            }
            // Add the current element to the end of the deque
            deque.addLast(A[i]);
            // If the element at the start of the deque is no longer in the window, remove it
            if (deque.peekFirst() == A[i - k]) {
                deque.removeFirst();
            }
            // The first element in the deque is the maximum for the current window
            result[i - k + 1] = deque.peekFirst();
        }
        // Return the array of maximums
        return result;
    }


}
