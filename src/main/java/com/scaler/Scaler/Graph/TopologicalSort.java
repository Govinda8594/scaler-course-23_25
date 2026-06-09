package com.scaler.Scaler.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
//Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
//        Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
//        Return the topological ordering of the graph and if it doesn't exist then return an empty array.
//        If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
//        Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
//        NOTE:
//
//        There are no self-loops in the graph.
//        The graph may or may not be connected.
//        Nodes are numbered from 1 to A.
//        Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
//        Problem Constraints
//        2 <= A <= 104
//        1 <= M <= min(100000,A*(A-1))
//        1 <= B[i][0], B[i][1] <= A

public class TopologicalSort {

    static int maxn = 10009;
    static int[] in = new int[maxn];
    static ArrayList<ArrayList<Integer>> adj;

    // BFS approach left to right
    public int[] solve2(int A, int[][] B) {
        graph();
        for (int[] edge : B) {
            adj.get(edge[0]).add(edge[1]);
            in[edge[1]]++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= A; i++) {
            if (in[i] == 0) {
                pq.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            ans.add(temp);
            for (int v : adj.get(temp)) {
                in[v]--;
                if (in[v] == 0) {
                    pq.offer(v);
                }
            }
        }
        if (ans.size() != A) {
            ans.clear();
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            in[i] = 0;
            adj.add(new ArrayList<Integer>());
        }
    }

    /// ////////////////////////////////////////////////////////DFS approach right to left/////////////////////////////////////
    public int[] solve1(int A, int[][] B) {
        graph();
        for (int[] edge : B) {
            adj.get(edge[0]).add(edge[1]);
        }
        return topologicalSort(A);
    }

    void DFSUtil(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        for (int x : adj.get(v)) {
            if (!visited[x]) {
                DFSUtil(x, visited, stack);
            }
        }
//            System.out.println(v+" ");  // print right to left edge
        stack.push(v);
    }

    int[] topologicalSort(int V) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V + 1];
        for (int i = 1; i <= V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited, stack);
            }
        }
        int[] res = new int[V];
        int index = 0;
        // print left to right edge by using stack
        while (!stack.empty()) {
            res[index++] = stack.pop();
        }
        return res;
    }
}
