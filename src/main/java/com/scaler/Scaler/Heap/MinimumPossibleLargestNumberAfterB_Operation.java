package com.scaler.Scaler.Heap;

import java.util.PriorityQueue;

public class MinimumPossibleLargestNumberAfterB_Operation {

    public int solve(int[] A, int B) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int n = A.length;
        int ans = Integer.MIN_VALUE;
        int[] states = new int[n];
        //pushing next state of all elements into minHeap
        for (int i = 0; i < n; i++) {
            ans = Math.max(A[i], ans);
            minHeap.add(new int[]{A[i] + A[i], i});
        }
        for (int i = 0; i < B; i++) {
            // choosing element contains min value in next state
            int[] temp = minHeap.peek();
            int index = temp[1];
            int val = temp[0];
            states[index] = val;
            minHeap.poll();
            minHeap.add(new int[]{A[index] + val, index});
        }
        //edge case
        if (ans < 0) {
            return ans;
        }
        for (int num : states) {
            ans = Math.max(num, ans);
        }
        return ans;
    }
}
