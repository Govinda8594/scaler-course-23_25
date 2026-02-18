package com.scaler.Scaler.LinkedList;

public class DeleteNodeInDoublyLinkedList {

    static void deleteNode(DoubleNode DoubleNode) {
        DoubleNode.prev.next = DoubleNode.next;
        DoubleNode.next.prev = DoubleNode.prev;
        DoubleNode.prev = null;
        DoubleNode.next = null;
    }

    void insert(DoubleNode newnode, DoubleNode tail) {
        newnode.next = tail;
        newnode.prev = tail.prev;
        tail.prev.next = newnode;
        tail.prev = newnode;
    }
}
