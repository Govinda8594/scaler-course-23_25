package com.scaler.Scaler.Heap;

import java.util.PriorityQueue;

//Misha loves eating candies. She has been given N boxes of Candies.
//        She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
//        Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?
//        NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
//        NOTE 2: The same box will not be chosen again.
public class MinimumCandiesToEat {

    public int solve(int[] A, int B) {
        // Create a min-heap to store the candies in boxes
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Insert each box's candy count into the min-heap
        for (int i : A) {
            minHeap.add(i);
        }
        int eatenCandy = 0;
        // Process the boxes in the min-heap
        while (!minHeap.isEmpty() && minHeap.peek() <= B) {
            // Remove the box with the minimum candy count
            int firstMin = minHeap.poll();
            // Calculate the number of candies Misha will eat (half of the candy count)
            int takeHalf = firstMin / 2;
            eatenCandy += takeHalf;
            // If there are more boxes remaining, distribute the remaining candies to the next box
            if (!minHeap.isEmpty()) {
                // Remove the box with the second minimum candy count
                int secondMin = minHeap.poll();
                // Add the remaining candies from the first box to the second box
                secondMin += firstMin - takeHalf;
                // add the second box back into the min-heap
                minHeap.add(secondMin);
            }
        }
        return eatenCandy;
    }
}
