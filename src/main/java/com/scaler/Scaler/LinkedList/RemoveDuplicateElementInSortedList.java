package com.scaler.Scaler.LinkedList;

public class RemoveDuplicateElementInSortedList {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * public int val;
     * public ListNode next;
     * ListNode(int x) { val = x; next = null; }
     * }
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////
    public ListNode deleteDuplicates2(ListNode A) {
        if (A == null)
            return A;
        ListNode next;
        ListNode prevNode;
        int prev = A.val;
        next = A.next;
        prevNode = A;
        while (next != null) {
            if (next.val == prev) {
                prevNode.next = next.next;
            } else {
                prevNode = next;
                prev = next.val;
            }
            next = next.next;
        }
        return A;
    }
}
