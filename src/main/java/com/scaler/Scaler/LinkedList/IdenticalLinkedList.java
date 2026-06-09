package com.scaler.Scaler.LinkedList;

public class IdenticalLinkedList {

    public static int solve(ListNode A, ListNode B) {

        while (A != null && B != null) {
            if (A.val != B.val)
                return 0;
            A = A.next;
            B = B.next;
        }
        return 1;
    }

    public void main(String[] args) {
        ListNode A = new ListNode(16);
        A.next = new ListNode(3).next = new ListNode(3).next = new ListNode(6);
        ListNode B = new ListNode(10).next = new ListNode(9).next = new ListNode(18);

        solve(A, B);

    }
}


