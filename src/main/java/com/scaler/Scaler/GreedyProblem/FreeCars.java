package com.scaler.Scaler.GreedyProblem;

import java.util.Arrays;
import java.util.PriorityQueue;

//Given two arrays, A and B of size N. A[i] represents the time by which you can buy the ith car without paying any money.
//        B[i] represents the profit you can earn by buying the ith car. It takes 1 minute to buy a car, so you can only buy the ith car when the current time <= A[i] - 1.
//        Your task is to find the maximum profit one can earn by buying cars considering that you can only buy one car at a time.
//        NOTE:
//        You can start buying from time = 0.
//        Return your answer modulo 109 + 7.
public class FreeCars {
    /// /////////////////////////////////////////////////////////////////////////////////////////

    public int solve(int[] A, int[] B) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int[][] car = new int[A.length][2];
        for (int i = 0; i < A.length; i++) {
            car[i][0] = A[i];
            car[i][1] = B[i];
        }
        Arrays.sort(car, (a, b) -> Integer.compare(a[0], b[0]));
        long profit = 0;
        int currTime = 0; // assume current time to buy item
        int mod = 1000000007;
        for (int i = 0; i < A.length; i++) {
            if (currTime <= car[i][0] - 1) { // given current time  <= ith item time  -1
                heap.add(car[i][1]);
                currTime++;
            } else {
                if (!heap.isEmpty() && heap.peek() < car[i][1]) {
                    heap.poll(); // Remove the peek element
                    heap.add(car[i][1]);
                }
            }
        }
        while (!heap.isEmpty()) {
            profit = (profit + heap.poll()) % mod;
        }
        return (int) profit;
    }
}
