package com.scaler.Scaler.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfBT {

    public int[] solve2(TreeNode A) {
        int[] ans = new int[treeSize(A)];
        int j = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (i == size - 1) {
                    ans[j++] = temp.val;
                }
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return ans;
    }

    public int treeSize(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return 1 + Math.max(treeSize(A.left), treeSize(A.right));
    }
    
}
