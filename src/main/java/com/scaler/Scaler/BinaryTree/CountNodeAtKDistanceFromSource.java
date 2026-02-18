package com.scaler.Scaler.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class CountNodeAtKDistanceFromSource {

    // Example usage
    public static void main(String[] args) {
        // Create your binary tree and call the findNodesAtDistance method
        // Example: Node root = ...;
        List<Node> nodesAtK = new CountNodeAtKDistanceFromSource().findNodesAtDistance(new Node(5), 2);

        // Count node at distance k
        int count = new CountNodeAtKDistanceFromSource().below(new Node(5), 2);
        System.out.println(nodesAtK);
    }

    // Helper function to find nodes at distance k from a given node
    List<Node> findNodesAtDistance(Node root, int k) {
        List<Node> result = new ArrayList<>();
        findNodes(root, k, result);
        return result;
    }

    // Recursive function to find nodes at distance k
    void findNodes(Node root, int k, List<Node> result) {
        if (root == null || k < 0) {
            return;
        }
        if (k == 0) {
            result.add(root);
            return;
        }
        findNodes(root.left, k - 1, result);
        findNodes(root.right, k - 1, result);
    }

    int below(Node root, int k) {
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
