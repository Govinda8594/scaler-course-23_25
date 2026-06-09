package com.scaler.Scaler.BinarySearch;

import com.scaler.Scaler.BinaryTree.TreeNode;

public class DeleteNodeInBST {

    public TreeNode solve(TreeNode A, int B) {
        return deleteNode(A, B);
    }

    private TreeNode deleteNode(TreeNode A, int B) {
        if (A == null) {
            return null;
        }
        if (B < A.val) {
            A.left = deleteNode(A.left, B);
        } else if (B > A.val) {
            A.right = deleteNode(A.right, B);
        } else {
            if (A.left == null && A.right == null) {
                return null;
            } else if (A.right == null) {
                return A.left;
            } else if (A.left == null) {
                return A.right;
            } else {
                TreeNode temp = findMaxfromLeft(A.left); //always take maxium element from left subtree
                A.val = temp.val;
                A.left = deleteNode(A.left, temp.val);
            }
        }
        return A;
    }

    private TreeNode findMaxfromLeft(TreeNode A) {
        while (A.right != null) {
            A = A.right;
        }
        return A;
    }
    //////////////////////////////////////////////////////////////////

    public TreeNode solve2(TreeNode A, int B) {
        if (A != null) {
            if (B < A.val) {
                A.left = solve2(A.left, B);
            } else if (B > A.val) {
                A.right = solve2(A.right, B);
            } else {
                if (A.left == null && A.right == null) {
                    return null;
                }
                if (A.left == null || A.right == null) {
                    return A.left != null ? A.left : A.right;
                }
                TreeNode temp = A.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                A.val = temp.val;
                A.left = solve2(A.left, temp.val);
            }
        }
        return A;
    }
}
