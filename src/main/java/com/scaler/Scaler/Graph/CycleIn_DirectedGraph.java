package com.scaler.Scaler.Graph;

import java.util.*;

//Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
//        Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
//        NOTE:
//        The cycle must contain atleast two nodes.
//        There are no self-loops in the graph.
//        There are no multiple edges between two nodes.
//        The graph may or may not be connected.
//        Nodes are numbered from 1 to A.
//        Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
//
//        Problem Constraints
//        2 <= A <= 105
//        1 <= M <= min(200000,A*(A-1))
//        1 <= B[i][0], B[i][1] <= A

public class CycleIn_DirectedGraph {

    static int maxn = 100009;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] visited = new int[maxn];
    static int[] paths = new int[maxn];
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> isVisited = new HashSet<>();

    public static void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = 0;
            paths[i] = 0;
            adj.add(new ArrayList<Integer>());
        }
    }

    public static boolean isCyclicUtil(int v) {
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

    //Solved using Topological sort using Kahn's algorithm (topological sort).
    public boolean bfsCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] indegree = new int[n];

        // Calculate the in-degrees of each vertex
        for (ArrayList<Integer> integers : adj) {
            for (Integer neighbor : integers) {
                indegree[neighbor]++;
            }
        }

        // Initialize the queue with vertices that have an in-degree of 0
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        // Process the queue
        while (!queue.isEmpty()) {
            int u = queue.poll();
            count++;

            // Reduce the in-degree of all adjacent vertices
            for (Integer neighbor : adj.get(u)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If count doesn't match the number of vertices, there is a cycle
        return count != n;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int solve3(int A, int[][] B) {
        for (int i = 1; i <= A; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] ints : B) {
            map.get(ints[0]).add(ints[1]);
        }
        for (int i = 1; i <= A; i++) {
            if (DFS(map.get(i)) == 1) {
                return 1;
            }
            isVisited = new HashSet<>();
        }
        return 0;
    }

    public int DFS(List<Integer> list) {
        for (Integer integer : list) {
            if (isVisited.add(integer)) {
                if (DFS(map.get(integer)) == 1) {
                    return 1;
                }
                isVisited.remove(integer);
            } else {
                return 1;
            }
        }
        return 0;
    }

    ///////////////////////////////////////////////////////////////////////////////
    public int solve(int A, int[][] B) {
        graph();
        for (int[] row : B) {
            adj.get(row[0]).add(row[1]);
        }
        for (int i = 1; i <= A; i++) {
            if (visited[i] == 0 && isCyclicUtil(i)) {
                return 1;
            }
        }
        return 0;
    }
}
