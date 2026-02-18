package com.scaler.Scaler.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

//N people having different priorities are standing in a queue.
//        The queue follows the property that each person is standing at most
//        B places away from its position in the sorted queue.
//        Your task is to sort the queue in the increasing order of priorities.
//        NOTE:
//        No two persons can have the same priority.
//        Use the property of the queue to sort the queue with complexity O(NlogB).
public class PlacePeopleK_PositionApart {
    public int[] solve2(int[] A, int B) {
        Queue<Integer> q = new PriorityQueue<>();
        for (int j : A) {
            q.offer(j);
        }
        int[] arr = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = q.poll();
        }
        return arr;
    }
}
