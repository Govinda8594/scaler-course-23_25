package com.scaler.Scaler.LinkedList;

public class MergeSortOnUnSortedLinkedList {
    static ListNode midElement(ListNode A) {
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

    static ListNode mergeTwoLists(ListNode A, ListNode B) {
        if (A == null) {
            return B;
        }
        if (B == null) {
            return A;
        }
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
        if (A != null) {
            t.next = A;
        }
        if (B != null) {
            t.next = B;
        }
        return h;
    }

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }
        ListNode mid = midElement(A);
        ListNode h1 = mid.next;
        mid.next = null;
        ListNode t1 = sortList(A);
        ListNode t2 = sortList(h1);
        ListNode t3 = mergeTwoLists(t1, t2);
        return t3;
    }
}
