package com.scaler.Scaler.Sorting;

import java.util.ArrayList;
import java.util.List;

public class TreeSort {
    public void treeSort(int[] arr) {
        // Build BST
        TreeNode root = null;
        for (int num : arr) {
            root = insert(root, num);
        }

        // In-order traversal to get sorted order
        List<Integer> sorted = new ArrayList<>();
        inOrderTraversal(root, sorted);

        // Copy back to array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted.get(i);
        }
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);  // Duplicates go right
        }
        return root;
    }

    private void inOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) return;
        inOrderTraversal(root.left, result);
        result.add(root.val);
        inOrderTraversal(root.right, result);
    }

    class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
