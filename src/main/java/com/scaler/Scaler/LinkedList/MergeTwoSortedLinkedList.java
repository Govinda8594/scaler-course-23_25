package com.scaler.Scaler.LinkedList;

public class MergeTwoSortedLinkedList {

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null) return B;
        if (B == null) return A;
        ListNode h = null, t = null;
        if (A.val < B.val) {
            h = A;
            t = A;
            A = A.next;
        } else {
            h = B;
            t = B;
            B = B.next;
        }
        while (A != null && B != null) {
            if (A.val < B.val) {
                t.next = A;
                t = t.next;
                A = A.next;
            } else {
                t.next = B;
                t = t.next;
                B = B.next;
            }
        }

        if (A != null) t.next = A;
        if (B != null) t.next = B;

        return h;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }
}
