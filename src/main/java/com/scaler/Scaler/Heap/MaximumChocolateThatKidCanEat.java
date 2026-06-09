package com.scaler.Scaler.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

//Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
//        In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.
//        Find the maximum number of chocolates that the kid can eat in A units of time.
//        NOTE:
//        floor() function returns the largest integer less than or equal to a given number.
//        Return your answer modulo 109+7
public class MaximumChocolateThatKidCanEat {

    public int nchoc(int A, int[] B) {
        int mod = 1000000007;
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int j : B) {
            pq.offer(j);
        }
        while (A > 0) {
            int top = pq.poll();
            ans = ans % mod + top % mod;
            int half = (int) Math.floor((double) top / 2);
            pq.offer(half);
            A--;
        }
        return ans % mod;
    }
}
