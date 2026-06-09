package com.scaler.Scaler.Graph;
//Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
//        More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
//        (i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
//        (i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
//        (i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
//        (i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
//        (i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
//        (i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
//        (i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
//        (i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
//        Return the number of islands.
//        NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
//
//        Problem Constraints
//        1 <= N, M <= 100
//        0 <= A[i] <= 1

public class Number_Of_islands {
    //////////////////////////////Recursive

    static int[] dx = new int[]{0, 1, -1, 0, 1, -1, 1, -1};
    static int[] dy = new int[]{1, 0, 0, -1, -1, 1, 1, -1};
    //////////////////////////Direction Array//////////////////////////////////////////////////////
    static int[][] visited = new int[105][105];

    public static boolean check(int i, int j, int n, int m, int[][] A) {
        return (i >= 0 && i < n && j >= 0 && j < m && (A[i][j] == 1) && visited[i][j] == 0);
    }

    public static void dfs(int i, int j, int n, int m, int[][] A) {
        visited[i][j] = 1;
        int di, dj;
        for (int k = 0; k < 8; ++k) {
            di = i + dx[k];
            dj = j + dy[k];
            if (check(di, dj, n, m, A)) {
                dfs(di, dj, n, m, A);
            }
        }
        //// another way =>direction for -loop
//        for (int dx = -1; dx <= 1; dx++) {
//            for (int dy = -1; dy <= 1; dy++) {
//                if (dx == 0 && dy == 0) {
//                    continue;
//                }
//                di = i + dx;
//                dj = j + dy;
//                if (check(di, dj, n, m, A)) {
//                    dfs(di, dj, n, m, A);
//                }
//            }
//        }
    }

    public int solve2(int[][] A) {
        int count = 0;
        int N = A.length; // Number of rows
        int M = A[0].length; // Number of columns
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1) {
                    DFS(A, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(int[][] A, int i, int j) {
        int N = A.length; // Number of rows
        int M = A[0].length; // Number of columns
        // base case
        if (i < 0 || j < 0 || i >= N || j >= M || A[i][j] == 0) {
            return;
        }
        A[i][j] = 0;
        // call the adjacent sides
        DFS(A, i - 1, j);
        DFS(A, i, j - 1);
        DFS(A, i + 1, j);
        DFS(A, i, j + 1);
        DFS(A, i - 1, j - 1);
        DFS(A, i + 1, j + 1);
        DFS(A, i - 1, j + 1);
        DFS(A, i + 1, j - 1);
    }

    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1 && visited[i][j] == 0) {
                    dfs(i, j, n, m, A);
                    ans++;
                }
            }
        }
        return ans;
    }
}
