package com.scaler.Scaler.BackTracking;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        int[][] solution = new int[maze.length][maze[0].length];
        if (solveMaze(maze, 0, 0, solution)) {
            for (int i = 0; i < solution.length; i++) {
                for (int j = 0; j < solution[0].length; j++) {
                    System.out.print(solution[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution found.");
        }
    }

    public static boolean solveMaze(int[][] maze, int row, int col, int[][] solution) {
        int n = maze.length;
        if (row == n - 1 && col == n - 1) {
            solution[row][col] = 1;
            return true;
        }
        if (isSafe(maze, row, col, n)) {
            solution[row][col] = 1;
            if (solveMaze(maze, row + 1, col, solution)) {
                return true;
            }
            if (solveMaze(maze, row, col + 1, solution)) {
                return true;
            }
            solution[row][col] = 0;
        }
        return false;
    }

    public static boolean isSafe(int[][] maze, int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1;
    }
}
