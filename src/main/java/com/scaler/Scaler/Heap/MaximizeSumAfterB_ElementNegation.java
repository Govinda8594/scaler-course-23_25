package com.scaler.Scaler.Heap;

import java.util.PriorityQueue;

//Given an array of integers A and an integer B. You must modify the array exactly B number of times. In a single modification, we can replace any one array element A[i] by -A[i].
//        You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.
//        NOTE: You can perform the modification on the same element multiple times.
public class MaximizeSumAfterB_ElementNegation {

    public static void main(String[] args) {
        MaximizeSumAfterB_ElementNegation maximizeSumAfterBElementNegation = new MaximizeSumAfterB_ElementNegation();
        maximizeSumAfterBElementNegation.solve(new int[]{24, -68, -29, -9, 84}, 4);
    }

    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : A) {
            pq.add(a);
        }
        while (B-- > 0) {
            pq.add(-pq.poll());
        }
        int sum = 0;
        for (int a : pq) {
            sum += a;
        }
        return sum;
    }
}
