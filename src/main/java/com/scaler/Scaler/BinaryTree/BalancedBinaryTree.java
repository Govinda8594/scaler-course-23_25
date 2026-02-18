package com.scaler.Scaler.BinaryTree;
//Given a root of binary tree A, determine if it is height-balanced.
//        A height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
public class BalancedBinaryTree {
    int balanced = 1; // Flag to check whether the tree is balanced or not

    public int isBalanced(TreeNode root) {
        postOrderTraversal(root); // Call the post-order traversal method
        return balanced; // Return the result (1 if balanced, 0 if not)
    }

    public int postOrderTraversal(TreeNode root) {
        if (root == null) {
            return -1; // Base case: height of an empty subtree is -1
        }
        int left = postOrderTraversal(root.left); // Recursively compute left subtree height
        int right = postOrderTraversal(root.right); // Recursively compute right subtree height

        // Check if the difference in heights exceeds 1 (indicating imbalance)
        if (Math.abs(left - right) > 1) {
            balanced = 0; // Set the flag to indicate imbalance
        }

        // Return the height of the current subtree (maximum of left and right heights) + 1
        return Math.max(left, right) + 1;
    }
}

