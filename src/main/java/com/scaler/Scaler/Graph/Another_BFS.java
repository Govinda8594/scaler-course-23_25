package com.scaler.Scaler.Graph;
//Given a weighted undirected graph having A nodes, a source node C and destination node D.
//        Find the shortest distance from C to D and if it is impossible to reach node D from C then return -1.
//        You are expected to do it in Time Complexity of O(A + M).
//        Note:
//        There are no self-loops in the graph.
//        No multiple edges between two Pair5 of vertices.
//        The graph may or may not be connected.
//        Nodes are Numbered from 0 to A-1.
//        Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
//
//        Problem Constraints
//        1 <= A <= 105
//        0 <= B[i][0], B[i][1] < A
//1 <= B[i][2] <= 2
//        0 <= C < A
//0 <= D < A

import java.util.*;

public class Another_BFS {

    /// ////////////////////////////////BFS //////////////////////////////////////////////////////////
    public int solve(int A, int[][] B, int C, int D) {
        int maxn = 2 * A + 5;
        // allow dummy nodes for weight=2 edges
//        - where (u+A) is a new dummy node representing the “middle step”.

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : B) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (w == 1) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            } else {
                // weight = 2
//                You’re solving a shortest path problem where edges can have weight 1 or 2.
//                BFS works only if all edges have equal weight (like 1). To handle weight=2 edges, the trick is:
//                - Transform each weight=2 edge into two weight=1 edges by introducing a dummy node.

                adj.get(u).add(u + A);//- where (u+A) is a new dummy node representing the “middle step”.
                adj.get(u + A).add(v);
                adj.get(v).add(v + A);
                adj.get(v + A).add(u);
            }
        }

        // BFS
        boolean[] visited = new boolean[maxn];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{C, 0});
        visited[C] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], dist = curr[1];

            if (node == D) return dist;

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(new int[]{neighbor, dist + 1});
                }
            }
        }

        return -1; // destination unreachable
    }

    /// /////////////////////////dijkstra////////////////////////////////////////////////////////////////////////

    public int solve2(int A, int[][] B, int C, int D) {
        // Build adjacency list
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : B) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        // Dijkstra setup
        int[] dist = new int[A + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[C] = 0;

        boolean[] visited = new boolean[A + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{C, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], d = curr[1];

            if (!visited[node]) { // u should skip already visited node
                visited[node] = true;
                for (int[] ngb : graph.get(node)) {
                    int next = ngb[0], w = ngb[1];
                    if (!visited[next] && d + w < dist[next]) {
                        dist[next] = d + w;
                        pq.offer(new int[]{next, dist[next]});
                    }
                }
            }
        }

        return dist[D] == Integer.MAX_VALUE ? -1 : dist[D];
    }

}
