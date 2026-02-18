package com.scaler.Scaler.LinkedList;

import java.util.HashSet;

//Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
//        Try solving it using constant additional space.
public class ReturnStartOfCycle {
    public ListNode detectCycle(ListNode a) {
        ListNode slow = a, fast = a;

        //move fast by 2 nodes and slow by one node, until
        //1- slow == fast -> loop found
        //2- fast != null && fast.next != null -> no loops found
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        // if slow !=fast -> no loop found
        if (slow != fast) return null;

        //set slow to head
        slow = a;

        //now move slow and fast by 1 node each, and stop when both reach same node
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public ListNode detectCycle2(ListNode A) {
        HashSet<ListNode> set = new HashSet<>();
        while (A != null) {
            if (set.contains(A))
                return A;
            else {
                set.add(A);
                A = A.next;
            }
        }
        return null;
    }
}
