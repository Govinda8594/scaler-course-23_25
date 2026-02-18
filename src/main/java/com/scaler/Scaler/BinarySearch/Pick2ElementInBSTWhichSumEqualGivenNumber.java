package com.scaler.Scaler.BinarySearch;

import com.scaler.Scaler.BinaryTree.TreeNode;

import java.util.*;

public class Pick2ElementInBSTWhichSumEqualGivenNumber {

    Set<Integer> set;
    /////////////////////////////////////////////////////////////////

    public int t2Sum(TreeNode A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (map.containsKey(B - node.val)) {
                return 1;
            } else {
                map.put(node.val, 1);
            }
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return 0;
    }
    ////////////////////////////////////////////////////////////////

    public int t2Sum3(TreeNode A, int B) {
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode current1 = A;
        TreeNode current2 = A;
        while (((!stack1.isEmpty()) || current1 != null) || (!stack2.isEmpty()) || current2 != null) {
            if (current1 != null || current2 != null) {
                if (current1 != null) {
                    stack1.push(current1);
                    current1 = current1.left;
                }
                if (current2 != null) {
                    stack2.push(current2);
                    current2 = current2.right;
                }
            } else {
                if (stack1.isEmpty() || stack2.isEmpty()) {
                    break;
                }
                TreeNode node1 = stack1.peek();
                TreeNode node2 = stack2.peek();
                int sum = node1.val + node2.val;
                if (node1.val == node2.val) {
                    return 0;
                } else if (sum == B) {
                    return 1;
                } else if (sum < B) {
                    stack1.pop();
                    current1 = node1.right;
                } else {
                    stack2.pop();
                    current2 = node2.left;
                }
            }
        }
        return 0;
    }

    public int t2Sum2(TreeNode A, int B) {
        set = new HashSet<>();
        return isTwoSum(A, B) ? 1 : 0;
    }

    boolean isTwoSum(TreeNode node, int B) {
        if (node == null) {
            return false;
        }
        if (set.contains(B - (node.val))) {
            return true;
        }
        set.add(node.val);
        return isTwoSum(node.left, B) || isTwoSum(node.right, B);
    }
}
