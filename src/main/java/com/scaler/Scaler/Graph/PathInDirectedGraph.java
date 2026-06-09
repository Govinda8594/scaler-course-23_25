package com.scaler.Scaler.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
//Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
//        B[i][0] to node B[i][1].
//        Find whether a path exists from node 1 to node A.
//        Return 1 if path exists else return 0.
//        NOTE:
//        There are no self-loops in the graph.
//        There are no multiple edges between two nodes.
//        The graph may or may not be connected.
//        Nodes are numbered from 1 to A.
//        Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
//        Problem Constraints
//        2 <= A <= 105
//        1 <= M <= min(200000,A*(A-1))
//        1 <= B[i][0], B[i][1] <= A

public class PathInDirectedGraph {

    static int maxn = 100009;
    static int[] visited = new int[maxn];
    static ArrayList<ArrayList<Integer>> adj;
    boolean[] visited1;

    public static boolean isReachable(int s, int d) {
        if (s == d) {
            return true;
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        visited[s] = 1;
        while (!q.isEmpty()) {
            s = q.poll();
            for (int v : adj.get(s)) {
                if (v == d) {
                    return true;
                }
                if (visited[v] == 0) {
                    visited[v] = 1;
                    q.offer(v);
                }
            }
        }
        return false;
    }

    public int solve(int A, int[][] B) {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = 0;
            adj.add(new ArrayList<Integer>());
        }
        for (int[] edge : B) {
            adj.get(edge[0]).add(edge[1]);
        }
        if (isReachable(1, A)) {
            return 1;
        }
        return 0;
    }

    /////////////////////////////////////////////////////////////////////DFS
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        visited1 = new boolean[A + 1];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (ArrayList<Integer> integers : B) {
            if (!graph.containsKey(integers.get(0))) {
                graph.put(integers.get(0), new ArrayList<Integer>());
            }
            graph.get(integers.get(0)).add(integers.get(1));
        }
        return DFS(graph, visited1, 1, A);
    }

    private int DFS(HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited, int node, int A) {
        if (A == node) {
            return 1;
        }
        if (graph.get(node) == null) {
            return 0;
        }
        visited[node] = true;
        int ans = 0;
        for (int neb : graph.get(node)) {
            if (!visited[neb]) {
                ans = ans | DFS(graph, visited, neb, A);
            }
        }
        return ans;
    }
}
