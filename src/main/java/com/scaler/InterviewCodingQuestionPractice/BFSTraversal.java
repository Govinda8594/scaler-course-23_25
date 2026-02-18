package com.scaler.InterviewCodingQuestionPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFSTraversal {
    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj) {
        // Write your code here
        List<Integer> bfs = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            bfs.add(x);
            for (int node : adj.get(x)) {
                if (!visited[node]) {
                    visited[node] = true;
                    q.add(node);
                }
            }
        }
        return bfs;
    }
}

