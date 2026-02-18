package com.scaler.Scaler.BinaryTree;

import java.util.*;

public class TopViewOfBinaryTree {
    public ArrayList<Integer> solve(TreeNode A) {
        return topview(A);
    }

    public ArrayList<Integer> topview(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }
        Queue<Pair> level = new LinkedList<Pair>();
        level.add(new Pair(root, 0));
        HashMap<Integer, Integer> top = new HashMap<Integer, Integer>();
        //Using Level order traversal to find the top view
        while (!level.isEmpty()) {
            Pair curr = level.peek();
            level.remove();
            top.computeIfAbsent(curr.second, k -> curr.first.val);
            if (curr.first.left != null) {
                level.add(new Pair(curr.first.left, curr.second - 1));
            }
            if (curr.first.right != null) {
                level.add(new Pair(curr.first.right, curr.second + 1));
            }
        }
        for (Map.Entry elem : top.entrySet()) {
            ans.add((int) elem.getValue());
        }
        return ans;
    }


    class Pair {

        public TreeNode first;
        public int second;

        public Pair(TreeNode x, int y) {
            first = x;
            second = y;
        }
    }
}
