package com.scaler.Scaler.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

//Given a undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there is an edge between B[i][0] and B[i][1].
//        Find whether the given graph is bipartite or not.
//        A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph has one node in A and another node in B
//        Note:
//        There are no self-loops in the graph.
//        No multiple edges between two pair of vertices.
//        The graph may or may not be connected.
//        Nodes are Numbered from 0 to A-1.
//        Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
//
//        Problem Constraints
//        1 <= A <= 100000
//        1 <= M <= min(A*(A-1)/2,200000)
//        0 <= B[i][0],B[i][1] < A
public class Check_Bipartite_Graph {

    static int maxn = 100009;
    static ArrayList<ArrayList<Integer>> graph;
    ArrayList<ArrayList<Integer>> adj;
    int[] col;

    public int solve(int A, int[][] B) {
        graphC();
        for (int[] edge : B) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        if (isBipar(A)) {
            return 1;
        }
        return 0;
    }

    /// /////////////////////////////////////BFS
    public static void graphC() {
        graph = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            graph.add(new ArrayList<Integer>());
        }
    }

    public static boolean isBipar(int n) {
        if (n == 0) {
            return true;
        }
        int[] color = new int[n];
        Arrays.fill(color, -1);
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            if (color[i] != -1) { // already colored
                continue;
            }
            color[i] = 1;
            q.offer(i);
            while (!q.isEmpty()) {
                int x = q.poll();
                for (int it : graph.get(x)) {
                    if (color[it] == -1) {
                        color[it] = color[x] ^ 1; // 1 - cor of x
                        q.offer(it);
                    } else if (color[it] == color[x]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve3(int A, int[][] B) {
        adj = new ArrayList<ArrayList<Integer>>(); // Adjancency List.
        col = new int[A];  // Colour array to assign colours to the nodes, (0,1). It also tracks if the node has been visited or not.
        Arrays.fill(col, -1);
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // Making Adjancency List of Undirected Graph
        for (int[] ints : B) {
            adj.get(ints[0]).add(ints[1]);
            adj.get(ints[1]).add(ints[0]);
        }

        // other way to check isbipartite graph
//        col[0] = 0;
//        boolean isbirate = dfs_isBirate(0);

        // Looping over all the nodes taking them as source, if they are not visited.
        for (int i = 0; i < A; i++) {
            if (col[i] == -1) {
                col[i] = 0;
                if (!dfs_checkBipartite(i)) { // not bipartite
                    return 0;
                }
            }
        }
        return 1;
    }

    // Function to check do the dfs traversal if with source s, the given graph is bipartite.
    public boolean dfs_checkBipartite(int s) {
        for (int ngb : adj.get(s)) {
            if (col[ngb] == col[s]) {
                return false;
            } else if (col[ngb] == -1) {
                col[ngb] = 1 - col[s];
                if (!dfs_checkBipartite(ngb)) {
                    return false;
                }
            }
        }
        return true;
    }
}
