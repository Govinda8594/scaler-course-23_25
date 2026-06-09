package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;

public class CreateBinaryTreeFromInOrderAndPreOrderTraversal {
    //    A = preorder
//    B = inorder
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (B.isEmpty()) {
            return null;
        }
        // Find the index of the root value in the inorder list.
        int rootIndexInInorder = B.indexOf(A.remove(0));
        TreeNode root = new TreeNode(B.get(rootIndexInInorder));
        // Recursively build the left and right subtrees.
        root.left = buildTree(A, new ArrayList<>(B.subList(0, rootIndexInInorder)));
        root.right = buildTree(A, new ArrayList<>(B.subList(rootIndexInInorder + 1, B.size())));
        return root;
    }

    ////////////////////////////////////////////////////////////////////////////
    public static Node buildTree(int inorder[], int preorder[], int n) {
        // code here
        int[] index = {0};
        Node root = tree(inorder, preorder, 0, n - 1, index);
        return root;
    }
    public static Node tree(int[] inorder, int[] pre, int start, int end, int[] index) {
        if (start > end) {
            return null;
        }
        int pos = search(inorder, pre[index[0]], start, end);
        Node node = new Node(pre[index[0]++]);
        node.left = tree(inorder, pre, start, pos - 1, index);
        node.right = tree(inorder, pre, pos + 1, end, index);
        return node;
    }
    public static int search(int[] B, int value, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (B[i] == value) {
                return i;
            }
        }
        return 0;
    }


}
