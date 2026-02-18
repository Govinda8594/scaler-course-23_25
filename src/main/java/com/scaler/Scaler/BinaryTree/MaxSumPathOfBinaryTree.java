package com.scaler.Scaler.BinaryTree;
//Given a binary tree T, find the maximum path sum.
//        The path may start and end at any node in the tree.
//        Note: A maximum sum path is any path which has the maximum sum of the nodes lying on the path.
public class MaxSumPathOfBinaryTree {

    /////////////////////////////////////////////////////////////////
        int maxSum = Integer.MIN_VALUE;
        public int maxPathSum2(TreeNode A) {
            // Travel through post order
            postOrder(A);

            return maxSum;
        }

        private int postOrder(TreeNode node) {
            if (node == null) return 0;
            //Calculate Best left sum possible;
            int leftSum = Math.max(0, postOrder(node.left));
            //Calculate Best right sum possible;
            int rightSum = Math.max(0, postOrder(node.right));
            maxSum = Math.max(maxSum, leftSum + rightSum + node.val);
            //Choose left path or right path
            return Math.max(leftSum,rightSum)+ node.val;
        }
}
