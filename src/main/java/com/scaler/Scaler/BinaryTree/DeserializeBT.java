package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DeserializeBT {

    public TreeNode solve(ArrayList<Integer> A) {
        //Use queue to store new treenodes as they are created
        //Pop them out one by one and assign left and right children
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(A.get(0));
        q.add(root);
        TreeNode currNode;
        for (int i = 1; i < A.size(); i = i + 2) {
            currNode = q.remove();
            if (A.get(i) != -1) {
                currNode.left = new TreeNode(A.get(i));
                q.add(currNode.left);
            }
            if (A.get(i + 1) != -1) {
                currNode.right = new TreeNode(A.get(i + 1));
                q.add(currNode.right);
            }
        }
        return root;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////
    public TreeNode solve2(ArrayList<Integer> A) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(new TreeNode(A.get(0)));
        int i = 1;
        TreeNode head = queue.peek();
        while (!queue.isEmpty() && i < A.size()) {
            TreeNode poll = queue.poll();
            if (A.get(i) != -1) {
                poll.left = new TreeNode(A.get(i));
                queue.add(poll.left);
            }
            i++;
            if (A.get(i) != -1) {
                poll.right = new TreeNode(A.get(i));
                queue.add(poll.right);
            }
            i++;
        }
        return head;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////
    public TreeNode solve(int[] A) {
        TreeNode root = new TreeNode(A[0]);
        Queue<TreeNode> q = new LinkedList<>();
        int index = 1;
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode temp = q.remove();
            if (temp == null) {
                continue;
            }
            TreeNode node;
            for (int i = 0; i < 2; i++) {//for left and right child
                if (A[index] == -1) {
                    node = null;
                } else {
                    node = new TreeNode(A[index]);
                }
                index++;
                if (i % 2 == 0) {
                    temp.left = node;
                    q.add(temp.left);
                } else {
                    temp.right = node;
                    q.add(temp.right);
                }
            }
        }
        return root;
    }
}
