package com.scaler.Scaler.BinarySearch;

import com.scaler.Scaler.BinaryTree.TreeNode;

//Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
//        Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
public class SortedArrayToBalancedBinarySearchTree {

    public TreeNode sortedArrayToBST(final int[] A) {
        return balancedTree(A, 0, A.length - 1);
    }
    private TreeNode balancedTree(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }
        if(start == end) {
            return new TreeNode(A[start]);
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = balancedTree(A, start, mid - 1);
        root.right = balancedTree(A, mid + 1, end);
        return root;
    }
}
