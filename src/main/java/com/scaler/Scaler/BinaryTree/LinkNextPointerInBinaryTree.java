package com.scaler.Scaler.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

//Given a binary tree,
//        Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//        Initially, all next pointers are set to NULL.
//        Assume perfect binary tree.
public class LinkNextPointerInBinaryTree {

    //Using two loop for any type of BT
    public void connect3(TreeLinkNode root) {
        Queue<TreeLinkNode> link = new LinkedList();
        link.offer(root);
        int size;
        while (!link.isEmpty()) {
            size = link.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = link.poll();
                if (node.left != null) {
                    link.offer(node.left);
                }
                if (node.right != null) {
                    link.offer(node.right);
                }
                if (i != size - 1) {
                    node.next = link.peek();
                }
            }
        }
    }

    /// //O(1) sC for perfect BT
    public void connect5(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode t = root;
        while (t.left != null) {
            TreeLinkNode curr = t;
            while (t != null) {
                t.left.next = t.right;
                if (t.next != null) {
                    t.right.next = t.next.left;
                }
                t = t.next;
            }
            t = curr.left;
        }
    }

    //      Definition for binary tree with next pointer.
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
