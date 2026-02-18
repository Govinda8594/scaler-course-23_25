package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if (A == null) {
            return ans;
        }
        q.add(A);
        while (!q.isEmpty()) {
            ArrayList<Integer> arr = new ArrayList<Integer>();
            int N = q.size();
            for (int i = 0; i < N; i++) {
                TreeNode curr = q.remove();
                arr.add(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            ans.add(arr);
        }
        return ans;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////
    public int[][] levelOrder(TreeNode A) {
        List<int[]> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            int n = q.size();
            int[] level = new int[n];
            for (int i = 0; i < n; i++) {
                TreeNode temp = q.remove();
                level[i] = temp.val;
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            list.add(level);
        }
        int n = list.size();
        int[][] ans = new int[n][];
        int index = 0;
        for (int[] level : list) {
            ans[index++] = level;
        }
        return ans;
    }
    /////////////////////////////////////////////////////////////////////////////
    public void printLevelOrder(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (A == null) {
            return;
        }
        q.add(A);
        while (!q.isEmpty()) {
            int N = q.size();
            for (int i = 0; i < N; i++) {
                TreeNode curr = q.remove();
                System.out.print(curr.val);
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }
}
