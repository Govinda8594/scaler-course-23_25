package com.scaler.Scaler.BinaryTree;

class SumOfAllNodesInTree {
    public int solve(TreeNode A) {
        if(A == null) return 0;
        int left = solve(A.left);
        int right = solve(A.right);
        return left+right+A.val;
    }
}
