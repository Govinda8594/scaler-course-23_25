package com.scaler.Scaler.BinaryTree;

//Given a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
public class CheckWheatherBTisSymmetric {

    public int isSymmetric(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return check(A.left, A.right) ? 1 : 0;
    }
    public boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return check(node1.left, node2.right) & check(node1.right, node2.left);
    }


}
