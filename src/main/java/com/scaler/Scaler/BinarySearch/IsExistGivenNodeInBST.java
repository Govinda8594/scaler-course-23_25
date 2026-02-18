package com.scaler.Scaler.BinarySearch;

import com.scaler.Scaler.BinaryTree.TreeNode;

public class IsExistGivenNodeInBST {

    boolean isExist(TreeNode root, int B) {
        if (root == null) {
            return false;
        }
        if (root.val == B) {
            return true;
        }
        return isExist(root.left, B) || isExist(root.right, B);
    }
}
