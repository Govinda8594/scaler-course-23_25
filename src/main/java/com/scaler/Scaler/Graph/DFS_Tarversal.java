package com.scaler.Scaler.Graph;

import java.util.LinkedList;

public class DFS_Tarversal {

    private int V;
    private LinkedList<Integer> adj[];

    DFS_Tarversal(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    public static void main(String args[]) {
        DFS_Tarversal g = new DFS_Tarversal(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Following is Depth First Traversal " +
                "(starting from vertex 2)");
        g.DFS(2);
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }


    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : adj[v]) {
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

}

