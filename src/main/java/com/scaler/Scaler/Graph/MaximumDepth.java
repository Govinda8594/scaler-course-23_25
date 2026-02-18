package com.scaler.Scaler.Graph;
//Given a Tree of A nodes having A-1 edges. Each node is numbered from 1 to A where 1 is the root of the tree.
//        You are given Q queries. In each query, you will be given two integers L and X. Find the value of such node which lies at level L mod (MaxDepth + 1) and has value greater than or equal to X.
//        Answer to the query is the smallest possible value or -1, if all the values at the required level are smaller than X.
//        NOTE:
//
//        Level and Depth of the root is considered as 0.
//        It is guaranteed that each edge will be connecting exactly two different nodes of the tree.
//        Please read the input format for more clarification.
//        Problem Constraints
//
//
//        2 <= A, Q(size of array E and F) <= 105
//        1 <= B[i], C[i] <= A
//        1 <= D[i], E[i], F[i] <= 106

import java.util.*;

public class MaximumDepth {

    static int maxn = 100009;
    static int n, q;
    static int mx = 0;
    static int[] val = new int[maxn];
    static ArrayList<ArrayList<Integer>> adj;
    static ArrayList<ArrayList<Integer>> lvl;

    public static void graph() {
        adj = new ArrayList<ArrayList<Integer>>(maxn);
        lvl = new ArrayList<ArrayList<Integer>>(maxn);
        for (int i = 0; i < maxn; i++) {
            adj.add(new ArrayList<Integer>());
            lvl.add(new ArrayList<Integer>());
        }
        mx = 0;
    }

    public static void dfs(int u, int v, int d) {
        mx = Math.max(mx, d);
        lvl.get(d).add(val[u]);  // add value in level according to depth
        for (int i : adj.get(u)) {
            if (i == v) {
                continue;
            }
            dfs(i, u, d + 1);
        }
    }

    static int lowerBound(ArrayList<Integer> a, int low, int high, int element) {
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (element > a.get(middle)) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }

    public int[] solve2(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        graph();
        n = A;
        q = F.length;
        if (n >= 0) System.arraycopy(D, 0, val, 1, n);
        for (int i = 0; i < n - 1; i++) {
            adj.get(B[i]).add(C[i]);
            adj.get(C[i]).add(B[i]);
        }
        mx = 0;
        dfs(1, 1, 0);
        for (int i = 0; i < maxn; i++) {
            Collections.sort(lvl.get(i));
        }
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int l = E[i];
            int x = F[i];
            l %= (mx + 1);
            int it = lowerBound(lvl.get(l), 0, lvl.get(l).size(), x);
            if (it == lvl.get(l).size()) {
                res[i] = -1;
            } else {
                res[i] = lvl.get(l).get(it);
            }
        }
        return res;
    }

    /// ///////////////////////////////////////////////////////////////////////////////////////

    public int[] solve3(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {
        // Build adjacency list
        List<Integer>[] adjList = new ArrayList[A + 1];
        for (int i = 1; i <= A; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < B.length; i++) {
            adjList[B[i]].add(C[i]);
            adjList[C[i]].add(B[i]);
        }

        // BFS traversal
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[A + 1];
        int level = 0;

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = levelMap.computeIfAbsent(level, k -> new ArrayList<>());

            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                currentLevel.add(D[node - 1]);

                for (int neighbor : adjList[node]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }

            Collections.sort(currentLevel);
            level++;
        }

        // Answer queries
        int[] ans = new int[E.length];
        for (int i = 0; i < E.length; i++) {
            int queryLevel = E[i] % level;
            ans[i] = binarySearch((ArrayList<Integer>) levelMap.get(queryLevel), F[i]);
        }
        return ans;
    }


    private int binarySearch(ArrayList<Integer> list, int target) {
        int ans = -1;
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) >= target) {
                ans = list.get(mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int[] solve(int A, int[] B, int[] C, int[] D, int[] E, int[] F) {

        // create adjacency list
        List<TreeNode> list = buildAdjacencyList(A, B, C, D);

        // level order traversal and get all elements in level
        List<List<Integer>> levels = performLevelOrderTraversal(A, list);

        // for each query get the ceil from respective level
        int[] output = new int[E.length];
        int totalLevels = levels.size(); // max-depth
        for (int i = 0; i < E.length; i++) {
            int L = E[i] % totalLevels;
            int X = F[i];
            int ceil = getCeil(X, levels.get(L));
            output[i] = ceil;
        }

        return output;

    }

    /**
     * Build Adjacency List
     */
    public List<TreeNode> buildAdjacencyList(int A, int[] B, int[] C, int[] D) {
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i <= A; i++) {
            list.add(new TreeNode(i));
        }
        for (int i = 1; i <= A; i++) {
            list.get(i).value = D[i - 1];
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i];
            int v = C[i];
            // undirected graph
            TreeNode sourceNode = list.get(u);
            TreeNode targetNode = list.get(v);
            sourceNode.neighbors.add(targetNode);
            targetNode.neighbors.add(sourceNode);
        }
        return list;
    }

    /**
     * Level Order Traversal/ BFS
     */
    private List<List<Integer>> performLevelOrderTraversal(int A, List<TreeNode> list) {
        boolean[] visited = new boolean[A + 1];
        TreeNode source = list.get(1);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(source);
        visited[source.node] = true;

        List<List<Integer>> levels = new ArrayList<>();

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode x = queue.poll();
                currentLevel.add(x.value);

                // add neighbors
                for (TreeNode neighbor : x.neighbors) {
                    if (!visited[neighbor.node]) {
                        queue.add(neighbor);
                        visited[neighbor.node] = true;
                    }
                }
            }

            // optional: sort each level
            Collections.sort(currentLevel);
            levels.add(currentLevel);
        }

        return levels;
    }

    /**
     * Get Ceil of x using Binary Search
     */
    private int getCeil(int x, List<Integer> list) {

        int start = 0;
        int end = list.size() - 1;

        int answer = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = list.get(mid);
            if (midValue == x) {
                return x;
            } else if (midValue < x) {
                start = mid + 1;
            } else {
                answer = midValue;
                end = mid - 1;
            }
        }

        return answer;
    }

    class TreeNode {
        int node;
        int value;
        List<TreeNode> neighbors;

        public TreeNode(int node) {
            this.node = node;
            this.neighbors = new LinkedList<TreeNode>();
        }
    }
}
