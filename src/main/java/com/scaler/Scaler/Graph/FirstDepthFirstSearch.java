package com.scaler.Scaler.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
//        Given 2 towns find whether you can reach the first town from the second without repeating any edge.
//        B C : query to find whether B is reachable from C.
//        Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
//        There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
//        NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
//
//        Problem Constraints
//        1 <= N <= 100000
public class FirstDepthFirstSearch {

    // APPROACH 1:BFS
    boolean[] visited;

    public int solve1(ArrayList<Integer> A, final int B, final int C) {
        int n = A.size();
        if (n == 1) {
            return 1;
        }
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        visited = new boolean[n + 1];
        for (int i = 1; i < n; i++) {
            int node = A.get(i);
            if (!graph.containsKey(node)) {
                graph.put(node, new ArrayList<>());
            }
            graph.get(node).add(i + 1);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(C);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (poll == B) {
                return 1;
            }
            if (graph.get(poll) == null) {
                continue;
            }
            visited[poll] = true;
            for (int neb : graph.get(poll)) {
                if (!visited[neb]) {
                    queue.add(neb);
                }
            }
        }
        return 0;
    }

    ///////////////////////////////////////////////////////////////////////
    public int solve5(int[] A, final int B, final int C) {
        int n = A.length;
        // Special case handling when there is only one town
        if (n == 1) {
            // Since there is only one town, it is always reachable from itself
            return 1;
        }
        // Create a HashMap to represent the adjacency list of the graph
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        // Create a boolean array to track visited towns during DFS traversal
        boolean[] visited = new boolean[n + 1];
        // Build the adjacency list by iterating over the input array A
        for (int i = 1; i < n; i++) {
            int node = A[i];
            // If the graph does not contain the current node, add it to the HashMap
            if (!graph.containsKey(node)) {
                graph.put(node, new ArrayList<>());
            }
            // Add the current node's neighbor (i + 1) to its adjacency list
            graph.get(node).add(i + 1);
        }
        // Perform DFS traversal to check if B is reachable from C
        return DFS(B, C, graph, visited);
    }

    private int DFS(int destination, int current, HashMap<Integer, ArrayList<Integer>> graph, boolean[] visited) {
        // If the current town is the destination, return 1 to indicate reachability
        if (current == destination) {
            return 1;
        }
        // If the current town does not have outgoing edges, return 0
        if (!graph.containsKey(current)) {
            return 0;
        }
        // Mark the current town as visited
        visited[current] = true;
        int result = 0;
        // Iterate over the neighboring towns of the current town
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                // Recursively call DFS on unvisited neighbors
                result = DFS(destination, neighbor, graph, visited);
                // If a successful path to the destination is found, return 1
                if (result == 1) {
                    return 1;
                }
            }
        }
        // Return the result of the DFS traversal (0 if no path to destination is found)
        return result;
    }
}
