package com.scaler.Scaler.Queues;

import java.util.LinkedList;
import java.util.Queue;

//Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
//
//        NOTE: All the A integers will fit in 32-bit integers.

//output 1, 2, 3, 11, 12, 13, 21
public class ReturnAthSequenceNo {
    public int[] solve(int A) {
        Queue<String> q = new LinkedList<>();
        int[] sol = new int[A];
        q.add("1");
        q.add("2");
        q.add("3");
        for (int i = 0; i < A; i++) {
            String ele = q.remove();
            q.add(ele + "1");
            q.add(ele + "2");
            q.add(ele + "3");
            sol[i] = Integer.parseInt(ele);
        }
        return sol;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    public int[] solve2(int A) {
        // Create an array with a size of A
        int[] ans = new int[A];
        // Create a Queue
        Queue<Integer> queue = new LinkedList<>();
        // Initially, the queue contains the numbers 1, 2, and 3
        queue.add(1);
        queue.add(2);
        queue.add(3);
        // 'i' is used to iterate and count the iterations until it reaches A
        int i = 0;
        while (i < A) {
            // Retrieve and remove the element at the front of the queue
            int num = queue.remove();
            // Store the retrieved number in the ans array, then increment 'i'
            ans[i++] = num;
            // Generate three new numbers by multiplying 'num' by 10 and adding 1, 2, and 3
            // Add these new numbers to the queue for future iterations
            queue.add(num * 10 + 1);
            queue.add(num * 10 + 2);
            queue.add(num * 10 + 3);
        }
        return ans;
    }
}
