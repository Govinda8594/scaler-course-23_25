package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {
    public ArrayList<Integer> solve3(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(A);
        while (queue.size() > 0) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.remove();
                if (i == 0) {
                    ans.add(curr.val);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return ans;
    }
}
