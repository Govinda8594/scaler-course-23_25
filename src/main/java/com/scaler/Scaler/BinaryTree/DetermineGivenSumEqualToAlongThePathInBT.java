package com.scaler.Scaler.BinaryTree;

//Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
public class DetermineGivenSumEqualToAlongThePathInBT {

    public int hasPathSum(TreeNode A, int B) {
        boolean status = sum(A, 0, B);
        return status ? 1 : 0;
    }

    public boolean sum(TreeNode A, int curSum, int reqSum) {
        if (A == null) {
            return false;
        }
        if (A.left == null && A.right == null) {
            curSum += A.val;
            return curSum == reqSum;
        }
        int sum = curSum + A.val;
        return sum(A.left, sum, reqSum) || sum(A.right, sum, reqSum);
    }
    ////////////////////////////////////////////////////

    public int hasPathSum2(TreeNode A, int B) {
        if (A == null) {
            return 0;
        }
        B = B - A.val;
        if (A.left == null && A.right == null && B == 0) {
            return 1;
        } else {
            return (hasPathSum(A.left, B) | hasPathSum(A.right, B));
        }
    }
}
