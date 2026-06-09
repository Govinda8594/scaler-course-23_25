package com.scaler.Scaler.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinPathWithDummyNodes {
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {
                {0, 1, 1},
                {1, 2, 2},
                {0, 3, 2},
                {3, 4, 1},
                {4, 5, 1}
        };
        int u = 0, v = 5;

        MinPathWithDummyNodes solver = new MinPathWithDummyNodes();
        int result = solver.minPath(V, edges, u, v);
        System.out.println("Minimum path from " + u + " to " + v + " is: " + result);
    }

    public int minPath(int V, int[][] edges, int u, int v) {
        // Create adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        int dummyId = V; // Start dummy node IDs after original nodes

        for (int i = 0; i < V + edges.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1], wt = edge[2];
            if (wt == 1) {
                graph.get(a).add(b);
                graph.get(b).add(a);
            } else if (wt == 2) {
                // Add dummy node
                graph.get(a).add(dummyId);
                graph.get(dummyId).add(a);
                graph.get(dummyId).add(b);
                graph.get(b).add(dummyId);
                dummyId++;
            }
        }

        // BFS from u to v
        boolean[] visited = new boolean[dummyId];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        visited[u] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int curr = queue.poll();
                if (curr == v) return steps;

                for (int neighbor : graph.get(curr)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            steps++;
        }

        return -1; // Not reachable
    }
}