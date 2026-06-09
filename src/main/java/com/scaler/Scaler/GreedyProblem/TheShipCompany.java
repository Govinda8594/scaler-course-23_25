package com.scaler.Scaler.GreedyProblem;

import java.util.Collections;
import java.util.PriorityQueue;
//The local ship renting service has a special rate plan:
//
//        It is up to a passenger to choose a ship.
//        If the chosen ship has X (X > 0) vacant places at the given moment, then the ticket for such a ship costs X.
//        The passengers buy tickets in turn, the first person in the queue goes first, then the second one, and so on up to A-th person.
//
//        You need to tell the maximum and the minimum money that the ship company can earn if all A passengers buy tickets.

public class TheShipCompany {
    public static void main(String[] args) {
        solve(4, 3, new int[]{3, 1, 2});
    }

    public static int[] solve(int A, int B, int[] C) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int a : C) {
            maxHeap.offer(a);
            minHeap.offer(a);
        }
        int[] res = new int[2];
        int maxe = 0;
        int mine = 0;
        int passenger = A;
        while (passenger > 0) {
            int val = maxHeap.poll();
            if (val > 1) {
                maxHeap.offer(val - 1);
            }
            maxe += val;
            val = minHeap.poll();
            if (val > 1) {
                minHeap.offer(val - 1);
            }
            mine += val;
            passenger--;
        }
        res[0] = maxe;
        res[1] = mine;
        return res;
    }
}
