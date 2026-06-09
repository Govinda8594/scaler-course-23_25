package com.scaler.Scaler.BinaryTree;

public class DiameterOfBinaryTree {
    static int maxHeight = Integer.MIN_VALUE;
    public int solve(TreeNode A) {
        findDiameter(A);
        return maxHeight;
    }

    public static int findDiameter(TreeNode A) {
        if (A == null) {
            return 0; // Base case: height of an empty subtree is 0
        }
        int left = findDiameter(A.left); // Recursively compute left subtree height
        int right = findDiameter(A.right); // Recursively compute right subtree height

        // Update the maximum diameter encountered so far
        maxHeight = Math.max(maxHeight, left + right);

        // Return the height of the current subtree (maximum of left and right heights) + 1
        return 1 + Math.max(left, right);
    }


}

