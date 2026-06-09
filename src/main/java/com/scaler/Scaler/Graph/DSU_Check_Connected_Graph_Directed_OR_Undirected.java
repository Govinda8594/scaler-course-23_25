package com.scaler.Scaler.Graph;

import java.util.Arrays;
import java.util.List;

public class DSU_Check_Connected_Graph_Directed_OR_Undirected {
    static int[] parent;
    static int[] rank;

    // Initialize DSU
    static void makeSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;   // each node is its own parent
            rank[i] = 0;
        }
    }

    // Find with path compression
    static int find(int node) {
        if (node != parent[node]) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    // Union by rank
    static void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootU] > rank[rootV]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    // Check if graph is connected
    static boolean isConnected(int n, List<int[]> edges) {
        makeSet(n);

        // Union all edges
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        // Find root of first node
        int root = find(1);

        // Check if all nodes have same root
        for (int i = 2; i <= n; i++) {
            if (find(i) != root) {
                return false;
            }
        }
        return true;
    }

    // Example usage
    static void main(String[] args) {
        int n = 5; // number of nodes
        List<int[]> edges = Arrays.asList(
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
                new int[]{4, 5}
        );

        if (isConnected(n, edges)) {
            System.out.println("Graph is connected");
        } else {
            System.out.println("Graph is not connected");
        }
    }
}

class DSU_Check_Connected_Graph_Directed_OR_Undirected_Not_Optimized {

    static int[] parent;
    static int[] rank;

    // Check if graph is connected
    static boolean isConnected(int n, List<int[]> edges) {
        makeSet(n);

        // Union all edges
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
        }

        // Find root of first node
        int root = find(1);

        // Check if all nodes have same root
        for (int i = 2; i <= n; i++) {
            if (find(i) != root) {
                return false;
            }
        }
        return true;
    }

    // Initialize DSU
    static void makeSet(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;   // each node is its own parent
        }
    }

    // Union by rank
    static boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU == rootV)
            return false;
        parent[rootU] = rootV;
        return true;
    }

    static int find(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }
}
