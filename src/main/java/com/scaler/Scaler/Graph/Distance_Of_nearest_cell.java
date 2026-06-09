package com.scaler.Scaler.Graph;
//Given a matrix of integers A of size N x M consisting of 0 or 1.
//        For each cell of the matrix find the distance of nearest 1 in the matrix.
//        Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.
//        Find and return a matrix B of size N x M
//        which defines for each cell in A distance of nearest 1 in the matrix A.
//
//        NOTE: There is atleast one 1 is present in the matrix.
//        Problem Constraints
//        1 <= N, M <= 1000
//        0 <= A[i][j] <= 1

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Distance_Of_nearest_cell {
    // Kind of bell-mann ford algorithm
    static int inf = 99999999;
    static int[] dxx = new int[]{0, 1, 0, -1};
    static int[] dyy = new int[]{1, 0, -1, 0};

    public int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        Queue<Pair> q = new ArrayDeque<>();
        int[][] distance = new int[n][m];
        for (int[] row : distance) {
            Arrays.fill(row, inf);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (A[i][j] == 1) {
                    distance[i][j] = 0;
                    q.offer(new Pair(i, j));
                }
            }
        }
        int x, y;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            x = p.ff;
            y = p.ss;
            int dx, dy;
            for (int k = 0; k < 4; ++k) {
                dx = x + dxx[k];
                dy = y + dyy[k];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && distance[x][y] + 1 < distance[dx][dy]) {
                    distance[dx][dy] = distance[x][y] + 1;
                    q.offer(new Pair(dx, dy));
                }
            }
        }
        return distance;
    }

    static class Pair {
        int ff;
        int ss;

        public Pair(int a, int b) {
            this.ff = a;
            this.ss = b;
        }
    }
}
