package com.scaler.Scaler.BinaryTree;

public class SearchInBT {

    boolean ifNodeExists( TreeNode root, int key)
    {
        if (root == null)
            return false;
        if (root.val == key)
            return true;
        if( ifNodeExists(root.left, key) || ifNodeExists(root.right, key) )
            return true;
        return false;
    }

}
