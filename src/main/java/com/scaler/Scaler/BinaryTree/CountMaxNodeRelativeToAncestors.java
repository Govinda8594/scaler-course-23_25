package com.scaler.Scaler.BinaryTree;

class CountMaxNodeRelativeToAncestors {

    static int countMaxNode(TreeNode root, int max) {
        if (root == null) return 0;
        int count = 0;
        if (root.val > max) {
            count++;
            max = root.val;
        }
        count += countMaxNode(root.left, max);
        count += countMaxNode(root.right, max);
        return count;
    }

    //    Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestors.
//    Ancestor means that every node that occurs before the current node in the path from root to the node.
    public int solve(TreeNode A) {
        return countMaxNode(A, Integer.MIN_VALUE);
    }

    public int count(TreeNode A, int max) {
        if (A == null) return 0;
        int c = 0;
        if (A.val > max) c = 1;
        return count(A.left, Math.max(A.val, max)) + count(A.right, Math.max(A.val, max)) + c;
    }
}
