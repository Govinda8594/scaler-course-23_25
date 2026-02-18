package com.scaler.Scaler.BinaryTree;

import java.util.Stack;

//Given two binary trees, check if they are equal or not.
//        Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
public class CheckWheatherTwoBTAreSame {

    public int isSameTree(TreeNode A, TreeNode B) {
        return sameTree(A, B);
    }

    public int sameTree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return 1;
        }
        if (A == null || B == null) {
            return 0;
        }
        if (A.val != B.val) {
            return 0;
        }
        int num = 1;
        num = num & sameTree(A.left, B.left) & sameTree(A.right, B.right);
        return num;
    }
    /////////////////////////////////////////////////////////////////////

    public int isSameTree2(TreeNode A, TreeNode B) {
        Stack<TreeNode> stk1 = new Stack<>();
        Stack<TreeNode> stk2 = new Stack<>();
        TreeNode temp1, temp2;
        while (!stk1.isEmpty() || A != null) {
            if (A != null && B != null) {
                if (A.val == B.val) {
                    stk1.push(A);
                    stk2.push(B);
                    A = A.left;
                    B = B.left;
                } else {
                    return 0;
                }
            } else if (A == null && B == null) {
                A = stk1.pop();
                B = stk2.pop();
                A = A.right;
                B = B.right;
            } else {
                return 0;
            }
        }
        return 1;
    }


}
