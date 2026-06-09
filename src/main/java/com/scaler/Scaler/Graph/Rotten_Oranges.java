package com.scaler.Scaler.Graph;

import java.util.ArrayDeque;

//Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
//        Each cell can have three values:
//        The value 2 representing a rotten orange.
//        Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten.
//        Return the minimum number of minutes that must elapse until no cell has a fresh orange.
//        If this is impossible, return -1 instead.
//        Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
//
//        Problem Constraints
//        1 <= N, M <= 1000
//        0 <= A[i][j] <= 2

public class Rotten_Oranges {

    public int solve(int[][] A) {
        int[][] time = new int[A.length][A[0].length];
        ArrayDeque<Pair> q = new ArrayDeque<Pair>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 2) {
                    time[i][j] = 0;
                    q.addLast(new Pair(i, j));
                } else {
                    time[i][j] = -1;
                }
            }
        }
        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};
        while (!q.isEmpty()) {
            Pair p = q.pop();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                if (nx >= 0 && nx < A.length && ny >= 0 && ny < A[0].length && A[nx][ny] == 1 && time[nx][ny] == -1) {
                    q.addLast(new Pair(nx, ny));
                    time[nx][ny] = time[x][y] + 1;
                }
            }
        }
        int max = -1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (time[i][j] == -1 && A[i][j] == 1) {
                    return -1;
                }
                max = Math.max(max, time[i][j]);
            }
        }
        return max;
    }

    class Pair {
        int x;
        int y;

        public Pair(int i, int j) {
            this.x = i;
            this.y = j;
        }
    }
}
