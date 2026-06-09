package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;
//Given a binary tree, return the values of its boundary in anti-clockwise direction starting from the root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
//        Left boundary is defined as the path from the root to the left-most node.
//        Right boundary is defined as the path from the root to the right-most node.
//        If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
//        The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
//        The right-most node is also defined by the same way with left and right exchanged.
//        Return an array of integers denoting the boundary values of tree in anti-clockwise order.

public class BoundaryTraversalOfBinaryTree {
    ArrayList<Integer> boundary(TreeNode node) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (!isLeaf(node)) {
            res.add(node.val);
        }
        insertLeftBoundary(res, node);
        insertLeafNode(res, node);
        insertRightBoundary(res, node);
        return res;
    }

    public boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    public void insertLeftBoundary(ArrayList<Integer> res, TreeNode root) {
        TreeNode leftNode = root.left;
        while (leftNode != null) {
            if (isLeaf(leftNode)) {
                break;
            }
            res.add(leftNode.val);
            if (leftNode.left != null) {
                leftNode = leftNode.left;
            } else {
                leftNode = leftNode.right;
            }
        }
    }

    public void insertRightBoundary(ArrayList<Integer> res, TreeNode root) {
        TreeNode rightNode = root.right;
        Stack<Integer> stack = new Stack<>();
        while (rightNode != null) {
            if (isLeaf(rightNode)) {
                break;
            }
            stack.push(rightNode.val);
            if (rightNode.right != null) {
                rightNode = rightNode.right;
            } else {
                rightNode = rightNode.left;
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    public void insertLeafNode(ArrayList<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            res.add(root.val);
        }
        insertLeafNode(res, root.left);
        insertLeafNode(res, root.right);
    }
}
