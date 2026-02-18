package com.scaler.Scaler.LinkedList;

public class ReverseLinkedList {
    public void solve(ListNode A) {
        reverse(A);
        System.out.println();
    }

    public void reverse(ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        System.out.print(head.val + " ");
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
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
