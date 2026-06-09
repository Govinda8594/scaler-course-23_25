package com.scaler.Scaler.BinaryTree;

import java.util.*;

//Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).
public class ZigZaglevelOfBinaryTree {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Stack<TreeNode> stack1 = new Stack<>(), stack2 = new Stack<>();
        ArrayList<ArrayList<Integer>> zigzag = new ArrayList<>();
        if (A == null) {
            return null;
        }
        stack1.push(A);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                level.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }
            if (!level.isEmpty()) {
                zigzag.add(level);
            }
            level = new ArrayList<>();
            while (!stack2.isEmpty()) {
                TreeNode node = stack2.pop();
                level.add(node.val);
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
            if (!level.isEmpty()) {
                zigzag.add(level);
            }
        }
        return zigzag;
    }

    ///////////////////////////////////////////////////////////////////
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder2(TreeNode A) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode temp = q.poll();
                level.add(temp.val);
                if (temp.right != null) {
                    q.add(temp.right);
                }
                if (temp.left != null) {
                    q.add(temp.left);
                }
            }
            //checking for zigzag if even then reverse  the order
            if (al.size() % 2 == 0) {
                Collections.reverse(level);
            }
            al.add(level);
        }
        return al;
    }

    /////////////////////////////////////////////////////////////////
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder3(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> evenStack = new Stack<>();
        Stack<TreeNode> oddStack = new Stack<>();
        evenStack.add(root);
        int level = 1;
        while (!evenStack.isEmpty() || !oddStack.isEmpty()) {
            if (level % 2 == 0) {//even level l->r
                int n = evenStack.size();
                ArrayList<Integer> list = new ArrayList<>(n);
                while (!oddStack.isEmpty()) {
                    TreeNode temp = oddStack.pop();
                    list.add(temp.val);
                    if (temp.right != null) {
                        evenStack.add(temp.right);
                    }
                    if (temp.left != null) {
                        evenStack.add(temp.left);
                    }
                }
                result.add(list);
            } else {//odd level r->l
                int n = evenStack.size();
                ArrayList<Integer> list = new ArrayList<>(n);
                while (!evenStack.isEmpty()) {
                    TreeNode temp = evenStack.pop();
                    list.add(temp.val);
                    if (temp.left != null) {
                        oddStack.add(temp.left);
                    }
                    if (temp.right != null) {
                        oddStack.add(temp.right);
                    }
                }
                result.add(list);
            }
            level++;
        }
        return result;
    }
}
