package com.scaler.Scaler.LinkedList;

public class RemoveNthNodeFromEnd {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * public int val;
     * public ListNode next;
     * ListNode(int x) { val = x; next = null; }
     * }
     */
    public ListNode removeNthFromEnd2(ListNode A, int B) {
        int n;
        ListNode node;
        if (A == null)
            return null;
        n = 0;
        node = A;
        // calculates the size of the linked list
        while (node != null) {
            n++;
            node = node.next;
        }
        if (B >= n) {
            return A.next;
        }
        node = A;
        for (int i = 0; i < n - B - 1; i++)
            node = node.next;
        node.next = node.next.next;
        return A;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy, slow = dummy;

        // Move fast n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Remove nth node
        slow.next = slow.next.next;

        return dummy.next;
    }


}
