package com.scaler.Scaler.BinarySearch;

import com.scaler.Scaler.BinaryTree.TreeNode;

//You are given a sorted array A of size N and a target value B.
//        Your task is to find the index (0-based indexing) of the target value in the array.
//
//        If the target value is present, return its index.
//        If the target value is not found, return the index of least element greater than equal to B.
//        If the target value is not found and least number greater than equal to target is also not present, return the length of array (i.e. the position where target can be placed)
//        Your solution should have a time complexity of O(log(N)).
public class FindTarget {
    public int searchInsert(int[] A, int B) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid] == B) {
                return mid;
            } else if (A[mid] < B) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    //////////////////////////////////////////////////////////////////////////////////
    public int solve(TreeNode A, int B) {
        return findValueRecursively(A, B) ? 1 : 0;
    }
    public boolean findValueRecursively(TreeNode node, int value) {
        if (node == null) {
            return false;
        }
        return
                node.val == value ||
                        findValueRecursively(node.left, value) ||
                        findValueRecursively(node.right, value);
    }
}
