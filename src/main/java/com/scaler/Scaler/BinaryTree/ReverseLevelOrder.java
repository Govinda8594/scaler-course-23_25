package com.scaler.Scaler.BinaryTree;

import java.util.*;

// A class to store a binary tree node
class Node {
    int key;
    Node left = null, right = null;

    Node(int key) {
        this.key = key;
    }
}

public class ReverseLevelOrder {
    // Function to print reverse level order traversal of a given binary tree
    public static void reverseLevelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        // create a stack to reverse level order nodes
        Deque<Integer> stack = new ArrayDeque<>();
        // to store the current node
        Node curr;
        // loop till queue is empty
        while (!queue.isEmpty()) {
            // process each node in the queue and enqueue their children
            curr = queue.poll();
            // push the current node into the stack
            stack.push(curr.key);
            // it is important to process the right node before the left node
            if (curr.right != null) {
                queue.add(curr.right);
            }
            if (curr.left != null) {
                queue.add(curr.left);
            }
        }
        // pop all nodes from the stack and print them
        while (!stack.isEmpty()) {
            System.out.print(stack.poll() + " ");
        }
    }

//     prints in reverse level order
    public static void reverseLevelOrderTraversal(TreeNode startNode) {
        Queue<TreeNode> queue=new LinkedList<>();
        Stack<TreeNode> stack=new Stack<>();
        queue.add(startNode);
        while(!queue.isEmpty())
        {
            TreeNode tempNode=queue.poll();
            if(tempNode.right!=null)
                queue.add(tempNode.right);
            if(tempNode.left!=null)
                queue.add(tempNode.left);

            stack.push(tempNode);
        }

        while(!stack.empty())
            System.out.print(stack.pop().val+" " );
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
        reverseLevelOrderTraversal(root);
    }
}
