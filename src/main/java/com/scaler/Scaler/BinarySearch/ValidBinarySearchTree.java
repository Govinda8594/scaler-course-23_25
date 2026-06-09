package com.scaler.Scaler.BinarySearch;

import com.scaler.Scaler.BinaryTree.TreeNode;

//You are given a binary tree represented by root A. You need to check if it is a Binary Search Tree or not.
//        Assume a BST is defined as follows:
//        1) The left subtree of a node contains only nodes with keys less than the node's key.
//        2) The right subtree of a node contains only nodes with keys greater than the node's key.
//        3) Both the left and right subtrees must also be binary search trees.
public class ValidBinarySearchTree {
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;

    public int isValidBST(TreeNode A) {
        return isBST(A, min, max) ? 1 : 0;
    }
    public boolean isBST(TreeNode A, int min, int max) {
        if (A == null) {
            return true;
        }
        if (min <= A.val && A.val <= max) {
            return isBST(A.left, min, A.val - 1) && isBST(A.right, A.val + 1, max);
        }
        return false;
    }
}
