package com.scaler.Scaler.Graph;
//There is a rectangle with left bottom as (0, 0) and right up as (x, y).
//        There are N circles such that their centers are inside the rectangle.
//        Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y)
//        without touching any circle.
//        Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside
//        the boundary of the rectangle at any point of time.
//
//        Problem Constraints
//        0 <= x , y, R <= 100
//        1 <= N <= 1000
//        Center of each circle would lie within the grid
//1st argument given is an Integer x , denoted by A in input.
//
//        2nd argument given is an Integer y, denoted by B in input.
//
//        3rd argument given is an Integer N, number of circles, denoted by C in input.
//
//        4th argument given is an Integer R, radius of each circle, denoted by D in input.
//
//        5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle
//
//        6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Valid_Path {

    static int[] x = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] y = {-1, 1, 0, -1, 1, 0, 1, -1};
    int[] x1 = new int[]{1, 1, 1, 0, 0, -1, -1, -1};
    int[] y1 = new int[]{1, -1, 0, 1, -1, 1, -1, 0};
    boolean[][] visited;


    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        int[][] valid = new int[A + 1][B + 1];
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int z = 0; z < C; z++) {
                    // x square + y square => diameter => root of diameter = radius <= D(Radius)
                    if (Math.sqrt(Math.pow(E.get(z) - i, 2) + Math.pow(F.get(z) - j, 2)) <= D) {
                        valid[i][j] = -1;
                        break;
                    }
                }
            }
        }
        if (valid[0][0] == -1 || valid[A][B] == -1) {
            return "NO";
        }
        boolean[][] v = new boolean[A + 1][B + 1];
        v[0][0] = true;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(0);
        q.add(0);
        while (!q.isEmpty()) {
            int i = q.poll();
            int j = q.poll();
            for (int z = 0; z < 8; z++) {
                int ix = i + x[z];
                int iy = j + y[z];
                if (!(ix < 0 || iy < 0 || ix >= A + 1 || iy >= B + 1) && !v[ix][iy] && valid[ix][iy] != -1) {
                    if (ix == A && iy == B) {
                        return "YES";
                    }
                    q.add(ix);
                    q.add(iy);
                    v[ix][iy] = true;
                }
            }
        }
        return "NO";
    }

    /// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String solve(int x, int y, int noOfCircles, int radius, int[] E, int[] F) {
        int[][] visited = new int[y + 1][x + 1];

        // mark blocked cells
        for (int i = 0; i <= y; i++) {
            for (int j = 0; j <= x; j++) {
                boolean blocked = false;
                for (int k = 0; k < noOfCircles; k++) {
                    int x1 = E[k];
                    int y1 = F[k];
                    double dist = Math.sqrt(Math.pow(j - x1, 2) + Math.pow(i - y1, 2));
                    if (dist <= radius) {
                        blocked = true;
                        break;
                    }
                }
                if (blocked) visited[i][j] = -1; // blocked
            }
        }

        // start or end blocked
        if (visited[0][0] == -1 || visited[y][x] == -1) return "NO";

        return dfs(0, 0, y, x, visited) ? "YES" : "NO";
    }

    boolean dfs(int i, int j, int n, int m, int[][] visited) {
        if (i < 0 || i > n || j < 0 || j > m || visited[i][j] == -1 || visited[i][j] == 1) {
            return false;
        }
        if (i == n && j == m) return true; // reached destination

        visited[i][j] = 1; // mark visited

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;
                int x = i + dx, y = j + dy;
                if (dfs(x, y, n, m, visited)) return true;
            }
        }
        return false;
    }
}
