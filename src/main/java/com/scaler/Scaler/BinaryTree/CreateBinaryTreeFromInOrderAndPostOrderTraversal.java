package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;

public class CreateBinaryTreeFromInOrderAndPostOrderTraversal {
    //        A = inoreder
//        B = postorder
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A.isEmpty()) {
            return null;
        }
        int idx = A.indexOf(B.remove(B.size() - 1));
        TreeNode root = new TreeNode(A.get(idx));
        root.right = buildTree(new ArrayList<>(A.subList(idx + 1, A.size())), B);
        root.left = buildTree(new ArrayList<>(A.subList(0, idx)), B);
        return root;
    }

    ////////////////////////////////////////////////////////////////////////////
    TreeNode buildTree(int n, int[] in, int[] post) {
        // Your code here
        int[] idx = {n - 1};
        return createTree(in, post, 0, n - 1, idx);
    }

    TreeNode createTree(int[] in, int[] post, int start, int end, int[] idx) {
        if (start > end) {
            return null;
        }
        int pos = search(in, post[idx[0]], start, end);
        TreeNode root = new TreeNode(post[idx[0]]);
        idx[0]--;
        root.right = createTree(in, post, pos + 1, end, idx);
        root.left = createTree(in, post, start, pos - 1, idx);
        return root;
    }

    int search(int[] in, int val, int start, int end) {
        while (start <= end) {
            if (in[start] == val) {
                break;
            }
            start++;
        }
        return start;
    }
}
