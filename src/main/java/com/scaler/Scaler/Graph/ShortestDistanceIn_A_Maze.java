package com.scaler.Scaler.Graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
//        1 represents a wall in a matrix and 0 represents an empty location in a wall.
//        There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right,
//        but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall).
//        When the ball stops, it could choose the next direction.
//        Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.
//        Find the shortest distance for the ball to stop at the destination.
//        The distance is defined by the number of empty spaces traveled by the ball from the starting position
//        (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
//
//        Problem Constraints
//        2 <= N, M <= 100
//        0 <= A[i] <= 1
//        0 <= B[i][0], C[i][0] < N
//0 <= B[i][1], C[i][1] < M

public class ShortestDistanceIn_A_Maze {
    //////////////////////////DFS//////////////////////////////////////////////////////

    public int solve1(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        dfs(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    public void dfs(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        for (int[] dir : dirs) {
            int x = start[0] + dir[0];
            int y = start[1] + dir[1];
            int count = 0;
            while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                x += dir[0];
                y += dir[1];
                count++;
            }
            if (distance[start[0]][start[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                distance[x - dir[0]][y - dir[1]] = distance[start[0]][start[1]] + count;
                dfs(maze, new int[]{x - dir[0], y - dir[1]}, distance);
            }
        }
    }
    ////////////////////////////BFS//////////////////////////////////////////////////////////

    public int solve3(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        distance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int[] dir : dirs) {
                int nrow = p[0];
                int ncol = p[1];
                int count = 0;
                while (canRoll(maze, nrow + dir[0], ncol + dir[1])) {
                    nrow += dir[0];
                    ncol += dir[1];
                    count++;
                }
                // Update the distance[][], and use to check if a position is visited or not
                if (distance[p[0]][p[1]] + count < distance[nrow][ncol]) {
                    distance[nrow][ncol] = distance[p[0]][p[1]] + count;
                    queue.offer(new int[]{nrow, ncol});
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ?
                -1 :
                distance[destination[0]][destination[1]];
    }

    private boolean canRoll(int[][] maze, int nrow, int ncol) {
        int m = maze.length;
        int n = maze[0].length;
        return nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && maze[nrow][ncol] == 0;
    }
}
