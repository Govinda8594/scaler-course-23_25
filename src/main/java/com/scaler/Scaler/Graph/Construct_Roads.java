package com.scaler.Scaler.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//A country consist of N cities connected by N - 1 roads.
// King of that country want to construct maximum number of roads such that the new country formed remains bipartite country.
//        Bipartite country is a country, whose cities can be partitioned into 2 sets in such a way,
//        that for each road (u, v) that belongs to the country, u and v belong to different sets. Also,
//        there should be no multiple roads between two cities and no self loops.
//        Return the maximum number of roads king can construct. Since the answer could be large return answer % 109 + 7.
//        NOTE: All cities can be visited from any city.
//
//        Problem Constraints
//        1 <= A <= 105
//        1 <= B[i][0], B[i][1] <= N

public class Construct_Roads {
    public int solve4(int n, int[][] B) {
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        // build adjacency list
        List<List<Integer>> list = buildAdjacencyList(n, B);
        // it is given that country are already bipartite
        // try to divide the cities into 2 sets
        visited[1] = 1;
        dfs(1, list, visited);
        // separate out the two sets
        int set1Count = 0, set2Count = 0;
        for (int j : visited) {
            if (j == 0) {
                set1Count++;
            } else if (j == 1) {
                set2Count++;
            }
        }
        // totalRoads = (x * y)
        // roads already built = n-1 (B.length)
        long m = 1000000007;
        long totalRoads = (set1Count % m * set2Count % m) % m;
        long newRoads = totalRoads - B.length;
        return (int) newRoads;
    }

    private void dfs(int source, List<List<Integer>> list, int[] visited) {
        // neighbors
        List<Integer> neighbors = list.get(source);
        for (int currNode : neighbors) {
            if (visited[currNode] == -1) {
                // divide the neighboring city into opposite set
                visited[currNode] = 1 ^ visited[source];
                dfs(currNode, list, visited);
            }
        }
    }

    // build adjacency list for undirected graph
    private List<List<Integer>> buildAdjacencyList(int n, int[][] B) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int[] ints : B) {
            int u = ints[0];
            int v = ints[1];
            list.get(u).add(v);
            list.get(v).add(u);
        }
        return list;
    }
}
