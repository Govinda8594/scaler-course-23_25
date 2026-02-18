package com.scaler.Scaler.Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

///// BFS
public class Minimum_Edges_FromV_To_U_Same_Weight {
    public int minEdgeBFS(int u, int v, int n, List<Integer>[] edges) {
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        distance[u] = 0;
        queue.offer(u);
        visited[u] = true;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < edges[x].size(); i++) {
                int neighbor = edges[x].get(i);
                if (visited[neighbor]) {
                    continue;
                }
                distance[neighbor] = distance[x] + 1;
                queue.offer(neighbor);
                visited[neighbor] = true;
            }
        }
        return distance[v];
    }
}
