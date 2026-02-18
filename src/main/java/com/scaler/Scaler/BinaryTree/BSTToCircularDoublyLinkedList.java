package com.scaler.Scaler.BinaryTree;

//Given a binary tree convert it into circular doubly linked list based on the following rules:
//        The left and right pointers in nodes are to be used as previous and next pointers respectively in converted Circular Linked List.
//        The order of nodes in List must be same as Inorder of the given Binary Tree.
//        The first node of Inorder traversal must be the head node of the Circular List.
//        NOTE: You are expected to convert the binary tree into Doubly linked list in place.
public class BSTToCircularDoublyLinkedList {

    TreeNode current;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        BSTToCircularDoublyLinkedList bstToCircularDoublyLinkedList = new BSTToCircularDoublyLinkedList();
        root = bstToCircularDoublyLinkedList.solve2(root);

    }

    TreeNode solve2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode Dummy = new TreeNode(-1);
        current = Dummy;
        Dfs(root);
        TreeNode head = Dummy.right;
        // Connect head and tail to form circular list
        head.left = current;
        current.right = head;
        return head;
    }

    public void Dfs(TreeNode node) {
        if (node == null) return;
        Dfs(node.left);
        // Link current node to the list
        current.right = node;
        node.left = current;
        current = current.right; // Update current to the last processed node
        Dfs(node.right);
    }
    //////////////////////////////////////////////////////////////////////////

    TreeNode combine(TreeNode head1, TreeNode head2) {
        // If either of the list is empty, then return the other list
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        // Store the last Node of left List
        TreeNode tail1 = head1.left;
        // Store the last Node of right List
        TreeNode tail2 = head2.left;
        // Connect the last node of Left List with the first Node of the right List
        if (tail1 != null) {
            tail1.right = head2;
        }
        head2.left = tail1;
        // left of first node refers to the last node in the list
        head1.left = tail2;
        // Right of last node refers to the first node of the List
        if (tail2 != null) {
            tail2.right = head1;
        }
        // Return the Head of the List
        return head1;
    }

    // Method converts a tree to a circular Link List and then returns the head of the Link List
    TreeNode BSTToCircularDoublyLinked(TreeNode root) {
        if (root == null) {
            return null;
        }
        // Recursively convert left and right subtrees
        TreeNode head1 = BSTToCircularDoublyLinked(root.left);
        TreeNode head2 = BSTToCircularDoublyLinked(root.right);
        // Make a circular linked list of single node (or root). To do so, make the right and left pointers of this node point to itself
        root.left = root.right = root;
        // Step 1 (concatenate the left list with the list with single node, i.e., current node)
        // Step 2 (concatenate the returned list with the right List)
        head1 = combine(head1, root);
        head1 = combine(head1, head2);
        return head1;
    }

    TreeNode solve(TreeNode root) {
        return BSTToCircularDoublyLinked(root);
    }
}
