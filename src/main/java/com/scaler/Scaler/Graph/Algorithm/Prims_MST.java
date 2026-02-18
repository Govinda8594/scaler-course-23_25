package com.scaler.Scaler.Graph.Algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prims_MST {
    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Add edges (undirected)
        graph.get(0).add(new Edge(1, 2));
        graph.get(1).add(new Edge(0, 2));

        graph.get(0).add(new Edge(3, 6));
        graph.get(3).add(new Edge(0, 6));

        graph.get(1).add(new Edge(2, 3));
        graph.get(2).add(new Edge(1, 3));

        graph.get(1).add(new Edge(3, 8));
        graph.get(3).add(new Edge(1, 8));

        graph.get(1).add(new Edge(4, 5));
        graph.get(4).add(new Edge(1, 5));

        graph.get(2).add(new Edge(4, 7));
        graph.get(4).add(new Edge(2, 7));

        Prims_MST solver = new Prims_MST();
        int cost = solver.primMST(V, graph);
        System.out.println("Minimum Spanning Tree cost: " + cost);
    }

    public int primMST(int V, List<List<Edge>> graph) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(0, 0)); // Start from node 0
        int totalCost = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (visited[curr.to]) continue;

            visited[curr.to] = true;
            totalCost += curr.weight;

            for (Edge neighbor : graph.get(curr.to)) {
                if (!visited[neighbor.to]) {
                    pq.add(neighbor);
                }
            }
        }

        return totalCost;
    }

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
}
