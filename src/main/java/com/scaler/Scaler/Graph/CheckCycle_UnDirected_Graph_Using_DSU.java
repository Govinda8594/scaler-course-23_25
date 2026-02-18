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
        if (GraphDSU.isCycle(GraphDSU)) {
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

        int find(int[] parent, int i) {
            if (parent[i] == -1) {
                return i;
            }
            return find(parent, parent[i]);
        }

        void Union(int[] parent, int x, int y) {
            int xset = find(parent, x);
            int yset = find(parent, y);
            parent[xset] = yset;
        }

        boolean isCycle(GraphDSU GraphDSU) {
            int[] parent = new int[GraphDSU.V];
            Arrays.fill(parent, -1);
            for (int i = 0; i < GraphDSU.E; ++i) {
                int x = GraphDSU.find(parent, GraphDSU.edge[i].src);
                int y = GraphDSU.find(parent, GraphDSU.edge[i].dest);
                if (x == y) {
                    return true;
                }
                GraphDSU.Union(parent, x, y);
            }
            return false;
        }

        static class Edge {
            int src, dest;
        }
    }

}

