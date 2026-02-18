package com.scaler.Scaler.BinaryTree;

import java.util.*;

//Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
public class KthSmallestElementInBT {

    public ArrayList<Integer> al = new ArrayList<>();
    public int kthsmallest(TreeNode A, int B) {
        if (A == null) {
            return -1;
        }
        inorder(A);
        return al.get(B - 1);
    }

    public void inorder(TreeNode A) {
        if (A == null) {
            return;
        }
        inorder(A.left);
        al.add(A.val);
        inorder(A.right);
    }
    /////////////////////////////////////////////////////////////////////////////////

    public int kthsmallest2(TreeNode A, int B) {
        // morris in order traversal
        int count = 0;
        int ans = 0;
        TreeNode current = A;
        while (current != null) {
            if (current.left != null) {
                TreeNode temp = current.left;
                while (temp.right != null && temp.right != current) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    // establish connection between temp.right and current
                    temp.right = current;
                    current = current.left;
                } else {
                    // remove link
                    temp.right = null;
                    // process data
                    count++;
                    if (count == B) {
                        ans = current.val;
                    }
                    current = current.right;
                }
            } else {
                // process data
                count++;
                if (count == B) {
                    ans = current.val;
                }
                current = current.right;
            }
        }
        return ans;
    }

    
}
