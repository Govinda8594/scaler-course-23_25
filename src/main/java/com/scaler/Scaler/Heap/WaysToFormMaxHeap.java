package com.scaler.Scaler.Heap;

public class WaysToFormMaxHeap {
    //////////////////////////////////////////////////////////////////////////////////////////////
    final int mod = 1000000007;
    final int maxN = 100;
    /*Approach -

    - Given n number of total elements we know that root in a maxHeap will always be fixed.
    - Structure of heap is fixed for all forms.
    - Since structure is fixed therefore no of elements in left subtree will be fixed.
    - Let number of elements in left subtree = L
    - Similarly number of elements in right subtree = R = (n-1)-L
    - Ways to choose L from n-1 = n-1.C.L
    - We’ll not calculate choosing R from n-1 because it is same as choosing L from n-1 { nCr = nCn-r }
    We need to find L (refer to code below)
    Once L is known we can say :-
    - Now both L and R will also try to form maxHeap so we’ll recursively call on L and R until n <= 2
    - ways to form maxHeap = (n-1.C.L)(way to form maxHeap for L elements)(ways to form maxHeap for R elements)*/
    long[] dp = new long[maxN + 1];
    int[][] nCr = new int[maxN + 1][maxN + 1];
    boolean precomputed = false;

    public int solve2(int A) {
        //formulae = (A-1)C(l) * ways(l) * ways(r)
        return (int) ways(A) % mod;
    }

    public int findleftSubtreeNodesCount(int n, int height) {//n is total number of nodes
        int total_Nodes_Before_LastLevel = (1 << height) - 1; // 2^height - 1(last level)
        int nodes_at_LastLevel = n - total_Nodes_Before_LastLevel;
        // (2 power height - 1(last level) - 1(root node))/2 =>> garentee node in left subtree
        int node_In_Left_subtree_before_lastlevel = (total_Nodes_Before_LastLevel - 1) / 2;
        // min of ((2 power height)/2 is garentee node in left subtree on last level, might possible last level is all filled/complete)
        // why divide by 2 => there is left and right subtree correct so doing half of node
        int actual_node_at_lastlevel = Math.min((1 << height) / 2, nodes_at_LastLevel);
        //add node in left subtree(root already neglated) + node at last level
        return node_In_Left_subtree_before_lastlevel + actual_node_at_lastlevel;
    }

    public int findNCR(int A, int B) {
        // Pascal Triangle
        if (A == B) {
            return 1;
        }
        int[][] combinations = new int[A + 1][B + 1];
        //filling the first column
        for (int i = 0; i <= A; i++) {
            combinations[i][0] = 1;
        }
        //rest of the matrix
        for (int i = 1; i <= A; i++) {
            for (int j = 1; j <= B; j++) {
                if (i == j) {
                    combinations[i][j] = 1;
                } else if (j > i) {
                    combinations[i][j] = 0;
                } else {
                    int sum = (combinations[i - 1][j - 1] + combinations[i - 1][j]) % mod;
                    combinations[i][j] = sum;
                }
            }
        }
        return combinations[A][B] % mod;
    }

    public long ways(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int height = (int) (Math.log(n) / Math.log(2)); // log h base 2 => height of tree
        // total node(n) = left + right + 1;
//        left = n - 1
        //l+r = n-1
        int l = findleftSubtreeNodesCount(n, height);
        int r = n - 1 - l;
        // System.out.println("ncr = " + findNCR(n-1,l));
        // combination of left (n - 1(root node)) from l(node) nCr * ways(l) * ways(r) => contribution technique
        // ways of left adn ways of right meaning each node either in left or right
        return (findNCR(n - 1, l) % mod * ways(l) % mod * ways(r) % mod) % mod;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    Complete Binary Tree (CBT) Definition
//    A Complete Binary Tree (CBT) is a binary tree where:
//    Every level is completely filled except possibly the last level.
//    The last level is filled from left to right with no gaps.
//    All nodes are as far left as possible in the last level.
//    Key Properties:
//    Height Efficiency:
//    Height = ⌊log₂(n)⌋ for n nodes
//    Structural Consistency:
//    Left subtree is always filled before right subtree
//    Last level nodes have no children
    public int solve(int A) {
        if (!precomputed) {
            precompute();
            precomputed = true;
        }
        return (int) dp[A];
    }

    private void precompute() {
        // Precompute binomial coefficients using Pascal's Triangle
        for (int i = 0; i <= maxN; i++) {
            nCr[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                nCr[i][j] = (nCr[i - 1][j - 1] + nCr[i - 1][j]) % mod;
            }
        }
//        compelete binary tree
//         Base cases for standard CBT counts (dp)
        dp[0] = 1;  // One empty tree
        dp[1] = 1;  // One single-node tree
        dp[2] = 1;  // One possible BST for two nodes
        dp[3] = 2;  // Two possible BSTs for three nodes

        // Compute DP for n = 4 to maxN
        for (int n = 4; n <= maxN; n++) {
            int h = (int) (Math.log(n) / Math.log(2)); // Tree height
            int totalNodesBeforeLastLevel = (1 << h) - 1;    // Nodes in full levels
            int NodesAtlastLevel = n - totalNodesBeforeLastLevel; // Nodes in last level
            // Maximum nodes in left subtree's last level
            int maxLeftAtLastLevel = 1 << (h - 1);
            // Actual nodes in left subtree
            int left = (1 << (h - 1)) - 1 + Math.min(maxLeftAtLastLevel, NodesAtlastLevel);
            int right = n - 1 - left; // Nodes in right subtree

            // Compute using recurrence relation
            dp[n] = ((long) nCr[n - 1][left] * dp[left] % mod) * dp[right] % mod;
        }
    }
}
