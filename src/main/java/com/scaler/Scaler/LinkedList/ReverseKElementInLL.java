package com.scaler.Scaler.LinkedList;

public class ReverseKElementInLL {
    public ListNode reverseList(ListNode A, int B) {
        if (A == null || B <= 1) {
            return A;
        }
        ListNode curr = A;
        ListNode prev = null;
        int c = B;
        while (c > 0 && A != null) {
            ListNode temp = A;
            A = A.next;
            temp.next = prev;
            prev = temp;
            c--;
        }
        curr.next = A;
        return prev;
    }


}
