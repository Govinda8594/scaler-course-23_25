package com.scaler.Scaler.LinkedList;

public class ReverseKGroupElementInLinkedList {
    // Another question reverse every adjecent element in the list i.e meaning K=2 every group
    public ListNode reverseList(ListNode A, int B) {
        if (A == null || B <= 1) {
            return A;
        }
        ListNode curr = A;
        ListNode prev = null; // prev
        ListNode temp;
        int c = B;
        while (c > 0 && A != null) {
            temp = A;
            A = A.next;
            temp.next = prev;
            prev = temp;
            c = c - 1;
        }
        curr.next = A;
        ListNode x = reverseList(A, B);
        curr.next = x;
        return prev;
    }


}
