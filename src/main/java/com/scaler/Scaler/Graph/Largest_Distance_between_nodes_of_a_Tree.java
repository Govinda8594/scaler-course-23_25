package com.scaler.Scaler.Graph;
//Find largest distance Given an arbitrary unweighted rooted tree which consists of N (2 <= N <= 40000) nodes.
//        The goal of the problem is to find largest distance between two nodes in a tree.
//        Distance between two nodes is a number of edges on a path between the nodes
//        (there will be a unique path between any pair of nodes since it is a tree).
//        The nodes will be numbered 0 through N - 1.
//        The tree is given as an array A, there is an edge between nodes A[i] and i (0 <= i < N).
//        Exactly one of the i's will have A[i] equal to -1, it will be root node.
//
//        Problem Constraints
//        2 <= |A| <= 40000

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Largest_Distance_between_nodes_of_a_Tree {
    int ans;

    /// 2 pass DFS
    public int solve2(ArrayList<Integer> A) {
        int n = A.size();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        int root = -1;
        for (int i = 0; i < n; i++) {
            int parent = A.get(i);
            if (parent == -1) {
                root = i;
            } else {
                graph.get(i).add(parent);
                graph.get(parent).add(i);
            }
        }

        // First DFS: find farthest node from root
        int[] farthest = dfs(graph, root, new boolean[n]);

        // Second DFS: find diameter from farthest node
        return dfs(graph, farthest[0], new boolean[n])[1];
    }

    private int[] dfs(List<List<Integer>> graph, int node, boolean[] vis) {
        vis[node] = true;
        int farthestNode = node;
        int maxDistance = 0;

        for (int nei : graph.get(node)) {
            if (!vis[nei]) {
                int[] result = dfs(graph, nei, vis);
                int dist = result[1] + 1;
                if (dist > maxDistance) {
                    maxDistance = dist;
                    farthestNode = result[0];
                }
            }
        }
        return new int[]{farthestNode, maxDistance};
    }

    /// 2 pass BFS /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve2(int[] A) {
        int n = A.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] == -1) root = i;
            else {
                adj.get(i).add(A[i]);
                adj.get(A[i]).add(i); // undirected edges
            }
        }

        // Step 1: BFS from root to find farthest node X
        int X = bfsFarthest(root, adj, n);

        // Step 2: BFS from X to find farthest node Y
        int diameter = bfsDistance(X, adj, n);

        return diameter;
    }

    private int bfsFarthest(int start, List<List<Integer>> adj, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(start);
        visited[start] = true;
        int farthest = start;

        while (!q.isEmpty()) {
            int node = q.poll();
            farthest = node;
            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
        return farthest;
    }

    private int bfsDistance(int start, List<List<Integer>> adj, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(new int[]{start, 0});
        visited[start] = true;
        int maxDist = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], dist = cur[1];
            maxDist = Math.max(maxDist, dist);
            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.add(new int[]{nei, dist + 1});
                }
            }
        }
        return maxDist;
    }

    /// ///////DFS on Tree find largest and second largest distance approach
    int dfsHeight(int root, ArrayList<ArrayList<Integer>> children) {
        int max1 = 0, max2 = 0;
        for (int child : children.get(root)) {
            int h = dfsHeight(child, children);
            if (h > max1) {
                max2 = max1;
                max1 = h;
            } else if (h > max2) {
                max2 = h;
            }
        }
        ans = Math.max(ans, 1 + max1 + max2);
        return 1 + max1;
    }

    public int solve3(int[] A) {
        ans = 0;
        int n = A.length;
        ArrayList<ArrayList<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) children.add(new ArrayList<>());

        int root = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] == -1) root = i;
            else children.get(A[i]).add(i);
        }

        dfsHeight(root, children);
        return ans - 1; // diameter in edges
    }
}
