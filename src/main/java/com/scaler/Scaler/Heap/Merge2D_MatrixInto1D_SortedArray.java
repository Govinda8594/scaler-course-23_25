package com.scaler.Scaler.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Merge2D_MatrixInto1D_SortedArray {

    public static void main(String[] args) {
        int[][] mat = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
//        List<Integer> result = mergeSortedMatrix(mat);
    }

    public static List<Integer> mergeSortedMatrix2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0) {
                minHeap.offer(new int[]{matrix[i][0], i, 0});
            }
        }
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int val = curr[0], row = curr[1], col = curr[2];
            result.add(val);
            if (col + 1 < matrix[row].length) {
                minHeap.offer(new int[]{matrix[row][col + 1], row, col + 1});
            }
        }
        return result;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static List<Integer> mergeSortedMatrix(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                result.add(anInt);
            }
        }
        Collections.sort(result);
        return result;
    }
}


