package com.scaler.Scaler.Graph;

import java.util.*;

public class Matrix_and_Absolute_Difference {
    int[] row = {0, 0, 1, -1}; // Directions for moving in the grid
    int[] col = {1, -1, 0, 0}; // Right, Left, Down, Up
    /// ////////////////////////////////////Prims
    //        public static void main(String[] args) {
//            Solution solution = new Solution();
//            int[][] C = {
//                    {1, 2, 3},
//                    {4, 5, 6},
//                    {7, 8, 9}
//            };
//            System.out.println(solution.solve5(3, 3, C)); // Example usage
//        }
    private int maxn;
    private List<List<int[]>> adj;
    private boolean[] visited;

    /// //////////////////////////////////////BFS + Prism Algorithm////////////////////////////////////////////////////

    public int solve(int A, int B, int[][] C) {
        maxn = A * B;
        adj = new ArrayList<>(maxn);
        visited = new boolean[maxn];

        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                int u = i * B + j;

                if (i + 1 < A) {
                    int v = (i + 1) * B + j;
                    int w = Math.abs(C[i][j] - C[i + 1][j]);
                    adj.get(u).add(new int[]{v, w});
                    adj.get(v).add(new int[]{u, w});
                }

                if (j + 1 < B) {
                    int v = i * B + (j + 1);
                    int w = Math.abs(C[i][j] - C[i][j + 1]);
                    adj.get(u).add(new int[]{v, w});
                    adj.get(v).add(new int[]{u, w});
                }
            }
        }
        return prims();
    }

    // Prim's algorithm to find the maximum edge weight in the MST
    public int prims() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n[1]));
        pq.offer(new int[]{0, 0}); // (weight, node)
        int maxEdge = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited[curr[0]]) continue;

            visited[curr[0]] = true;
            maxEdge = Math.max(maxEdge, curr[1]);

            for (int[] e : adj.get(curr[0])) {
                if (!visited[e[0]]) {
                    pq.offer(new int[]{e[0], e[1]});
                }
            }
        }
        return maxEdge;
    }

    /// //////////////////////////////////////DSU + Kruskal Algorithm////////////////////////////////////////////////////

    public int solve1(int A, int B, int[][] C) {
        int n = A * B;
        int[] par = new int[n];
        List<int[]> edges = new ArrayList<>(); // each edge: {u, v, w}

        int[] dx = {0, 1};
        int[] dy = {1, 0};

        // Build edge list
        for (int i = 0; i < A; i++) {
            for (int j = 0; j < B; j++) {
                int u = i * B + j;
                for (int k = 0; k < 2; k++) {
                    int xx = i + dx[k];
                    int yy = j + dy[k];
                    if (xx < A && yy < B) {
                        int v = xx * B + yy;
                        int w = Math.abs(C[xx][yy] - C[i][j]);
                        edges.add(new int[]{u, v, w});
                    }
                }
            }
        }

        // Initialize DSU
        for (int i = 0; i < n; i++) par[i] = i;

        // Sort edges by weight
        edges.sort(Comparator.comparingInt(e -> e[2]));

        int ans = 0;
        // Kruskal’s algorithm
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            int pu = findParent(u, par);
            int pv = findParent(v, par);
            if (pu != pv) {
                par[pu] = pv; // union
                ans = Math.max(ans, w); // track max edge in MST
            }
        }
        return ans;
    }

    // Find the root of the node with path compression
    private int findParent(int x, int[] par) {
        if (par[x] != x) {
            par[x] = findParent(par[x], par); // path compression
        }
        return par[x];
    }

    /// ///////////////////////////////////////BFS and Binary Search/////////////////////////////////////////////////////////////////////////
    // Binary search to find the minimum possible difference that allows visiting all cells
    public int solve3(int A, int B, int[][] C) {
        int left = 0, right = (int) 1e9;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (PossibleToVisitAll(mid, C)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // Check if it is possible to visit all cells with the given maximum allowed difference
    boolean PossibleToVisitAll(int diff, int[][] C) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[C.length][C[0].length];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;

        // Perform BFS to visit cells within the allowed difference
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int i = temp[0];
            int j = temp[1];
            for (int k = 0; k < 4; k++) {
                int x = i + row[k];
                int y = j + col[k];
                if (x >= 0 && y >= 0 && x < C.length && y < C[0].length && !visited[x][y] && Math.abs(C[i][j] - C[x][y]) <= diff) {
                    visited[x][y] = true;
                    queue.add(new int[]{x, y});
                }
            }
        }

        // Check if all cells have been visited
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C[0].length; j++) {
                if (!visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}




