package com.scaler.Scaler.Graph.Algorithm;
//Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
//        You have to find an integer array D of size A such that:
//        D[i]: Shortest distance from the C node to node i.
//        If node i is not reachable from C then -1.
//        Note:
//
//        There are no self-loops in the graph.
//        There are no multiple edges between two Pair1s of vertices.
//        The graph may or may not be connected.
//        Nodes are numbered from 0 to A-1.
//        Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
//
//        Problem Constraints
//        1 <= A <= 1e5
//        0 <= B[i][0],B[i][1] < A
//0 <= B[i][2] <= 1e3
//        0 <= C < A

import java.util.*;
//TC : O(E log E + N)
//SC : O(E + N)
public class Dijsktra {

    static int maxn = 100009;
    static int[] vis = new int[maxn];
    static ArrayList<ArrayList<Pair>> adj;

    public static void graph() {
        adj = new ArrayList<ArrayList<Pair>>(maxn);
        for (int i = 0; i < maxn; i++) {
            vis[i] = 0;
            adj.add(new ArrayList<Pair>());
        }
    }

    public static int[] dijkstra(int n, int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(Comparator.comparingInt(pair -> pair.wt));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        pq.offer(new Pair(0, source));
        while (!pq.isEmpty()) {
            Pair temp = pq.poll();
            int u = temp.v;
            if (vis[u] == 1) {
                continue;
            }
            vis[u] = 1;
            for (Pair edge : adj.get(u)) {
                int v = edge.v, w = edge.wt;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Pair(dist[v], v));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) { // any moment not able to reach all vertices
                dist[i] = -1;
            }
        }
        return dist;
    }

    public static int minWeightPath(int V, List<List<Edge>> graph, int u, int v) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[u] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(u, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int node = curr.to;
            int cost = curr.weight;

            if (node == v) return cost;

            for (Edge neighbor : graph.get(node)) {
                int next = neighbor.to;
                int newCost = cost + neighbor.weight;
                if (newCost < dist[next]) {
                    dist[next] = newCost;
                    pq.add(new Edge(next, newCost));
                }
            }
        }

        return -1; // If v is unreachable
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Add edges with weights 1 or 2
        graph.get(0).add(new Edge(1, 1));
        graph.get(1).add(new Edge(0, 1));

        graph.get(1).add(new Edge(2, 2));
        graph.get(2).add(new Edge(1, 2));

        graph.get(0).add(new Edge(3, 2));
        graph.get(3).add(new Edge(0, 2));

        graph.get(3).add(new Edge(4, 1));
        graph.get(4).add(new Edge(3, 1));

        graph.get(4).add(new Edge(5, 1));
        graph.get(5).add(new Edge(4, 1));

        int u = 0, v = 5;
        int minCost = minWeightPath(V, graph, u, v);
        System.out.println("Minimum weight from node " + u + " to node " + v + " is: " + minCost);
    }

    public int[] solve(int A, int[][] B, int C) {
        graph();
        for (int[] edge : B) {
            adj.get(edge[0]).add(new Pair(edge[2], edge[1]));
            adj.get(edge[1]).add(new Pair(edge[2], edge[0]));
        }
        return dijkstra(A, C);
    }

    static class Pair {
        int wt, v;

        public Pair(int a, int b) {
            this.wt = a;
            this.v = b;
        }
    }

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

}


