package com.scaler.Scaler.BinaryTree;

import java.util.Stack;

//Given a binary tree A, flatten it to a linked list in-place.
//
//        The left child of all nodes should be NULL.
public class FlattenBinaryTreeToLinkedList {


    TreeNode prev = null;

    public TreeNode flatten2(TreeNode a) {
        TreeNode current = a, prev = null;
        while (current != null) {
            if (current.left != null) {
                prev = current.left;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
        return a;
    }

    public TreeNode flatten(TreeNode root) {
        if (root == null)
            return null;
        // Flatten the right subtree first
        flatten(root.right);
        // Flatten the left subtree
        flatten(root.left);
        // Set the right child to the previous node (which is the flattened right subtree)
        root.right = prev;
        // Set the left child to null
        root.left = null;
        // Update the previous node to the current node
        prev = root;
        return prev;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    public TreeNode flatten3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            stack.pop();
            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
            if (!stack.empty()) {
                curr.right = stack.peek();
            }
            curr.left = null;
        }
        return root;
    }
}
