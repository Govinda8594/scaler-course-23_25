package com.scaler.Scaler.BinaryTree;

public class SumBinaryTreeOrNot {

//    Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
//    Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
//    An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
//    Return 1 if it sum-binary tree else return 0.
//
//    Problem Constraints
//1 <= length of the array <= 100000
//            0 <= node values <= 50
    public int solve(TreeNode A) {
        //base case
        if (A == null) {
            return 1;
        }
        int leftSum = sum(A.left);//left sub tree sum
        int rightSum = sum(A.right);//right sub tree sum
        int root = A.val;//root of the tree
        if (root == leftSum + rightSum) {//check if both are same or not
            return 1;
        }
        return 0;
    }
    //sum function
    public int sum(TreeNode temp) {
        //base case
        if (temp == null) {
            return 0;
        }
        return temp.val + sum(temp.left) + sum(temp.right);
    }
    ////////////////////////////////////////////////////////////////

    int flag;
    public int solve2(TreeNode A) {
        flag = 1;
        checkSumBinary(A);
        return flag;
    }

    private int checkSumBinary(TreeNode A) {
        if (A == null) {
            return 0;
        }
        int left = checkSumBinary(A.left);
        int right = checkSumBinary(A.right);
        if (A.val != left + right && !(left == 0 && right == 0)) {
            flag = 0;
        }
        return left + right + A.val;
    }
}
