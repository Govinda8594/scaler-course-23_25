package com.scaler.Scaler.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

//Given a list containing head pointers of N sorted linked lists.
//        Merge these given sorted linked lists and return them as one sorted list.
public class MergeKSortedLinkedList {

    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((c, b) -> c.val - b.val);
        for (ListNode node : a) {
            pq.add(node);
        }
        ListNode head = pq.poll();
        ListNode temp = head;
        if (head.next != null) {
            pq.add(head.next);
        }
        while (!pq.isEmpty()) {
            temp.next = pq.poll();
            temp = temp.next;
            if (temp.next != null) {
                pq.add(temp.next);
            }
        }
        return head;
    }


    class ListNode {
        int val;
        int min;
        ListNode next;

        ListNode(int data) {
            val = data;
            min = data;
            next = null;
        }
    }
}
