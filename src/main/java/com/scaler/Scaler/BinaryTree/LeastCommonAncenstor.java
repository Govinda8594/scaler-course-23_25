package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;

//Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
//        Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
public class LeastCommonAncenstor {

    /////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        int result = lca2(root, 5, 1);
        System.out.println("Lowest Common Ancestor: " + result);
    }

    // //Using two ArrayList
    public static int lca2(TreeNode A, int B, int C) {
        ArrayList<Integer> pathB = new ArrayList();
        ArrayList<Integer> pathC = new ArrayList();
        boolean foundB = getPath(A, B, pathB);
        boolean foundC = getPath(A, C, pathC);
        if (!foundB || !foundC) {
            return -1;
        }
        pathB.retainAll(pathC);
        return pathB.get(0);
    }

    public static boolean getPath(TreeNode A, int key, ArrayList<Integer> path) {
        if (A == null) {
            return false;
        }
        if (A.val == key || getPath(A.left, key, path) || getPath(A.right, key, path)) {
            path.add(A.val);
            return true;
        }
        return false;
    }

    public int lca(TreeNode A, int B, int C) {
        if (checkNodes(A, B) && checkNodes(A, C)) {
            return lcaValue(A, B, C);
        }
        return -1;
    }

    public boolean checkNodes(TreeNode A, int a) {
        if (A == null) {
            return false;
        }
        if (A.val == a) {
            return true;
        }
        return checkNodes(A.left, a) || checkNodes(A.right, a);
    }

    public int lcaValue(TreeNode A, int B, int C) {
        if (A == null) {
            return -1;
        }
        if (A.val == B || A.val == C) {
            return A.val;
        }
        int left = lcaValue(A.left, B, C);
        int right = lcaValue(A.right, B, C);
        if (left != -1 && right != -1) {
            return A.val;
        }
        if (left != -1) {
            return left;
        } else {
            return right;
        }
    }

    ////////////////////////////works for Binary Search Tree, not working for binary tree///////////////////////////////////////////////////////////////
    TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null; // If root is null, return null.

        // If root is one of p or q, it is the LCA.
        if (root.val == p.val || root.val == q.val)
            return root;

        // If both p and q are smaller than root, LCA is in the left subtree.
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        // If both p and q are greater than root, LCA is in the right subtree.
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        // If p and q are on different sides of root, root is the LCA.
        return root;
    }

}
