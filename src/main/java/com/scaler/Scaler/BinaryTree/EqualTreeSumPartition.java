package com.scaler.Scaler.BinaryTree;

//Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
//        Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
//        An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
//        Return 1 if it sum-binary tree else return 0.
public class EqualTreeSumPartition {

    int ans = 0;

    public int solve(TreeNode A) {
        long sum = treeSum(A);
        if (sum % 2 == 1) {
            return 0;
        }
        preorder(A, sum / 2);
        return ans;
    }

    long treeSum(TreeNode a) {
        if (a == null) {
            return 0;
        }
        return treeSum(a.left) + treeSum(a.right) + a.val;
    }

    void preorder(TreeNode a, long x) {
        if (a == null) {
            return;
        }
        if (treeSum(a) == x) {
            ans = 1;
        }
        preorder(a.left, x);
        preorder(a.right, x);
    }

    ////////////////////////////////////////////////////////////////////
    int isEqualTree = 0;

    public int solve2(TreeNode A) {
        long sumOfBST = sumBST(A);
        long result = checkBSTisEqualTree(A, sumOfBST);
        return isEqualTree;
    }

    // total sum of BST
    long sumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long leftSum = sumBST(root.left);
        long rightSum = sumBST(root.right);
        return leftSum + rightSum + root.val;
    }

    //equal partition sum resursion
    long checkBSTisEqualTree(TreeNode A, long sum) {
        if (A == null) {
            return 0;
        }
        long leftBSTSum = checkBSTisEqualTree(A.left, sum);
        long rightBSTSum = checkBSTisEqualTree(A.right, sum);
        long bstSum = leftBSTSum + rightBSTSum + A.val;
        if (sum - bstSum == bstSum) {
            isEqualTree = 1;
        }
        return bstSum;
        //check if equal partition sum exists or not
    }
}
