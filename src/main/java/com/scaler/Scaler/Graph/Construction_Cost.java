package com.scaler.Scaler.Graph;
//Given a graph with A nodes and C weighted edges.
// Cost of constructing the graph is the sum of weights of all the edges in the graph.
//        Find the minimum cost of constructing the graph by
//        selecting some given edges such that we can reach every other node from the 1st node.
//        NOTE: Return the answer modulo 109+7 as the answer can be large.
//
//        Problem Constraints
//        1 <= A <= 100000
//        0 <= C <= 100000
//        1 <= B[i][0], B[i][1] <= N
//        1 <= B[i][2] <= 109

import java.util.*;

public class Construction_Cost {
    static class Pair4 implements Comparable<Pair4> {
        int u;
        int v;
        int weight;

        public Pair4(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair4 o) {
            return this.weight - o.weight;
        }

        public int solve(int A, int[][] B) {
            long minCost = 0;
            long m = 1000000007;
            // build edge list
            List<Pair4> list = new ArrayList<>();
            for (int[] ints : B) {
                int u = ints[0];
                int v = ints[1];
                int weight = ints[2];
                list.add(new Pair4(u, v, weight));
            }
            // sort the edges by weight in ascending order => kruskal alogo
            Collections.sort(list);
            // initialize parent array. this means every node is parent of itself[each node
            // represents unique connect component initially]
            int[] parent = new int[A + 1];
            for (int i = 1; i <= A; i++) {
                parent[i] = i;
            }
            // check for edge if it can be considered in minimum spanning tree
            for (Pair4 edge : list) {
                // union method combines 2 different components at a given time
                if (union(edge, parent)) {
                    // if edge is considered, add weight to cost
                    minCost = ((minCost % m) + ((long) edge.weight % m)) % m;
                }
            }
            return (int) minCost;
        }

        private boolean union(Pair4 edge, int[] parent) {
            // find parent of source and target node of edge
            int x = edge.u;
            int y = edge.v;
            int parent_x = findParent(x, parent);
            int parent_y = findParent(y, parent);
            // if x and y are part of different components, only then combine them
            if (parent_x != parent_y) {
                parent[parent_x] = parent_y;
                return true;
            }
            // return false when x and y are part of same component
            return false;
        }

        private int findParent(int x, int[] parent) {
            // base condition when parent of x = x
            if (parent[x] == x) {
                return x;
            }
            // find top most parent of x
            parent[x] = findParent(parent[x], parent);
            return parent[x];
        }
////////////////////////////Prism Algo////////////////////////////////////////////////////////////

        public int solve1(int A, int[][] B) {
            int[] visited = new int[A + 1];
            int n = B.length;
            //prims algorithm needs first node to be least weighted node..
            //so, sorting it based on weight.
            Arrays.sort(B, (a, b) -> a[2] - b[2]);
            //create a Adjacency list
            //since it is list, order of insertion preserved
            ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
            for (int i = 0; i < A; i++) {
                adjList.add(new ArrayList<Edge>());
            }
            PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.W));
            //bi-directional, add bothways
            for (int i = 0; i < n; i++) {
                Edge e1 = new Edge(B[i][1], B[i][2]);
                Edge e2 = new Edge(B[i][0], B[i][2]);
                //already sorted in ascendings, add the first minimum weighted source vertex
                if (i == 0) {
                    minHeap.add(new Edge(B[i][0], 0));
                }
                adjList.get(B[i][0] - 1).add(e1);
                adjList.get(B[i][1] - 1).add(e2);
            }
            long maxSu = primsAlgo(adjList, minHeap, visited);
            return (int) maxSu;
        }

        public long primsAlgo(ArrayList<ArrayList<Edge>> adjlist, PriorityQueue<Edge> queue, int[] visited) {
            long sum = 0;
            while (!queue.isEmpty()) {
                Edge e = queue.poll();
                int vert = e.V;
                int weig = e.W;
                if (visited[vert] == 0) {
                    sum = (sum + weig) % 1000000007;
                }
                visited[vert] = 1;
                ArrayList<Edge> edges = adjlist.get(vert - 1);
                for (Edge neighbour : edges) {
                    if (visited[neighbour.V] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
            return sum % 1000000007;
        }

        static class Edge {
            int W;
            int V;

            public Edge(int V, int W) {
                this.W = W;
                this.V = V;
            }
        }
    }
}
