package com.scaler.Scaler.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//There are a total of A courses you have to take, labeled from 1 to A.
//        Some courses may have prerequisites, for example to take course 2 you have to first take course 1,
//        which is expressed as a pair: [1,2].
//        So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
//        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//        Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
//
//        Problem Constraints
//        1 <= A <= 6*104
//        1 <= length(B) = length(C) <= 105
//        1 <= B[i], C[i] <= A

public class Possibility_of_Finishing {


    static int maxn = 100009;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] visited = new int[maxn];
    static int[] paths = new int[maxn];

    public void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = 0;
            paths[i] = 0;
            adj.add(new ArrayList<Integer>());
        }
    }

    public boolean isCyclicUtil(int v) {
        if (visited[v] == 0) {
            // Mark the current node as visited and part of recursion stack
            visited[v] = 1;
            paths[v] = 1;
            // Recur for all the vertices adjacent to this vertex
            for (int u : adj.get(v)) {
                if (visited[u] == 0 && isCyclicUtil(u)) {
                    return true;
                } else if (paths[u] == 1) {
                    return true;
                }
            }
        }
        paths[v] = 0; // remove the vertex from recursion stack
        return false;
    }

    public int solve1(int A, int[] B, int[] C) {
        graph();
        for (int i = 0; i < B.length; i++) {
            adj.get(B[i]).add(C[i]);
        }

        for (int i = 1; i <= A; i++) {
            if (visited[i] == 0 && isCyclicUtil(i)) {
                return 0;
            }
        }
        return 1;
    }


    /// //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve(int A, int[] B, int[] C) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegreeArr = new int[A + 1];
        graph(A, B, C, inDegreeArr, adj);
        Queue<Integer> pq = new LinkedList<>();
        for (int i = 0; i < inDegreeArr.length; i++) {
            if (inDegreeArr[i] == 0) {
                pq.add(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (!pq.isEmpty()) {
            int temp = pq.poll();
            ans.add(temp);
            for (int v : adj.get(temp)) {
                inDegreeArr[v]--;
                if (inDegreeArr[v] == 0) {
                    pq.offer(v);
                }
            }
        }
        return (ans.size() < A) ? 0 : 1;
    }

    public void graph(int A, int[] B, int[] C, int[] inDegreeArr, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i <= A; i++) {
            inDegreeArr[i] = 0;
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < B.length; i++) {
            adj.get(B[i]).add(C[i]);
            inDegreeArr[C[i]]++;
        }
    }
}
