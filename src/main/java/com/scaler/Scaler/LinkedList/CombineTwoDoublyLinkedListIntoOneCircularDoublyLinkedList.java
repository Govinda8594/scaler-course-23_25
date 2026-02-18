package com.scaler.Scaler.LinkedList;

public class CombineTwoDoublyLinkedListIntoOneCircularDoublyLinkedList {

    // Function to merge two doubly linked lists into a circular doubly linked list
    public DoubleNode mergeToCircular(DoubleNode head1, DoubleNode head2) {
        if (head1 == null) return head2; // If first list is empty
        if (head2 == null) return head1; // If second list is empty

        // Find the tail of the first list
        DoubleNode tail1 = head1;
        while (tail1.next != null) {
            tail1 = tail1.next;
        }

        // Find the tail of the second list
        DoubleNode tail2 = head2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }

        // Connect the two lists
        tail1.next = head2;
        head2.prev = tail1;

        // Make it circular
        tail2.next = head1;
        head1.prev = tail2;

        return head1; // Return the head of the circular doubly linked list
    }

    DoubleNode combine(DoubleNode h1, DoubleNode h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;
        DoubleNode t1 = h1.prev;
        DoubleNode t2 = h2.prev;
        t1.next = h2;
        h2.prev = t1;
        h1.prev = t2;
        t2.next = h1;
        return h1;
    }

}
