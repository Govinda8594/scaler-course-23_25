package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;

public class PathOfGivenNodeToRootNode {

    ArrayList<TreeNode> paths = new ArrayList<>();
    boolean isExist(TreeNode root, int B) {
        if (root == null) {
            return false;
        }
        if (root.val == B) {
            paths.add(root);
            return true;
        }
        if (isExist(root.left, B) || isExist(root.right, B)) {
            paths.add(root);
            return true;
        }
        return false;
    }


}
