package com.scaler.Scaler.LinkedList;

import java.util.HashSet;

public class FindIntersectionOfLinkedList {

    static ListNode findIntersection(ListNode A, ListNode B) {
        if (A == null || B == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<ListNode>();
        while (A != null) {
            set.add(A);
            A = A.next;
        }
        while (B != null) {
            if (set.contains(B)) {
                return B;
            }
            B = B.next;
        }
        return null;
    }

    static ListNode findIntersection2(ListNode A, ListNode B) {
        if (A == null || B == null) {
            return null;
        }
        ListNode t = A;
        while (t != null) {
            t = t.next;
        }
        t.next = B;
        return detectCycle(A);
    }

    public static ListNode detectCycle(ListNode a) {
        ListNode slow = a, fast = a;
        //move fast by 2 nodes and slow by one node, until
        //1- slow == fast -> loop found
        //2- fast != null && fast.next != null -> no loops found
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        // if slow !=fast -> no loop found
        if (slow != fast) {
            return null;
        }
        //set slow to head
        slow = a;
        //now move slow and fast by 1 node each, and stop when both reach same node
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }


}
