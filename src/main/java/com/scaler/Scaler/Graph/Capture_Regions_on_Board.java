package com.scaler.Scaler.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//Given a 2-D board A of size N x M containing 'X' and 'O', capture all regions surrounded by 'X'.
//        A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
//        Problem Constraints
//        1 <= N, M <= 1000
public class Capture_Regions_on_Board {
    /// ///////////////////////////////DFS/////////////////////////////////////////////////////////////''

    int n, m;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve1(ArrayList<ArrayList<Character>> board) {

        if (board == null || board.size() == 0) return;
        n = board.size();
        m = board.get(0).size();

        // Step 1: Traverse boundary 'O's
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
            bfs(board, i, 0);
            bfs(board, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            dfs(board, 0, j);
            dfs(board, n - 1, j);
            bfs(board, 0, j);
            bfs(board, n - 1, j);
        }

        // Step 2: Flip cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board.get(i).get(j) == 'O') {
                    board.get(i).set(j, 'X'); // captured
                } else if (board.get(i).get(j) == 'T') {
                    board.get(i).set(j, 'O'); // revert safe
                }
            }
        }
    }

    private void dfs(ArrayList<ArrayList<Character>> board, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || board.get(i).get(j) != 'O') return;
        board.get(i).set(j, 'T'); // mark safe
        for (int[] d : dirs) {
            dfs(board, i + d[0], j + d[1]);
        }
    }

    private void bfs(ArrayList<ArrayList<Character>> board, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        board.get(i).set(j, 'T');

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dirs) {
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if (x >= 0 && y >= 0 && x < n && y < m && board.get(x).get(y) == 'O') {
                    board.get(x).set(y, 'T');
                    q.add(new int[]{x, y});
                }
            }
        }
    }

    /// /////////////////////////////BFS///////////////////////////////////////////////

    public void solve(ArrayList<ArrayList<Character>> board) {

        int m = board.size(), n = board.get(0).size();
        if (m == 1 && n == 1) {
            return;
        }
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        boolean[][] isvisited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isBorder = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                if (isBorder && board.get(i).get(j) == 'O') {
                    queue.offer(new int[]{i, j}); // add border 'O's to queue
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            isvisited[x][y] = true;
            board.get(x).set(y, '#'); // flip  'O's to '#'s
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (xx >= 0 && xx < m && yy >= 0 && yy < n && !isvisited[xx][yy] && board.get(xx).get(yy) == 'O') {
                    queue.add(new int[]{xx, yy});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board.get(i).get(j) == 'O') {
                    board.get(i).set(j, 'X'); // flip remaining 'O's to 'X's
                } else if (isvisited[i][j]) {
                    board.get(i).set(j, 'O'); // flip '#'s to 'O's
                }
            }
        }
    }
}
