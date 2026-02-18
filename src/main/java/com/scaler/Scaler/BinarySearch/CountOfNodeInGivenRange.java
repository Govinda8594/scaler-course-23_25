package com.scaler.Scaler.BinarySearch;

import com.scaler.Scaler.BinaryTree.TreeNode;
//Given a binary search tree of integers. You are given a range B and C.
//        Return the count of the number of nodes that lie in the given range.
public class CountOfNodeInGivenRange {

    static int ans = 0;
    public int solve(TreeNode A, int B, int C) {
        ans = 0;
        traverse(A, B, C);
        return ans;
    }
    public static void traverse(TreeNode a, int B, int C) {
        if (a == null) {
            return;
        }
        if (a.val >= B && a.val <= C) {
            ans++;
        }
        traverse(a.left, B, C);
        traverse(a.right, B, C);
    }
}
