package com.scaler.Scaler.LinkedList;

//Given a singly linked list A
//
//        A: A0 → A1 → … → An-1 → An
//        reorder it to:
//
//        A0 → An → A1 → An-1 → A2 → An-2 → …
//        You must do this in-place without altering the nodes' values.
public class ReorderList {
    public ListNode reorderList(ListNode A) {
        if (A.next == null) {
            return A;
        }
        ListNode slow = A;
        ListNode fast = A;
        // to find mid vlaue
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h1 = A;
        ListNode mid = slow.next;  // actual mid
        slow.next = null;  // to make first node end as null
        ListNode h2 = reverseList(mid);  // reverse the Linked list and store the head to h2
        while (h1 != null && h2 != null) {  // add the nodes alrednatively
            ListNode temp1 = h1.next;  // we need to store that values
            ListNode temp2 = h2.next;
            h1.next = h2;
            h1 = temp1;
            h2.next = h1;
            h2 = temp2;
        }
        return A;
    }

    public ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode curr;
        while (A != null) {
            curr = A;
            A = A.next;
            curr.next = prev;
            prev = curr;
        }
        return prev;
    }
}
