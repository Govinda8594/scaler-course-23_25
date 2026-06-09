package com.scaler.Scaler.Graph.Algorithm;// Java program for Kruskal's algorithm

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

//TC : ElogE
// SC : N + E
public class KruskalsMST {
    static int kruskalMST(int n, List<Edge> edges) {
        Collections.sort(edges);

        DisjointSetUnion ds = new DisjointSetUnion(n);
        int mstWeight = 0;

        for (Edge edge : edges) {
            int root1 = ds.find(edge.src);
            int root2 = ds.find(edge.dest);

            if (root1 != root2) {  // not in same set then union them
                ds.unionByRank(root1, root2); // add in same set for min edges
                mstWeight += edge.weight;
            }
        }
        return mstWeight;
    }

    public static void main(String[] args) {
        int n = 4;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        int mstWeight = kruskalMST(n, edges);
        System.out.println("Weight of MST is " + mstWeight);
    }

}

class DisjointSetUnion {
    int[] parent, rank;

    DisjointSetUnion(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int node) {
        if (node != parent[node])
            parent[node] = find(parent[node]);
        return parent[node];
    }

    void unionByRank(int root1, int root2) {
//        - Not strictly necessary, because you already passed in the roots (root1, root2) from outside.
//        - Since root1 and root2 are guaranteed to be roots (after the first find), calling find again inside unionByRank is redundant.
//        - However, many implementations still call find inside union for safety:
//        - If someone mistakenly passes non-root nodes to union, it will still work correctly.
//        - It makes the union method more self-contained and robust.

//        int root1 = find(node1);
//        int root2 = find(node2);
        if (root1 != root2) {
            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }

}