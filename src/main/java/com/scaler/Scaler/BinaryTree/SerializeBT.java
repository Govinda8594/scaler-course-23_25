package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Given the root node of a Binary Tree denoted by A. You have to Serialize the given Binary Tree in the described format.
//
//        Serialize means encode it into a integer array denoting the Level Order Traversal of the given Binary Tree.
//
//        NOTE:
//
//        In the array, the NULL/None child is denoted by -1.
//        For more clarification check the Example Input.

public class SerializeBT {
    public int[] solve2(LevelOrderTraversal.TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<LevelOrderTraversal.TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            LevelOrderTraversal.TreeNode temp = q.remove();
            if (temp != null) {
                list.add(temp.val);
            } else {
                list.add(-1);
                continue;
            }
            q.add(temp.left);
            q.add(temp.right);
        }
        // System.out.println(list);
        int n = list.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
