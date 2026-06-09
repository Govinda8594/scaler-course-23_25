package com.scaler.Scaler.BinaryTree;

class HeightofTree {
    public int solve(TreeNode A) {
        if (A == null) return 0;
        int left = solve(A.left);
        int right = solve(A.right);
        return 1 + Math.max(right, left);
    }
}
