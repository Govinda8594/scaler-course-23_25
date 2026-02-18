package com.scaler.Scaler.BinaryTree;

public class MinimumSwapRequiredToMakeBinaryTreeIndentical {

//    given a root of 2 binary tree. make them identical but operation is only allowed in binary tree A.
//    in each node operation you can swap the left pointer and right pointer of any node
//    find minimum no of operation required to make both trees identical .If impossible return -1.
//    note : every node has distinct values
//
//    write a java code soution for this problem
        Node root;
        int count = 0;

        boolean areIdentical(Node root1, Node root2) {
            if (root1 == null && root2 == null)
                return true;
            if (root1 == null || root2 == null)
                return false;
            if (root1.key != root2.key)
                return false;
            return (areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
        }

        void swapLeftRight(Node root) {
            if (root == null)
                return;
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            swapLeftRight(root.left);
            swapLeftRight(root.right);
        }

        boolean makeIdentical(Node root1, Node root2) {
            if (root1 == null && root2 == null)
                return true;
            if (root1 == null || root2 == null)
                return false;
            if (root1.key != root2.key)
                return false;
            swapLeftRight(root1);
            if (areIdentical(root1, root2)) {
                return true;
            }
            swapLeftRight(root1);
            return (makeIdentical(root1.left, root2.left) && makeIdentical(root1.right, root2.right));
        }

        int minimumSwaps(Node root1, Node root2) {
            if (!makeIdentical(root1, root2))
                return -1;
            return count;
        }

        public static void main(String[] args) {
            MinimumSwapRequiredToMakeBinaryTreeIndentical tree = new MinimumSwapRequiredToMakeBinaryTreeIndentical();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(6);
            tree.root.right.right = new Node(7);

            MinimumSwapRequiredToMakeBinaryTreeIndentical tree2 = new MinimumSwapRequiredToMakeBinaryTreeIndentical();
            tree2.root = new Node(1);
            tree2.root.left = new Node(3);
            tree2.root.right = new Node(2);
            tree2.root.left.left = new Node(7);
            tree2.root.left.right = new Node(6);
            tree2.root.right.left = new Node(5);
            tree2.root.right.right = new Node(4);

            System.out.println("Minimum number of swaps required to make both trees identical: " + tree.minimumSwaps(tree.root, tree2.root));
        }


}
