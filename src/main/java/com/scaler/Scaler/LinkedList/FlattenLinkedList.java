package com.scaler.Scaler.LinkedList;

//Given a linked list where every node represents a linked list and contains two pointers of its type:
//
//        Pointer to next node in the main list (right pointer)
//        Pointer to a linked list where this node is head (down pointer). All linked lists are sorted.
//        You are asked to flatten the linked list into a single list. Use down pointer to link nodes of the flattened list. The flattened linked list should also be sorted.
public class FlattenLinkedList {


    FListNode merge(FListNode a, FListNode b) {
        FListNode temp = new FListNode(0);
        FListNode res = temp;
        while (a != null && b != null) {
            if (a.val < b.val) {
                temp.down = a;
                temp = temp.down;
                a = a.down;
            } else {
                temp.down = b;
                temp = temp.down;
                b = b.down;
            }
        }
        if (a != null) {
            temp.down = a;
        } else {
            temp.down = b;
        }
        return res.down;
    }

    FListNode flatten(FListNode root) {
        if (root == null || root.right == null) {
            return root;
        }
        root.right = flatten(root.right);
        root = merge(root, root.right);
        return root;
    }
}
