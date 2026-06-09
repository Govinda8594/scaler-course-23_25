package com.scaler.Scaler.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.
//        Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.
//        All students who know each other are placed in one batch.
//        Strength of a batch is equal to sum of the strength of all the students in it.
//        Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.
//        Find the number of batches selected.
//        NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.
//
//        Problem Constraints
//        1 <= A <= 105
//        1 <= M <= 2*105
//        1 <= B[i] <= 104
//        1 <= C[i][0], C[i][1] <= A
//        1 <= D <= 109

public class Batches {

    static int maxn = 100009;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] a = new int[maxn];
    static int[] vis = new int[maxn];
    static int sum = 0;

    public static void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            vis[i] = 0;
            adj.add(new ArrayList<Integer>());
        }
    }

    public static void dfs(int x) {
        sum += a[x];
        vis[x] = 1;
        for (int v : adj.get(x)) {
            if (vis[v] == 0) {
                dfs(v);
            }
        }
    }

    public int solve(int A, int[] B, int[][] C, int D) {
        graph();
        for (int[] edge : C) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        System.arraycopy(B, 0, a, 1, B.length);
        int ans = 0;
        for (int i = 1; i <= A; i++) {
            if (vis[i] == 0) {
                sum = 0;
                dfs(i);
                if (sum >= D) {
                    ++ans;
                }
            }
        }
        return ans;
    }
    /////////////////////////////////DSU//////////////////////////////////////////////////

    public int solve2(int A, int[] B, int[][] C, int D) {
        int[] parent = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
        }
        // combine node x and y for each edge into single batch
        for (int[] ints : C) {
            int x = ints[0];
            int y = ints[1];
            union(x, y, parent);
        }
        // find parent of each node. this is required to finally map the top most parent for each node
        for (int i = 1; i <= A; i++) {
            parent[i] = findParent(i, parent);
        }
        // count strength for each parent
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 1; i <= A; i++) {
            int strength = B[i - 1];
            map.put(parent[i], map.getOrDefault(parent[i], strength) + strength);
//            if (!map.containsKey(parent[i])) {
//                map.put(parent[i], strength);
//            } else {
//                map.put(parent[i], map.get(parent[i]) + strength);
//            }
        }
        // consider all parents/components/batches whose strength is >= D
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= D) {
                count++;
            }
        }
        return count;
    }

    // combine x and y of those are part of different connected components
    public void union(int x, int y, int[] parent) {
        int parent_x = findParent(x, parent);
        int parent_y = findParent(y, parent);
        if (parent_x != parent_y) {
            // assign new parent for y. x and y will be combined into single connected
            // component
            parent[parent_y] = parent_x;
        }
    }

    // find top most parent of node x
    public int findParent(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        // this will override the existing parent of x
        parent[x] = findParent(parent[x], parent);
        return parent[x];
    }
}
