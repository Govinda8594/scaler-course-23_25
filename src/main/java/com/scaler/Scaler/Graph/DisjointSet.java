package com.scaler.Scaler.Graph;

public class DisjointSet {

    //// Union By Rank
    class UnionByRank {
        int[] parent;
        int[] rank;

        UnionByRank(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return false;
            }
            if (rank[px] > rank[py]) {
                parent[py] = px;
            } else if (rank[py] > rank[px]) {
                parent[px] = py;
            } else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }

        public int[] solve(int A, int[][] B, int[][] C) {
            UnionByRank dsu = new UnionByRank(A);
            int[] res = new int[C.length];
            for (int i = 0; i < C.length; i++) {
                int u = C[i][0];
                int v = C[i][1];
                res[i] = dsu.union(u, v) ? 1 : 0;
            }
            return res;
        }
    }

    class UnionFindByPathCompression {
        private int[] parent;
        private int[] rank;

        public UnionFindByPathCompression(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            int root = x;
            while (root != parent[root]) { // find parent root of subtree
                root = parent[root];
            }
            while (x != root) { // attach small tree to large tree
                int next = parent[x];
                parent[x] = root;
                x = next;
            }
            return root;
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return false;
            }
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }

        public int[] solve(int A, int[][] B, int[][] C) {
            UnionFindByPathCompression dsu = new UnionFindByPathCompression(A);
            int[] res = new int[C.length];
            for (int i = 0; i < C.length; i++) {
                int u = C[i][0];
                int v = C[i][1];
                res[i] = dsu.union(u, v) ? 1 : 0;
            }
            return res;
        }
    }
}
