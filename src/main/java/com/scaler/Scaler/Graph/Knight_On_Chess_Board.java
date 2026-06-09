package com.scaler.Scaler.Graph;
//Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.
//        The above figure details the movements for a knight ( 8 possibilities ).
//        If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.
//        NOTE: A knight cannot go out of the board.
//
//        Problem Constraints
//        1 <= A, B <= 500

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Knight_On_Chess_Board {
    ////////////////////////////Using BFS and Priority Queue////////////////////////////////////////////////////////////////

    int[] x = {-1, -2, -2, -1, 1, 2, 2, 1};
    int[] y = {2, 1, -1, -2, -2, -1, 1, 2};

    public int knight5(int A, int B, int C, int D, int E, int F) {
        if (E > A || F > B || E < 1 || F < 1) {
            return -1;
        }
        boolean[][] vis = new boolean[A + 1][B + 1];
        int[][] dist = new int[A + 1][B + 1];
        Queue<Pair> queue = new LinkedList<>();
        dist[C][D] = 0;
        vis[C][D] = true;
        queue.add(new Pair(C, D));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int a = pair.x;
            int b = pair.y;
            if (a == E && b == F) {
                break;
            }
            for (int i = 0; i < 8; i++) {
                int xx = a + x[i];
                int yy = b + y[i];
                if (xx > 0 && xx <= A && yy > 0 && yy <= B && !vis[xx][yy]) {
                    queue.add(new Pair(xx, yy));
                    vis[xx][yy] = true;
                    dist[xx][yy] = 1 + dist[a][b];
                }
            }
        }
        if (vis[E][F]) {
            return dist[E][F];
        } else {
            return -1;
        }
    }

    public int knight7(int A, int B, int C, int D, int E, int F) {
        if (E > A || F > B) {
            return -1;
        }
        int[][] minPath = new int[A + 1][B + 1];
        for (int[] x : minPath) {
            Arrays.fill(x, -1);
        }
        int[] row = new int[]{-2, -1, 1, 2};
        int[] col = new int[]{-2, -1, 1, 2};
        PriorityQueue<node> pq = new PriorityQueue<>((a, b) -> a.step - b.step);
        minPath[C][D] = 0;
        pq.add(new node(C, D, 0));
        while (!pq.isEmpty()) {
            node curr = pq.poll();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Math.abs(row[i]) != Math.abs(col[j])) {
                        int dx = curr.row + row[i];
                        int dy = curr.col + col[j];
                        int dstep = curr.step + 1;
                        if (dx > 0 && dy > 0 && dx <= A && dy <= B && minPath[dx][dy] == -1) {
                            pq.add(new node(dx, dy, dstep));
                            minPath[dx][dy] = dstep;
                        }
                    }
                }
            }
        }
        return minPath[E][F];
    }

    static class Pair {
        int x, y;

        Pair(int i, int j) {
            x = i;
            y = j;
        }
    }

    static class node {
        int row;
        int col;
        int step;

        node(int r, int c, int s) {
            row = r;
            col = c;
            step = s;
        }
    }


}
