package com.scaler.InterviewCodingQuestionPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	static class BinaryTreeNode<T> {
		T val;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}

        public static ArrayList<Integer> getLevelOrder(BinaryTreeNode root) {
            //Your code goes here
            ArrayList<Integer> ans = new ArrayList<>();
            if(root == null) return ans;
            Queue<BinaryTreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                BinaryTreeNode curr = q.poll();
                ans.add((Integer) curr.val);
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            return ans;
        }

}
