package com.scaler.Scaler.BinaryTree;

import java.util.HashSet;
//Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .
//        In case there is no common node, return 0.
//        NOTE:
//        Try to do it one pass through the trees.
public class SumOfCommonNodeFrom2BinaryTree {
    HashSet<Integer> set;
    int ans, mod = 1000000007;
    public int solve2(TreeNode A, TreeNode B) {
        set = new HashSet<>();
        ans = 0;
        dfs(A);
        dfs(B);
        return ans;
    }
    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        if (!set.add(node.val)) {
            ans = ans % mod + node.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
