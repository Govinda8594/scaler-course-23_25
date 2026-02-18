package com.scaler.Scaler.Graph;

import java.util.*;

//Given an integer A, representing number of vertices in a graph.
//        Also you are given a matrix of integers B of size N x 3
//        where N represents number of Edges in a Graph and Triplet (B[i][0], B[i][1], B[i][2])
//        implies there is an undirected edge between B[i][0] and B[i][1] and weight of that edge is B[i][2].
//        Find and return the weight of minimum weighted cycle and if there is no cycle return -1 instead.
//        NOTE: Graph may contain self loops but does not have duplicate edges.
//
//        Problem Constraints
//        1 <= A <= 1000
//        1 <= B[i][0], B[i][1] <= A
//        1 <= B[i][2] <= 100000
public class Minimum_Weighted_Cycle {
    static int maxS = 1001;
    static int[] dist = new int[maxS];
    static int[] visited = new int[maxS];
    static ArrayList<ArrayList<Pair>> adj;
    static int inf = 100001;
    static int maxn = 1009;
    int ans = Integer.MAX_VALUE;

    public int solve(int A, int[][] B) {
        buildGraph();

        // Build adjacency list
        for (int[] arr : B) {
            int u = arr[0], v = arr[1], w = arr[2];
            if (u == v) continue;
            addEdge(u, v, w);
        }


        // Try removing each edge
        for (int[] arr : B) {
            int u = arr[0], v = arr[1], w = arr[2];

            removeEdge(u, v, w);
            int cost = getThroughDijkstra(u, v);
            if (cost != inf) {
                ans = Math.min(ans, cost + w);
            }
            addEdge(u, v, w);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void buildGraph() {
        adj = new ArrayList<>();
        for (int i = 0; i < maxS; i++) {
            dist[i] = 0;
            visited[i] = 0;
            adj.add(new ArrayList<>());
        }
    }

    public static void addEdge(int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
    }

    public static void removeEdge(int u, int v, int w) {
        adj.get(u).remove(new Pair(v, w));
        adj.get(v).remove(new Pair(u, w));
    }

    public static int getThroughDijkstra(int source, int dest) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        for (int i = 0; i < maxn; i++) {
            dist[i] = inf;
            visited[i] = 0;
        }
        dist[source] = 0;
        pq.offer(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int u = temp.node;
            if (visited[u] == 1) continue;
            visited[u] = 1;

            for (Pair edge : adj.get(u)) {
                int v = edge.node, w = edge.weight;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        return dist[dest];
    }

    /// //////////////////////////////DFS/////////////////////////////////////////////////////////

    public int solve2(int A, int[][] B) {
        List<List<int[]>> adjList = new ArrayList<>(A + 1);
        boolean[] cycle = new boolean[A + 1];
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] ints : B) {
            int u = ints[0], v = ints[1], w = ints[2];
            adjList.get(u).add(new int[]{v, w});
            adjList.get(v).add(new int[]{u, w});
        }
        for (int i = 1; i <= A; i++) {
            dfs(i, 0, 0, cycle, adjList);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void dfs(int start, int prev, int sum, boolean[] cycle, List<List<int[]>> adjList) {
        if (cycle[start]) {
            ans = Math.min(ans, sum);
            return;
        }
        cycle[start] = true;
        for (int[] edge : adjList.get(start)) {
            if (edge[0] != prev) {
                dfs(edge[0], start, sum + edge[1], cycle, adjList);
            }
        }
        cycle[start] = false;
    }

    /// /////
    static class Pair {
        int node, weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, weight);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair p)) return false;
            return node == p.node && weight == p.weight;
        }
    }

}



