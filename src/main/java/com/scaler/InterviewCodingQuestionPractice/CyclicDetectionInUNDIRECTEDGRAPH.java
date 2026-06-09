package com.scaler.InterviewCodingQuestionPractice;

import java.util.ArrayList;

public class CyclicDetectionInUNDIRECTEDGRAPH {
    public static void main(String[] args) {
//        cycleDetection()
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        ArrayList<Integer>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        boolean[] vis = new boolean[n + 1];
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                if (detectCycleUtil(i, -1, adj, vis)) {
                    return "Yes";
                }
            }
        }
        return "No";
    }

    public static boolean detectCycleUtil(int curr, int parent, ArrayList<Integer>[] adj, boolean[] vis) {
        vis[curr] = true;
        for (int nbr : adj[curr]) {
            if (!vis[nbr]) {
                if (detectCycleUtil(nbr, curr, adj, vis)) {
                    return true;
                }
            } else if (vis[nbr] && nbr != parent) {
                return true;
            }
        }
        return false;
    }
}
