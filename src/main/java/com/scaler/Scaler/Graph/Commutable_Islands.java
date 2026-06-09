package com.scaler.Scaler.Graph;
//There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
//        We need to find bridges with minimal cost such that all islands are connected.
//        It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
//
//        Problem Constraints
//        1 <= A, M <= 6*104
//        1 <= B[i][0], B[i][1] <= A
//        1 <= B[i][2] <= 103

import java.util.*;

public class Commutable_Islands {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(new ArrayList<>(Arrays.asList(1, 2, 1)));
        B.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        B.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
        Commutable_Islands ci = new Commutable_Islands();
        System.out.println(ci.solve(3, B));
    }

//////////////////////////////DSU by path comparsion/Kruskal ///////////////////////////////////////////////////////

    public int solve2(int A, ArrayList<ArrayList<Integer>> B) {
        // sort the edges according to the ascending order of costs
        B.sort((a, b) -> a.get(2) - b.get(2));
        int cost = 0;
        int[] parent = new int[A + 1];
        for (int i = 0; i < A + 1; i++) {
            // initializing parent with i
            parent[i] = i;
        }
        for (ArrayList<Integer> integers : B) {
            int root1 = findRoot(parent, integers.get(0));
            int root2 = findRoot(parent, integers.get(1));
            if (root1 != root2) {
                parent[root1] = root2;
                cost += integers.get(2);
            }
        }
        return cost;
    }

    public int findRoot(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findRoot(parent, parent[node]);
    }

    //////////////////////////////////////////////////Prism Alogrithm///////////////////////////////////////////////
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        boolean[] visited = new boolean[A + 1];
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }
        for (ArrayList<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);
            int c = edge.get(2);
            graph.get(u).add(new int[]{v, c});
            graph.get(v).add(new int[]{u, c});
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(p -> p[1]));
        q.add(new int[]{1, 0});
        return prims(graph, q, visited);
    }

    public int prims(List<List<int[]>> graph, PriorityQueue<int[]> q, boolean[] visited) {
        int mincost = 0;
        while (!q.isEmpty()) {
            int[] node_cost = q.poll();
            int u = node_cost[0];
            int c = node_cost[1];
            if (!visited[u]) {
                visited[u] = true;
                mincost += c;
                for (int[] neighbor : graph.get(u)) {
                    if (!visited[neighbor[0]]) {
                        q.add(neighbor);
                    }
                }
            }
        }
        return mincost;
    }

}
