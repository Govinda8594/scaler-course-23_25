package com.scaler.Scaler.Graph;

import java.util.Arrays;

public class CheckCycle_UnDirected_Graph_Using_DSU {
    public static void main(String[] args) {
        GraphDSU GraphDSU = new GraphDSU(3, 3);
        GraphDSU.edge[0].src = 0;
        GraphDSU.edge[0].dest = 1;
        GraphDSU.edge[1].src = 1;
        GraphDSU.edge[1].dest = 2;
        GraphDSU.edge[2].src = 0;
        GraphDSU.edge[2].dest = 2;
        if (GraphDSU.isCycle()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contain cycle");
        }
    }

    static class GraphDSU {
        int V, E;
        Edge[] edge;

        GraphDSU(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i) {
                edge[i] = new Edge();
            }
        }

        // 1. Optimized Find (with Path Compression)
        int find(int[] parent, int i) {
            if (parent[i] == i)
                return i;
            return parent[i] = find(parent, parent[i]); // Path compression happens here
        }

        // 2. Optimized Union (with Union by Rank)
        void union(int[] parent, int[] rank, int xroot, int yroot) {
            if (rank[xroot] < rank[yroot]) {
                parent[xroot] = yroot;
            } else if (rank[xroot] > rank[yroot]) {
                parent[yroot] = xroot;
            } else {
                parent[yroot] = xroot;
                rank[xroot]++;
            }
        }

        // 3. Cycle Detection Logic
        boolean isCycle() {
            int[] parent = new int[V];
            int[] rank = new int[V];

            // Initialize: every node is its own parent (rank 0)
            for (int i = 0; i < V; i++) {
                parent[i] = i;
                rank[i] = 0;
            }

            for (int i = 0; i < E; i++) {
                int x = find(parent, edge[i].src);
                int y = find(parent, edge[i].dest);

                // If roots are the same, we found a cycle!
                if (x == y) return true;

                // Otherwise, combine the two sets
                union(parent, rank, x, y);
            }
            return false;
        }

        static class Edge {
            int src, dest;
        }
    }

}

