package com.scaler.Scaler.BinarySearch;

import com.scaler.Scaler.BinaryTree.TreeNode;

public class AddNewNodeToBST {

    TreeNode insertNode(TreeNode root, int K) {
        if (root == null) {
            TreeNode newRoot = new TreeNode(K);
            return newRoot;
        }
        if (root.val == K) {
            return root;
        }
        if (K < root.val) {
            root.left = insertNode(root.left, K);
        } else if (K > root.val) {
            root.right = insertNode(root.right, K);
        }
        return root;
    }
}
