package com.scaler.Scaler.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
//Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.
//        NOTE: Consider the level of root node as 1.
public class DifferenceInEvenAndOddLevel {

    public int solve(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<>();
        if (A == null) {
            return 0;
        }
        int oddsum = 0;
        int evensum = 0;
        int level = 0;
        q.add(A);
        while (q.size() > 0) {
            // q contains all the nodes in a level
            int n = q.size();
            level ^= 1;
            while (n-- > 0) {
                TreeNode temp = q.peek();
                q.remove();
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
                if (level != 0) {
                    oddsum += temp.val;
                } else {
                    evensum += temp.val;
                }
            }
        }
        return (oddsum - evensum);
    }
    /////////////////////////////////////////////////////////////
    public int solve2(TreeNode A) {
        int diff = 0;
        int oddLevelSum = 0;
        int evenLevelSum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        int level = 1;
        while (q.size() > 0) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                TreeNode temp = q.peek();
                q.poll();
                if (level % 2 == 0) {
                    evenLevelSum += temp.val;
                } else {
                    oddLevelSum += temp.val;
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            level++;
        }
        diff = oddLevelSum - evenLevelSum;
        return diff;
    }
    ////////////////////////////////////////////////////////////////////

    public long oddSum = 0;
    public long evenSum = 0;

    public int solve3(TreeNode A) {
        Traverse(A, 1);
        return (int) (oddSum - evenSum);
    }

    private void Traverse(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level % 2 == 0) {
            evenSum = evenSum + node.val;
        } else {
            oddSum = oddSum + node.val;
        }
        Traverse(node.left, level + 1);
        Traverse(node.right, level + 1);
    }
}
