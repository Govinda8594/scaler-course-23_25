package com.scaler.Scaler.Graph;
//You are given an undirected unweighted graph consisting of A vertices and M edges given in a form of
// 2D Matrix B of size M x 2 where (B[i][0], B][i][1]) denotes two nodes connected by an edge.
//        You have to write a number on each vertex of the graph. Each number should be 1, 2 or 3.
//        The graph becomes Poisonous if for each edge the sum of numbers on vertices connected by this edge is odd.
//        Calculate the number of possible ways to write numbers 1, 2 or 3 on vertices so the graph becomes poisonous.
//        Since this number may be large, return it modulo 998244353.
//        NOTE:
//
//        Note that you have to write exactly one number on each vertex.
//        The graph does not have any self-loops or multiple edges.
//        Nodes are labelled from 1 to A.
//        Problem Constraints
//        1 <= A <= 3*105
//        0 <= M <= 3*105
//        1 <= B[i][0], B[i][1] <= A
//        B[i][0] != B[i][1]

import java.util.*;

public class PoisonousGraph {
    static long mod = 998244353;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] color;
    static int maxn = 300009;
    static int[] visited = new int[maxn];
    static long[] dp = new long[maxn];
    static int a, b;

    public int solve(int n, int[][] B) {
        long mod = 998244353;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i <= n; i++)
            map.put(i, new ArrayList<>());

        for (int[] arr : B) {
            map.get(arr[0]).add(arr[1]);
            map.get(arr[1]).add(arr[0]);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);
        long result = 1;
        // for each component coloring
        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                int[] count = new int[2];
                color[i] = 0; // first color the component
                count[0] = 1;  // count of 0 zero
                Queue<Integer> que = new LinkedList<>();
                que.offer(i);
                boolean isBipartite = true;
                while (!que.isEmpty() && isBipartite) {
                    int u = que.poll();
                    if (map.containsKey(u)) {
                        for (Integer v : map.get(u)) {
                            if (color[v] == -1) { // not color
                                color[v] = 1 - color[u];
                                count[color[v]]++; // increment the count of way to color ith component
                                que.offer(v);
                            } else if (color[v] == color[u]) {
                                isBipartite = false;
                                break;
                            }
                        }
                        if (!isBipartite)
                            return 0;
                    }
                }
                // way for coloring of 0 and 1 color for bipartite 2 pow x + 2 pow y
                // then take product of all
                long way = ((long) Math.pow(2, count[0]) + (long) Math.pow(2, count[1])) % mod;
                result = (result * way) % mod;
            }
        }
        return (int) result;
    }


    // Helper method to compute pow(2, n) % mod efficiently
    private long pow(int base, int exponent) {
        long result = 1;
        long power = base;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * power) % mod;
            }
            power = (power * power) % mod;
            exponent /= 2;
        }
        return result;
    }

    /// /////
    public int solve2(int A, int[][] B) {
        graph();
        pre();
        for (int[] edge : B) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        long ans = 1;
        for (int i = 1; i <= A; i++) {
            if (visited[i] == -1) {
                a = 0;
                b = 0;
                if (!bfs(i))
                    return 0;
                long res = ((dp[a] % mod) + (dp[b] % mod)) % mod;
                ans = ((ans % mod) * (res % mod)) % mod;
            }
        }
        return (int) ans;
    }

    public static void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            visited[i] = -1;
            adj.add(new ArrayList<Integer>());
        }
    }

    public static void pre() {
        dp[0] = 1;
        for (int i = 1; i < maxn; i++) {
            dp[i] = ((long) 2) * dp[i - 1];
            dp[i] %= mod;
        }
    }

    public static boolean bfs(int s) {
        visited[s] = 1;
        a++;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int v : adj.get(temp)) {
                if (visited[v] == -1) {
                    visited[v] = 1 - visited[temp];
                    if (visited[v] == 0) b++;
                    else a++;
                    q.offer(v);
                } else if (visited[v] == visited[temp])
                    return false;
            }
        }
        return true;
    }
}
