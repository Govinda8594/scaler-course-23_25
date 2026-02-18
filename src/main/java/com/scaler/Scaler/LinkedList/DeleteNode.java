package com.scaler.Scaler.LinkedList;

public class DeleteNode {

    public ListNode removeNthFromEnd(ListNode A, int B) {
        ListNode fast = A;
        ListNode slow = A;
        if (fast.next != null) return fast;
        for (int i = 0; i < B; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            A = A.next;
            return A;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return A;
    }

    public ListNode solve(ListNode A, int B) {
        int count = 0;
        ListNode current = A;
        if (B == 0) {
            return A.next;
        } else {
            while (count < B - 1) {
                current = current.next;
                count++;
            }
            current.next = current.next.next;
        }
        return A;
    }
}
