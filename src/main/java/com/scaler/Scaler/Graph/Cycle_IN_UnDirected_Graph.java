package com.scaler.Scaler.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Cycle_IN_UnDirected_Graph {
    public static void main(String[] args) {
        Cycle_IN_UnDirected_Graph Cycle_IN_UnDirected_Graph = new Cycle_IN_UnDirected_Graph();

        // Example graph with a cycle
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        int vertices = 5; // Number of vertices
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to create an undirected graph
        adj.get(0).add(1);
        adj.get(1).add(0); // As the graph is undirected

        adj.get(1).add(2);
        adj.get(2).add(1); // As the graph is undirected

        adj.get(2).add(0);
        adj.get(0).add(2); // This creates a cycle (0 -> 1 -> 2 -> 0)

        adj.get(3).add(4);
        adj.get(4).add(3); // No cycle in this component

        System.out.println(Cycle_IN_UnDirected_Graph.isCycle(adj)); // Should print true as there is a cycle
    }

    // Function to detect cycle in an undirected graph
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        int v = adj.size();
        boolean[] visited = new boolean[v];

        // If cycle exists → not a tree, for BFS
        if (bfsIsCycle(0, adj, visited))
            return true;
        // If cycle exists → not a tree, for DFS
        if (isCycleDFS(0, visited, -1, adj))
            return true;

//        either of 2 for loop is checking if graph is connected, use either one.
// Check connectivity: all nodes must be visited for undirected graph, exception to directed graph
        for (boolean u : visited) {
            if (!u) return false;
        }
        // return true
        int count = 0;
        for (int i = 0; i < v; i++) // count for connected graph all node
            if (visited[i])
                count++;
        return count == v;
    }

    // Helper method to perform DFS and check for cycle
    private boolean isCycleDFS(int u, boolean[] visited, int parent, ArrayList<ArrayList<Integer>> adj) {
        visited[u] = true; // Mark the current node as visited

        // Traverse all adjacent nodes
        for (Integer v : adj.get(u)) {
            // If the adjacent node is not visited, perform DFS
            if (!visited[v]) {
                if (isCycleDFS(v, visited, u, adj)) {
                    return true;
                }
            }
            // If an adjacent node is visited and is not the parent, a cycle is found
            else if (v != parent) {
                return true;
            }
        }
        return false;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////

    boolean bfsIsCycle(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        // this queue will store int[]{node, parent}
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        // mark the node as visited & push it into queue
        vis[node] = true;
        queue.add(new int[]{node, -1});

        while (!queue.isEmpty()) {
            int[] top = queue.pop();
            int currentNode = top[0];
            int currentParent = top[1];

            for (int neigh : adj.get(currentNode)) {
                if (neigh == currentParent) continue;

                if (vis[neigh]) return true;

                vis[neigh] = true;
                queue.add(new int[]{neigh, currentNode});
            }
        }

        return false;
    }
}
