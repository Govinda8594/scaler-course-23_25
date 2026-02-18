package com.scaler.Scaler.LinkedList;
//Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
public class CheckPalindromicList {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * public int val;
     * public ListNode next;
     * ListNode(int x) { val = x; next = null; }
     * }
     */
    public int lPalin(ListNode A) {
        if (A == null || A.next == null) {
            return 1;
        }
        ListNode mid = midElement(A);
        ListNode t = mid.next;
        mid.next = null;
        t = rev(t);
        return checkEquals(A, t);
    }

    static int checkEquals(ListNode A, ListNode B) {
        while (A != null && B != null) {
            if (A.val != B.val) {
                return 0;
            }
            A = A.next;
            B = B.next;
        }
        return 1;
    }

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

    public ListNode rev(ListNode B) {
        ListNode prev = null;
        ListNode temp = B;
        ListNode curr = B;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
