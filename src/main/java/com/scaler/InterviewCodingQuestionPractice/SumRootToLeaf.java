package com.scaler.InterviewCodingQuestionPractice;


public class SumRootToLeaf {
    static long total = 0;
    static int mod = (int)1e9+7;
    public static int rootToLeafSum( BinaryTreeNode<Integer> root ) {
        // Write your code here.
        total = 0L;
        dfs(root,total);
        return (int)(total%mod);
    }

    static void dfs(BinaryTreeNode<Integer> root, long sum){
        if(root == null) return;
        sum = (sum * 10L + root.data)%mod;
        if(root.left == null && root.right == null){
            total = (total + sum)%mod;
            return;
        }
         dfs(root.left,sum);
         dfs(root.right,sum);   
    }

    static class BinaryTreeNode <T> {
        public T data;
        public BinaryTreeNode <T> left;
        public BinaryTreeNode <T> right;

        BinaryTreeNode (T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}
