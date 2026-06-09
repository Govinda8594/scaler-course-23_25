package com.scaler.Scaler.BinaryTree;

class SumOfleftLeave {
    public int solve(TreeNode A) {
        if (A == null) return 0;
        int ans = 0;
        if (A.left != null && A.left.left == null && A.left.right == null)
            ans += A.left.val;
        else {
            ans += solve(A.left);
        }
        ans += solve(A.right);
        return ans;
    }

    //////////////////////////////////////////////////////////////////////
    public int solve2(TreeNode A) {
        return sum(A, false);
    }

    public int sum(TreeNode A, boolean isexist) {
        if (A == null) return 0;
        if (A.left == null && A.right == null && isexist)
            return A.val;
        return sum(A.left, true) + sum(A.right, false);

    }
}
