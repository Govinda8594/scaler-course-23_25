package com.scaler.Scaler.LinkedList;

public class ReturnMiddleElement {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * public int val;
     * public ListNode next;
     * ListNode(int x) { val = x; next = null; }
     * }
     */
    public int midElement(ListNode A) {
        if (A == null) {
            return 0;
        }
        ListNode fast = A, slow = A, lastslow = A;
        while (fast != null && fast.next != null) {
            lastslow = slow; // secondmid
            slow = slow.next; // mid
            fast = fast.next.next;
        }
        return slow.val;
    }
    // used in palindromic check
    ListNode midElement2(ListNode A) {
        if (A.next == null) {
            return A;
        }
        ListNode fast = A, slow = A, lastslow = A;
        while (fast.next != null && fast.next.next != null) {
            lastslow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
