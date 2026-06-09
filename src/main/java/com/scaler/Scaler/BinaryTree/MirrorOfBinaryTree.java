package com.scaler.Scaler.BinaryTree;

public class MirrorOfBinaryTree {

    public TreeNode invertBinaryTree(TreeNode A) {
        if (A == null) {
            return A;
        }
            TreeNode invertLeft = invertBinaryTree(A.left);
            TreeNode invertRight = invertBinaryTree(A.right);
            A.left = invertRight;
            A.right = invertLeft;
            return A;
    }
}
