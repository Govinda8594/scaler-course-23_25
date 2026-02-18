package com.scaler.Scaler.BinarySearch;

import com.scaler.Scaler.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumValBST {
    private TreeNode findMaxfromRight(TreeNode A) {
        while (A.right != null) {
            A = A.right;
        }
        return A;
    }

    ////////////////////////////////////////////////////////////////
    int inorder(TreeNode root, ArrayList<Integer> inorder) {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (stack.size() > 0 || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.peek();
            stack.pop();
            inorder.add(current.val);
            current = current.right;
        }
        // last node in inorder is max.
        return inorder.get(inorder.size() - 1);
    }
}
