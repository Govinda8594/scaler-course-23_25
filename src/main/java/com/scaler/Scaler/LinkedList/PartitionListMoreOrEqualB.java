package com.scaler.Scaler.LinkedList;

//Given a linked list A and a value B, partition it such that all nodes less than B come before nodes greater than or equal to B.
//        You should preserve the original relative order of the nodes in each of the two partitions.
public class PartitionListMoreOrEqualB {
    public ListNode partition(ListNode A, int B) {
        ListNode less = new ListNode(-1);
        ListNode more = new ListNode(-1);
        ListNode left = less;
        ListNode right = more;
        ListNode current = A;
        while (current != null) {
            if (current.val < B) {
                left.next = current;
                left = left.next;
            } else {
                right.next = current;
                right = right.next;
            }
            current = current.next;
        }
        right.next = null;
        left.next = more.next;
        return less.next;
    }
}
