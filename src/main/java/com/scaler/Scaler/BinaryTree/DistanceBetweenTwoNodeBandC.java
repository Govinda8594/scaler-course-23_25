package com.scaler.Scaler.BinaryTree;

public class DistanceBetweenTwoNodeBandC {

    public int solve3(TreeNode A, int B, int C) {
        TreeNode lca = findLCA(A, B, C);
        if (lca == null) {
            return -1; // One or both nodes are not present in the tree
        }
        int dist1 = findDistance(lca, B);
        int dist2 = findDistance(lca, C);
        return dist1 + dist2;
    }
    private TreeNode findLCA(TreeNode A, int B, int C) {
        if (A == null || A.val == B || A.val == C) {
            return A;
        }
        TreeNode left = findLCA(A.left, B, C);
        TreeNode right = findLCA(A.right, B, C);
        if (left != null && right != null) {
            return A; // Found LCA
        }
        return (left != null) ? left : right;
    }
    private int findDistance(TreeNode A, int target) {
        if (A == null) {
            return -1; // Target node not found
        }
        if (A.val == target) {
            return 0; // Reached the target node
        }
        int leftDist = findDistance(A.left, target);
        int rightDist = findDistance(A.right, target);
        if (leftDist == -1 && rightDist == -1) {
            return -1; // Target node not found in left or right subtree
        } else if (leftDist != -1) {
            return leftDist + 1; // Target node found in the left subtree
        } else {
            return rightDist + 1; // Target node found in the right subtree
        }
    }
}
