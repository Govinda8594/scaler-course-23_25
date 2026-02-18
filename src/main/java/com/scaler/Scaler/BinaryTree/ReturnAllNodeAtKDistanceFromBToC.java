package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;

//Given the root of a binary tree A, the value of a target node B, and an integer C.
//        Return an array of the values of all nodes that have a distance C from the target node B.
//        Note :- The target node B always exist. All the nodes has unique value
public class ReturnAllNodeAtKDistanceFromBToC {
    static boolean getpath(TreeNode root, int k, ArrayList<TreeNode> path) {
        if (root == null) {
            return false;
        }
        if (root.val == k || getpath(root.left, k, path) || getpath(root.right, k, path)) {
            path.add(root);
            return true;
        }
        return false;
    }

    static void addBelowNode(TreeNode root, int k, ArrayList<Integer> ans) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            ans.add(root.val);
            return;
        }
        addBelowNode(root.left, k - 1, ans);
        addBelowNode(root.right, k - 1, ans);
    }

    public ArrayList<Integer> KDistanceNodes(TreeNode root, int target, int k) {
        // return the sorted list of all nodes at k dist
        ArrayList<TreeNode> path = new ArrayList<>();
        getpath(root, target, path);
        ArrayList<Integer> ans = new ArrayList<>();
        addBelowNode(path.get(0), k, ans);
        for (int i = 1; i < path.size(); i++) {
            if (k - i == 0) {
                ans.add(path.get(i).val);
                break;
            }
            if (path.get(i).left.equals(path.get(i - 1))) {
                addBelowNode(path.get(i).right, k - i - 1, ans);
            } else {
                addBelowNode(path.get(i).left, k - i - 1, ans);
            }
        }
        Collections.sort(ans);
        return ans;
    }
    ///////////////////////*******************************************/////////////////////

    public int countNode(TreeNode A, int B, int C) {
        // Create an ArrayList to store the path from root to node B
        ArrayList<TreeNode> path = new ArrayList<>();
        // Get the path from root to node B
        getpath(A, B, path);
        // Initialize a counter for the number of nodes at distance C from node B
        int c = below(path.get(0), C);
        // Traverse the path from B to root
        for (int i = 1; i < path.size(); i++) {
            // If the remaining distance is 0, increment the counter and break
            if (C - i == 0) {
                c++;
                break;
            }
            // If the current node's left child is the previous node, add nodes below its right child
            if (path.get(i).left.equals(path.get(i - 1))) {
                c = c + below(path.get(i).right, C - i - 1);
            } else {
                // Otherwise, add nodes below the current node's left child
                c = c + below(path.get(i).left, C - i - 1);
            }
        }
        // Return the total count of nodes at distance C from node B
        return c;
    }

    int below(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        int left = below(root.left, k - 1);
        int right = below(root.right, k - 1);
        return left + right;
    }


}
