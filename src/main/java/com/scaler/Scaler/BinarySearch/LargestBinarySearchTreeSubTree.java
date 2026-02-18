package com.scaler.Scaler.BinarySearch;
//You are given a Binary Tree A with N nodes.
//        Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).
//        If the complete Binary Tree is BST, then return the size of the whole tree.
//        NOTE:
//        The largest subtree is the subtree with the most number of nodes.

import com.scaler.Scaler.BinaryTree.TreeNode;

public class LargestBinarySearchTreeSubTree {
    static int maxSize = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(18);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(19);
        root.left.right = new TreeNode(20);
        root.right.left = new TreeNode(35);
        root.right.right = new TreeNode(60);
        root.right.left.right = new TreeNode(40);
        root.right.left.left = new TreeNode(20);
        root.right.right.left = new TreeNode(55);
        root.right.right.right = new TreeNode(70);
        int size = largestBst(root);
        System.out.println("The size of the largest BST is " + size);
    }

    public static int largestBst(TreeNode A) {
        if (A == null) return 0;

        int s = Integer.MIN_VALUE, e = Integer.MAX_VALUE;
        if (isBST(A, s, e)) {
            int size = sizeOfBST(A);
            maxSize = Math.max(maxSize, size);
        } else {
            int l = largestBst(A.left);
            int r = largestBst(A.right);
        }
        return maxSize;
    }

    public static int sizeOfBST(TreeNode A) {
        if (A == null) return 0;

        int l = sizeOfBST(A.left);
        int r = sizeOfBST(A.right);
        return l + r + 1;
    }

    public static boolean isBST(TreeNode A, int min, int max) {
        if (A == null) {
            return true;
        }
        if (min <= A.val && A.val <= max) {
            return isBST(A.left, min, A.val - 1) && isBST(A.right, A.val + 1, max);
        }
        return false;
    }

}
