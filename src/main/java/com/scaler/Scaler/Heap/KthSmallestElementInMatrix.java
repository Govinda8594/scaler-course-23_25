package com.scaler.Scaler.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
//Given a sorted matrix of integers A of size N x M and an integer B.
//        Each of the rows and columns of matrix A is sorted in ascending order, find the Bth smallest element in the matrix.
//        NOTE: Return The Bth smallest element in the sorted order, not the Bth distinct element.


public class KthSmallestElementInMatrix {

    public static void main(String[] args) {
        KthSmallestElementInMatrix kthSmallestElementInMatrix = new KthSmallestElementInMatrix();
        int x = kthSmallestElementInMatrix.solve2(new int[][]{{9, 11, 15},
                {10, 15, 17}}, 2);
    }

    public int solve2(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;

        // Create a min-heap to store elements along with their indices
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> A[a[0]][a[1]] - A[b[0]][b[1]]);

        // Add the first element of each row to the priority queue
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{i, 0});
        }

        // Extract the smallest element B-1 times
        while (B > 1) {
            int[] current = pq.poll();
            int row = current[0];
            int col = current[1];

            // If there's a next element in the same row, add it to the priority queue
            if (col + 1 < m) {
                pq.add(new int[]{row, col + 1});
            }

            B--;
        }

        // The B-th smallest element is now at the top of the priority queue
        int[] result = pq.poll();
        return A[result[0]][result[1]];
    }
    ///////////////////////////////////////////////////////////////////////////

    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ArrayList<Integer> integers : A) {
            for (int j = 0; j < A.get(0).size(); j++) {
                pq.add(integers.get(j));
            }
        }
        int i = 1;
        while (i++ < B) {
            pq.poll();
        }
        return pq.poll();
    }
}
