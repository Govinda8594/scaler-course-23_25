package com.scaler.Scaler.GreedyProblem;

import java.util.Arrays;
//N Mice and N holes are placed in a straight line. Each hole can accommodate only one mouse.
//        The positions of Mice are denoted by array A, and the position of holes is denoted by array B.
//        A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consume 1 minute.
//        Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.
public class MinimizeMiceToHole {
    public int mice(int[] A, int[] B) {
        Arrays.sort(B);
        Arrays.sort(A);
        int time = 0;
        for (int i = 0; i < A.length; i++) {
            time = Math.max(time, Math.abs(A[i] - B[i]));
        }
        return time;
    }
}
