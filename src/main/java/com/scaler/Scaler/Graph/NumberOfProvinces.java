package com.scaler.Scaler.Graph;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {


    public static void main(String[] args) {
        int V = 3;
        int[][] adj = {
                {1, 0, 1},
                {0, 1, 1},
                {1, 0, 1}
        };

        NumberOfProvinces sol = new NumberOfProvinces();
        int provinces = sol.numProvinces(adj, V);
        System.out.println("Number of provinces: " + provinces);
    }


    static int numProvinces(int[][] adj, int V) {
        // code here
        int[] parents = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adj[i][j] == 1 && i != j) {
                    unionByRank(i, j, parents, rank);
                }
            }
        }

        Set<Integer> uniqueParents = new HashSet<>();
        for (int i = 0; i < V; i++) {
            uniqueParents.add(findParent(i, parents));
        }

        return uniqueParents.size();
    }

    // static void dfs(int u, boolean[] visited, ArrayList<ArrayList<Integer>> adj, int n) {
    //     if(visited[u]) return;
    //     visited[u] = true;
    //     for (int i = 0; i < n; i++) {
    //             int val = adj.get(u).get(i);
    //             if (val == 1 && u != i) {
    //             dfs(i, visited, adj, n);
    //         }
    //     }
    // }
/*
    Rank: The rank of a node is a rough approximation of its depth in the tree. When two sets are merged, the rank helps decide which tree should be attached under the other tree to keep the structure balanced.

Union: This operation merges two sets. When combining two sets, union by rank ensures the smaller tree (based on rank) is attached under the root of the larger tree.
    * */
    static void unionByRank(int u, int v, int[] parents, int[] rank) {
        int rootU = findParent(u, parents);
        int rootV = findParent(v, parents);
        if (rootU == rootV) {
            return;
        }

        if (rank[rootU] < rank[rootV]) {
            parents[rootU] = rootV;
        } else if (rank[rootU] > rank[rootV]) {
            parents[rootV] = rootU;
        } else {
            parents[rootV] = rootU;
            rank[rootU]++;
        }
    }

    static int findParent(int x, int[] parent) {
        if (parent[x] == x)
            return x;
        return parent[x] = findParent(parent[x], parent);
    }
}
