package com.scaler.Scaler.BinaryTree;

//Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake. Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST).
//        A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
//        Note: The 2 values must be returned in ascending order
public class RestoreBinarySearchTreeBySwapping2Node {
    TreeNode prev = null;
    TreeNode curr = null;
    TreeNode temp = null;

    public int[] recoverTree1(TreeNode A) {
        //form a BST using inOrder method
        int[] output = new int[2];
        inorder(A);
//        int val = curr.data;
//        curr.data = prev.data;
//        prev.data = val;
//        return root;
        // Create a new array and return the swapped values in ascending order

        output[0] = curr.val;
        output[1] = prev.val;
        return output;
    }

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        if (temp != null && temp.val > root.val) {
            if (curr == null) {
                prev = temp;
            }
            curr = root;
        }
        temp = root;
        inorder(root.right);
    }
}
