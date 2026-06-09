package com.scaler.Scaler.Heap;

import java.util.PriorityQueue;

//You are given an array A of integers that represent the lengths of ropes.
//        You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
//        Find and return the minimum cost to connect these ropes into one rope.
public class MininmumCostForConnectingRope {

    public int solve(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cost = 0;
        // insert all elements in the queue
        for (int x : A) {
            pq.offer(x);
        }
        // keep on removing elements from the queue untill there is one element in the queue
        while (pq.size() > 1) {
            // Take the two ropes with smallest length
            int l1 = pq.poll();
            int l2 = pq.poll();
            // cost of combining these two ropes is l1 + l2.
            cost += l1 + l2;
            // add the newly formed rope of length l1 + l2 to the queue.
            pq.offer(l1 + l2);
        }
        return cost;
    }
}
