package com.scaler.Scaler.BinaryTree;

import java.util.List;
import java.util.Stack;

public class TreeTraversal {

    static List<Integer> inOrderTraversal(TreeNode root, List<Integer> inorder) {
        if (root == null) {
            return inorder;
        }
        inOrderTraversal(root.left, inorder);
        inorder.add(root.data);
        inOrderTraversal(root.right, inorder);
        return inorder;
    }

    static List<Integer> preOrderTraversal(TreeNode root, List<Integer> preorder) {
        if (root == null) {
            return preorder;
        }
        preorder.add(root.data);
        preOrderTraversal(root.left, preorder);
        preOrderTraversal(root.right, preorder);
        return preorder;
    }

    static List<Integer> postOrderTraversal(TreeNode root, List<Integer> postorder) {
        if (root == null) {
            return postorder;
        }
        postOrderTraversal(root.left, postorder);
        postOrderTraversal(root.right, postorder);
        postorder.add(root.data);
        return postorder;
    }

    void inorder(TreeNode root, List<Integer> inorder) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            stack.pop();
            System.out.println(current.data);
            inorder.add(current.data);
            current = current.right;
        }
    }

    void postorder(TreeNode root, List<Integer> postOrder) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            stack.pop();
            current = current.right;
            System.out.println(current.data);
            postOrder.add(current.data);
        }
    }

    void preorder(TreeNode root, List<Integer> preOrder) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || current != null) {
            System.out.println(current.data);
            preOrder.add(current.data);
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            stack.pop();
            current = current.right;
        }
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
