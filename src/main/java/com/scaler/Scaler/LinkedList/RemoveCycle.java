package com.scaler.Scaler.LinkedList;
//You are given a linked list that contains a loop.
//        You need to find the node, which creates a loop and break it by making the node point to NULL.
public class RemoveCycle {

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * public int val;
     * public ListNode next;
     * ListNode(int x) { val = x; next = null; }
     * }
     */
    public ListNode solve(ListNode a) {
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
        ListNode t = slow;
        while (t.next != slow) {
            t = t.next;
        }
        t.next = null;
        return a;
    }
}
