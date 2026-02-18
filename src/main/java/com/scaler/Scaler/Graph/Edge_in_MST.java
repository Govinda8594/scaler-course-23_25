package com.scaler.Scaler.Graph;
//Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of
// 2D-matrix B of size M * 3 where B[i][0] and B[i][1]
// denotes the two nodes connected by an edge of weight B[i][2].
//        For each edge check whether it belongs to any of the possible minimum spanning tree or not ,
//        return 1 if it belongs else return 0.
//        Return an one-dimensional binary array of size M denoting answer for each edge.
//        NOTE:
//        The graph may be disconnected in that case consider mst for each component.
//        No self-loops and no multiple edges present.
//        Answers in output array must be in order with the input array B output[i] must
//        denote the answer of edge B[i][0] to B[i][1].
//
//        Problem Constraints
//        1 <= A, M <= 3*105
//        1 <= B[i][0], B[i][1] <= A
//        1 <= B[i][1] <= 103

import java.util.Arrays;
import java.util.Comparator;

public class Edge_in_MST {
    int[] parent, rank;

    // Find the parent of a node with path compression
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return;
        if (rank[rx] < rank[ry]) parent[rx] = ry;
        else if (rank[rx] > rank[ry]) parent[ry] = rx;
        else {
            parent[ry] = rx;
            rank[rx]++;
        }
    }

    // Solve function to initiate DSU and return the result
    public int[] solve(int A, int[][] B) {
        parent = new int[A + 1];
        rank = new int[A + 1];
        int M = B.length;
        int[] ans = new int[M];
        // Initialize parent array with each node being its own parent
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
        }
        // edges with index
        int[][] edges = new int[M][4];
        for (int i = 0; i < M; i++) {
            edges[i][0] = B[i][0]; // u node
            edges[i][1] = B[i][1]; // v node
            edges[i][2] = B[i][2]; // weight
            edges[i][3] = i;  // index
        }
        // sort by weight
        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));


        int j = 0;
        // Iterate over edges to build MST and mark used edges and THEN TAKING THE UNION
        for (int i = 0; i < B.length; i++) {
            // Process all edges with the same weight
            while (j < B.length && edges[j][2] == edges[i][2]) {
                int parent1 = find(edges[j][0]);
                int parent2 = find(edges[j][1]);

                // If nodes have different parents, mark the edge as used
                if (parent1 != parent2) {
                    ans[edges[j][3]] = 1;
                }
                j++;
            }
            // Union the nodes of the current edge
            union(edges[i][0], edges[i][1]);
        }
        return ans;
    }

}
