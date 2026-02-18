package com.scaler.Scaler.BinarySearch;

//Given preorder traversal of a binary tree,
// check if it is possible that it is also a preorder traversal
// of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.
public class CheckGivenPreOrderIsBinarySearchTree {
    public String solve2(int[] A) {
        return verify(A, 0, Integer.MIN_VALUE, Integer.MAX_VALUE) ? "YES" : "NO";
    }

    private boolean verify(int[] A, int i, int min, int max) {
        if (i == A.length) {
            return true;
        }
        if (min <= A[i] && A[i] <= max) {
            int val = A[i];
            return verify(A, i + 1, min, val - 1) || verify(A, i + 1, val + 1, max);
        }
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////////

    public String solve3(int[] A) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int root = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] > root) {
                min = root;
            } else {
                max = root;
            }
            if (A[i] < min || A[i] > max)
                return "NO";
            root = A[i];
        }
        return "YES";
    }
}
